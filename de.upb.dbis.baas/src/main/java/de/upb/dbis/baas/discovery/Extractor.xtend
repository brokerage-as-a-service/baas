package de.upb.dbis.baas.discovery

import com.google.gson.JsonParser
import de.upb.dbis.baas.BaasFactory
import de.upb.dbis.baas.IO
import de.upb.dbis.baas.composition.SchemaVisitor
import io.swagger.v3.oas.models.Operation
import io.swagger.v3.oas.models.parameters.Parameter
import java.util.ArrayList
import java.util.List
import de.upb.dbis.baas.composition.JacksonExampleVisitor

class Extractor {
	
//	static def List<IO> allIOs(OpenAPI openapi){
//		
//		var operations = OpenApiUtil.getAllOperations(openapi);
//		
//		var ios = new ArrayList<IO>();
//		for(Operation operation: operations){
//			ios.addAll(Extractor.getInputs(operation));
//			ios.addAll(Extractor.getOutputs(operation)); 
//		}	
//			
//		return ios;
//	}
	
	
	static def List<IO> getInputs(Operation operation){
		
		var result = new ArrayList<IO>();
		
		if(operation!==null && operation.parameters!==null){
			
			for(Parameter parameter:operation.parameters){
				
				var input = BaasFactory.eINSTANCE.createIO();
				
				input.name = parameter.name;
				input.description = parameter.description;
				
				input.format = parameter.schema.format;
				input.datatype = parameter.schema.type;
				
				
				//TODO parameter.example / examples	
				
				result.add(input);
			}
		}
		
		
		return result;
		
	}
	
	static def getOutputs(Operation operation){
		
			var result = new ArrayList<IO>();
			
			if(operation!==null){
				
				val json = operation?.responses?.get("200")?.content?.get("application/json")?.example?.toString ?: "";
				
				//TODO examples plural
				
				val root = new JsonParser().parse(json);
				var outputs = new JacksonExampleVisitor().traverseRoot(root);
				result.addAll(outputs);
				
				val schema = operation?.responses?.get("200")?.content?.get("application/json")?.schema;
				outputs = new SchemaVisitor().traverseRoot(schema);
				
				result.addAll(outputs);
			}
			
			
			return result;			
			
	}
	

	

}
