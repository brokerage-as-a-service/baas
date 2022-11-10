package de.upb.dbis.baas.annotator

import io.swagger.v3.oas.models.OpenAPI
//import io.swagger.v3.oas.models.Operation
import java.util.ArrayList
import de.upb.dbis.baas.Operation
import de.upb.dbis.baas.BaasFactory
import de.upb.dbis.baas.discovery.NonNullArrayList
import java.util.List

class OpenApiUtil {
	
	static def getAllOperations(OpenAPI openAPI){
		
		var operations = new NonNullArrayList<Operation>();
		
		for(String key: openAPI.paths.keySet){
			
			
			operations.addAll(convert(openAPI.paths.get(key).get));
			operations.addAll(convert(openAPI.paths.get(key).post));
			operations.addAll(convert(openAPI.paths.get(key).delete));
			operations.addAll(convert(openAPI.paths.get(key).put));
			operations.addAll(convert(openAPI.paths.get(key).head));
			operations.addAll(convert(openAPI.paths.get(key).options));
			operations.addAll(convert(openAPI.paths.get(key).patch));
			
			
			
		}
		
		return operations;
	}
	
	static def List<Operation> convert(io.swagger.v3.oas.models.Operation op){
		
		
		if(op===null){
			return null;
		}
		
		var result = new ArrayList<Operation>();
		
		for(String responseCode: op.responses.keySet){
			
			//var response = op.responses.get(responseCode);
			
			var operation = BaasFactory.eINSTANCE.createOperation;
			operation.description = op.description
			operation.operationId = op.operationId
			operation.responseCode = responseCode;
			result.add(operation);
			
		}
		
		
		return result; 
	}
}