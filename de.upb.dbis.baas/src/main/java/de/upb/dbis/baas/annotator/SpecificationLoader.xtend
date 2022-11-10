package de.upb.dbis.baas.annotator

import com.fasterxml.jackson.databind.node.ObjectNode
import com.google.gson.JsonElement
import de.upb.dbis.baas.IO
import de.upb.dbis.baas.Specification
import de.upb.dbis.baas.composition.ExampleVisitor
import de.upb.dbis.baas.composition.ExampleVisitor2
import de.upb.dbis.baas.composition.SchemaVisitor
import io.swagger.parser.OpenAPIParser
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.Operation
import io.swagger.v3.oas.models.parameters.Parameter
import io.swagger.v3.oas.models.responses.ApiResponse
import java.io.File
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import java.util.UUID
import de.upb.dbis.baas.BaasFactory

class SpecificationLoader {

	Map<String, Object> components = new HashMap<String, Object>();
	
	static int operations = 0;

	def List<Specification> doLoad(String path) {
		var directory = new File(path);
		return doLoad(directory);

	}

	def List<Specification> doLoad(File directory) {

		
		var result = new ArrayList<Specification>();

		if (directory.exists) {

			if (directory.isDirectory) {

				for (File file : directory.listFiles) {

					if (file.name.endsWith("json") || file.name.endsWith("yaml")) {
						var specification = load(file.absolutePath);

						if (specification !== null) {
							result.add(specification);
						}
					}
				}
			}
		}

		return result;

	}

	def load(String path) {
		var spec_in = new OpenAPIParser().readLocation(path, null, null);
		if (spec_in.openAPI !== null) {
			load(spec_in.openAPI);
		}
	}

	def load(List<OpenAPI> specs) {
		var result = new ArrayList<Specification>();
		for (OpenAPI openapi : specs) {
			result.add(load(openapi));
		}
		
		System.out.println('''#operations: «operations»''');
		return result;
	}

