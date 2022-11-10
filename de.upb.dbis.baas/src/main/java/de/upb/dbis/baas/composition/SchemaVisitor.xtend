package de.upb.dbis.baas.composition

import io.swagger.v3.oas.models.media.ArraySchema
import io.swagger.v3.oas.models.media.BinarySchema
import io.swagger.v3.oas.models.media.BooleanSchema
import io.swagger.v3.oas.models.media.ByteArraySchema
import io.swagger.v3.oas.models.media.ComposedSchema
import io.swagger.v3.oas.models.media.DateSchema
import io.swagger.v3.oas.models.media.DateTimeSchema
import io.swagger.v3.oas.models.media.EmailSchema
import io.swagger.v3.oas.models.media.FileSchema
import io.swagger.v3.oas.models.media.IntegerSchema
import io.swagger.v3.oas.models.media.MapSchema
import io.swagger.v3.oas.models.media.NumberSchema
import io.swagger.v3.oas.models.media.ObjectSchema
import io.swagger.v3.oas.models.media.PasswordSchema
import io.swagger.v3.oas.models.media.Schema
import io.swagger.v3.oas.models.media.StringSchema
import io.swagger.v3.oas.models.media.UUIDSchema
import java.util.Collection
import java.util.HashMap
import java.util.HashSet
import java.util.Stack
import de.upb.dbis.baas.IO
import de.upb.dbis.baas.BaasFactory
import java.util.UUID

class SchemaVisitor {
	
	protected Stack<String> jsonPath = new Stack<String>();
	
	protected HashMap<String, IO> registry = new HashMap<String, IO>();
	
	protected String lastName = "";
	
	def Collection<IO> traverseRoot(Schema schema){
		
		if(schema!==null){
			
			jsonPath.push("$");
			traverseSchema(schema);
			jsonPath.pop();
		}
		
		
		return registry.values;
		
	}
	
	
	protected def void traverseSchema(Schema schema){
		
		if(schema.properties!==null){
			
			
			for(Object name :schema.properties.keySet){
				var item = schema.properties.get(name);
				jsonPath.push('''['«name»']''');
				if(item instanceof Schema){
					lastName = name as String;
					traverseSchema(item as Schema);
				}
				
				jsonPath.pop();
				
			}
		
		}
					
		
		if(schema instanceof BooleanSchema ||
			schema instanceof BinarySchema ||
			schema instanceof DateSchema ||
			schema instanceof DateTimeSchema ||
			schema instanceof EmailSchema ||
			schema instanceof FileSchema ||
			schema instanceof IntegerSchema ||
			schema instanceof NumberSchema ||
			schema instanceof PasswordSchema ||
			schema instanceof StringSchema ||
			schema instanceof UUIDSchema
		){
		
			var jsonPath_ = JsonPathHelper.printJsonPath(jsonPath);
		
			var output = null as IO;
			if(registry.containsKey(jsonPath)){
				output = registry.get(jsonPath);
			}
			else{
				output = BaasFactory.eINSTANCE.createIO();
				output.type = "output";
				output.uuid = UUID.randomUUID.toString;
			}
			
			output.name = lastName;
			//output.nameTokenized = AnalyzerHelper.normalize(AnalyzerHelper.ANALYZER_ID, lastName);
			
			output.jsonPath = JsonPathHelper.printJsonPath(jsonPath);
			//output.jsonPathTokenized = AnalyzerHelper.normalize(AnalyzerHelper.ANALYZER_ID, jsonPath_);
		 
			output.description = schema.description;
			//output.descriptionTokenized = AnalyzerHelper.normalize(AnalyzerHelper.ANALYZER_TEXT, output.descriptionRaw);
			
			output.datatype = schema.type;
			output.format = schema.format;
			
			registry.put(jsonPath_, output);		
		}
		else if(schema instanceof ArraySchema){
		
			//TODO arrays
			System.out.println("ArraySchema");
			
		}
		else if(schema instanceof ByteArraySchema){
			System.out.println("ByteArraySchema");
			
		}
		else if(schema instanceof ComposedSchema){
			System.out.println("ComposedSchema");
		}
		else if(schema instanceof MapSchema){
			System.out.println("MapSchema");
		}
		else if(schema instanceof ObjectSchema){
			System.out.println("ObjectSchema");
		}
		else{
			System.out.println("ElseSchema");
		}
		
		
	}
		
}