	def load(OpenAPI openAPI) {

		var spec_out = null as Specification;
		if (openAPI !== null) {

			var parameters = openAPI.components?.parameters ?: null;

			if (parameters !== null) {

				for (String key : parameters.keySet) {
					components.put("#/components/parameters/" + key, parameters.get(key));
				}
			}

			var responses = openAPI.components?.responses ?: null;

			if (responses !== null) {

				for (String key : responses.keySet) {
					components.put("#/responses/" + key, responses.get(key));
				}
			}
			var definitions = openAPI?.components?.schemas ?: null;

			if (definitions !== null) {

				for (String key : definitions.keySet) {
					components.put("#/definitions/" + key, definitions.get(key));
				}
			}

			spec_out = BaasFactory.eINSTANCE.createSpecification();
			spec_out.uuid = UUID.randomUUID.toString;
			spec_out.name = openAPI.info.title;
			spec_out.description = openAPI.info.description;
			spec_out.host = openAPI.servers?.get(0)?.url;

			if (openAPI.paths !== null && !openAPI.paths.empty) {

				for (String key_ : openAPI.paths.keySet) {

					var pathitem_in = openAPI.paths.get(key_);
					val key = key_.trim;
					spec_out.operations.addAll(operation(pathitem_in.get, "get", key));
					spec_out.operations.addAll(operation(pathitem_in.post, "post", key));
					spec_out.operations.addAll(operation(pathitem_in.put, "put", key));
					spec_out.operations.addAll(operation(pathitem_in.delete, "delete", key));
					spec_out.operations.addAll(operation(pathitem_in.options, "options", key));
					spec_out.operations.addAll(operation(pathitem_in.trace, "trace", key));
					spec_out.operations.addAll(operation(pathitem_in.head, "head", key));

				/*
				 * var operations_in = new ArrayList<Operation>();
				 * 
				 * operations_in.add(pathitem_in.get);
				 * operations_in.add(pathitem_in.post);
				 * operations_in.add(pathitem_in.put);
				 * operations_in.add(pathitem_in.delete);
				 * operations_in.add(pathitem_in.options);
				 * operations_in.add(pathitem_in.trace);
				 * operations_in.add(pathitem_in.head);
				 * 
				 * operations_in = operations_in.filterNull.toList as ArrayList<Operation>;
				 * 
				 * for(Operation operation_in :operations_in){
				 * 	
				 * 	var ios = new ArrayList<IO>();
				 * 	
				 * 	if(operation_in.parameters!==null){
				 * 		
				 * 		for(Parameter parameter_in: operation_in.parameters){
				 * 			
				 * 			var input = BaasFactory.eINSTANCE.createIO();
				 * 			input.uuid = UUID.randomUUID.toString;
				 * 			
				 * 			var dereferenced_parameter = parameter_in;
				 * 			
				 * 			if(components.containsKey(parameter_in.get$ref)){
				 * 				dereferenced_parameter = components.get(parameter_in.get$ref) as Parameter;
				 * 			}
				 * 			
				 * 			input.name = dereferenced_parameter.name;
				 * 			input.description = dereferenced_parameter.description;
				 * 			
				 * 			input.format = dereferenced_parameter?.schema?.format ?: null;
				 * 			input.datatype = dereferenced_parameter?.schema?.type ?: null;
				 * 	
				 * 			
				 * 			
				 * 			
				 * 			ios.add(input);
				 * 			//TODO parameter.example / examples	
				 * 			
				 * 			//TODO parameters from superordinate pathitem
				 * 			
				 * 		}				
				 * 	}
				 * 	
				 * 	
				 * 	if(operation_in.responses!==null && !operation_in.responses.empty){
				 * 		
				 * 	
				 * 		for(String responsecode : operation_in.responses.keySet){
				 * 			
				 * 			
				 * 			
				 * 			var operation_out = BaasFactory.eINSTANCE.createOperation();
				 * 			operation_out.uuid = UUID.randomUUID.toString;
				 * 			operation_out.operationId = operation_in.operationId;
				 * 			operation_out.description = operation_in.description;
				 * 			operation_out.summary = operation_in.summary;
				 * 			operation_out.responseCode = responsecode;
				 * 			operation_out.method = "TODO";
				 * 			operation_out.path = key;
				 * 			
				 * 			var ios_copy = new ArrayList<IO>(ios);
				 * 			operation_out.ios.addAll(ios_copy);
				 * 			
				 * 			
				 * 			var response_in = operation_in?.responses?.get(responsecode);
				 * 			var dereferenced_response = null as ApiResponse;
				 * 			
				 * 			if(response_in.$ref(response_in.get$ref)!==null){
				 * 				dereferenced_response = response_in.$ref(response_in.get$ref);
				 * 			}
				 * 			else{
				 * 				dereferenced_response = response_in;
				 * 				
				 * 			}
				 * 			
				 * 			val example = dereferenced_response?.content?.get("application/json")?.example ?: null;
				 * 			
				 * 			if(example !== null){
				 * 				
				 * 				
				 * 				var outputs = new ExampleVisitor2().traverseRoot(example);
				 * 				operation_out.ios.addAll(outputs);
				 * 				
				 * 			}
				 * 			//TODO examples plural
				 * 			
				 * 			val schema = dereferenced_response?.content?.get("application/json")?.schema ?: null;
				 * 			
				 * 			if(schema!==null){
				 * 				
				 * 				var outputs = new SchemaVisitor().traverseRoot(schema);
				 * 				operation_out.ios.addAll(outputs);
				 * 				//TODO merge ios from examples and schema
				 * 			}
				 * 			
				 * 			spec_out.operations.add(operation_out);
				 * 									
				 * 		}
				 * 	
				 * 	}
				 * 	else{
				 * 		var operation_out = BaasFactory.eINSTANCE.createOperation();
				 * 		operation_out.uuid = UUID.randomUUID.toString;
				 * 		operation_out.operationId = operation_in.operationId;
				 * 		operation_out.description = operation_in.description;
				 * 		operation_out.summary = operation_in.summary;
				 * 		
				 * 		var ios_copy = new ArrayList<IO>(ios);
				 * 		operation_out.ios.addAll(ios_copy);
				 * 		spec_out.operations.add(operation_out);
				 * 		
				 * 	}
				 * 	
				 * }
				 */
				// END
				}
			}

		}
		return spec_out;

	}

	def ArrayList<de.upb.dbis.baas.Operation> operation(Operation operation_in, String method, String pathitem) {

		var result = new ArrayList<de.upb.dbis.baas.Operation>();
		
		if(operation_in===null){
			return result;
		}
		
		var ios = new ArrayList<IO>();

		if (operation_in.parameters !== null) {

			for (Parameter parameter_in : operation_in.parameters) {

				var input = BaasFactory.eINSTANCE.createIO();
				input.uuid = UUID.randomUUID.toString;

				var dereferenced_parameter = parameter_in;

				if (components.containsKey(parameter_in.get$ref)) {
					dereferenced_parameter = components.get(parameter_in.get$ref) as Parameter;
				}

				input.name = dereferenced_parameter.name;
				input.description = dereferenced_parameter.description;

				input.format = dereferenced_parameter?.schema?.format ?: null;
				input.type = 'input';
				input.datatype = dereferenced_parameter?.schema?.type ?: null;

				
				input.^default = dereferenced_parameter?.schema?.example?.toString ?: null;
				ios.add(input);
				
				
				
			// TODO parameter.example / examples	
			// TODO parameters from superordinate pathitem
			}
		}
		
		if(operation_in.requestBody!==null){

			val example = operation_in.requestBody?.content?.get("application/json")?.example ?: null;
			if (example !== null && example instanceof JsonElement) {
				var outputs = new ExampleVisitor().traverseRoot(example as JsonElement);
				ios.addAll(outputs);

			}	
			//TODO use one of the implementations
			else if (example !== null && example instanceof ObjectNode) {
				var outputs = new ExampleVisitor2().traverseRoot(example as ObjectNode);
				
				outputs.forEach[i|i.type="input"];
				
				ios.addAll(outputs);

			}
		}

		if (operation_in.responses !== null && !operation_in.responses.empty) {

			for (String responsecode : operation_in.responses.keySet) {

				var operation_out = BaasFactory.eINSTANCE.createOperation();
				operation_out.uuid = UUID.randomUUID.toString;
				operation_out.operationId = operation_in.operationId;
				operation_out.description = operation_in.description;
				operation_out.summary = operation_in.summary;
				operation_out.responseCode = responsecode;
				operation_out.method = method;
				operation_out.path = pathitem;

				var ios_copy = new ArrayList<IO>(ios);
				operation_out.ios.addAll(ios_copy);

				var response_in = operation_in?.responses?.get(responsecode);
				var dereferenced_response = null as ApiResponse;

				if (response_in.$ref(response_in.get$ref) !== null) {
					dereferenced_response = response_in.$ref(response_in.get$ref);
				} else {
					dereferenced_response = response_in;

				}

				val example = dereferenced_response?.content?.get("application/json")?.example ?: null;
				
				//TODO just use one implementation
				if (example !== null && example instanceof JsonElement) {
					var outputs = new ExampleVisitor().traverseRoot(example as JsonElement);
					operation_out.ios.addAll(outputs);

				}
				else if (example !== null && example instanceof ObjectNode) {
					var outputs = new ExampleVisitor2().traverseRoot(example as ObjectNode);
					operation_out.ios.addAll(outputs);

				}
				
				
				// TODO examples plural
				val schema = dereferenced_response?.content?.get("application/json")?.schema ?: null;

				if (schema !== null) {

					var outputs = new SchemaVisitor().traverseRoot(schema);
					operation_out.ios.addAll(outputs);
				// TODO merge ios from examples and schema
				}

				result.add(operation_out);
				operations++;

			}

		} else {
			var operation_out = BaasFactory.eINSTANCE.createOperation();
			operation_out.uuid = UUID.randomUUID.toString;
			operation_out.operationId = operation_in.operationId;
			operation_out.description = operation_in.description;
			operation_out.summary = operation_in.summary;
			operation_out.method = method;
			operation_out.path = pathitem;

			var ios_copy = new ArrayList<IO>(ios);
			operation_out.ios.addAll(ios_copy);
			result.add(operation_out);
			operations++;

		}
		return result;
	}
}
