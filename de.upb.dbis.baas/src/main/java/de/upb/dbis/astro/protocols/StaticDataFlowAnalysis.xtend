package de.upb.dbis.astro.protocols

import de.upb.dbis.baas.IO
import de.upb.dbis.baas.composition.JacksonExampleVisitor
import de.upb.dbis.baas.composition.SchemaVisitor
import io.swagger.parser.OpenAPIParser
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.Operation
import io.swagger.v3.oas.models.media.Schema
import io.swagger.v3.oas.models.parameters.Parameter
import io.swagger.v3.oas.models.responses.ApiResponse
import io.swagger.v3.parser.core.models.ParseOptions
import java.io.File
import java.util.HashMap
import java.io.BufferedWriter
import java.io.FileWriter
import com.fasterxml.jackson.databind.node.BaseJsonNode

class StaticDataFlowAnalysis {

	HashMap<String, Object> components = new HashMap<String, Object>();
	SchemaVisitor schemavisitor = null
	HashMap<String, Integer> statistics = new HashMap<String, Integer>()
	static File file = new File("results/simphera.gen.yaml")

	static def void main(String[] args) {
		new StaticDataFlowAnalysis().load(
			"C:/data/repos2/example-simphera/de.upb.dbis.baas.example.simphera/data/")
	}
	
	new(){
		if(!file.parentFile.exists){
			file.parentFile.mkdirs
		
		}
		
		if(file.exists){
			
			file.delete
		}
		
		file.createNewFile
		
	}

	def load(String path) {
		
		load(new File(path))

	}
	
	def void load(File file){
		
		if(file.exists){
			if(file.directory){
				for(File child :file.listFiles){
					load(child)
				}
			}
			else if(file.file){
				
				var options = new ParseOptions();
				
				var spec_in = new OpenAPIParser().readLocation(file.absolutePath, null, options);
				if (spec_in.openAPI !== null) {
					load(spec_in.openAPI);
				}	
			}
		}
		
	}

	def load(OpenAPI openAPI) {
		val sb = new StringBuffer()
		var definitions = openAPI?.components?.schemas ?: null;

		if (definitions !== null) {

			for (String key : definitions.keySet) {
				components.put("#/components/schemas/" + key, definitions.get(key));
			}
		}
		schemavisitor = new SchemaVisitor(components)

		if (openAPI !== null) {
			val baseurl = openAPI.servers?.iterator?.next?.url ?: ""
			
			if (openAPI.paths !== null && !openAPI.paths.empty) {

				for (String key_ : openAPI.paths.keySet) {

					count("paths2")
					var pathitem_in = openAPI.paths.get(key_);
					
					val key = key_.trim;
					sb.append(operation(pathitem_in.get, baseurl, "get", key));
					sb.append(operation(pathitem_in.post, baseurl, "post", key));
					sb.append(operation(pathitem_in.put, baseurl, "put", key));
					sb.append(operation(pathitem_in.delete, baseurl, "delete", key));
					sb.append(operation(pathitem_in.options, baseurl, "options", key));
					sb.append(operation(pathitem_in.trace, baseurl, "trace", key));
					sb.append(operation(pathitem_in.head, baseurl, "head", key));
					sb.append(operation(pathitem_in.patch, baseurl, "patch", key));
				}
			}
		}
		write(sb.toString)
		System.out.println(statistics)
		

	}


	protected def count(String key){
		
		var x = 0
		if(statistics.containsKey(key)){
			x = statistics.get(key)
		}
		x++
		statistics.put(key, x)
		
	}

	 
	 protected def write(String line){
		

		
		//System.out.println(line);
	 	var output = new BufferedWriter(new FileWriter(file.absolutePath, true));  //clears file every time
	 	
	 	
		output.append(line+"\n");
		output.close();
	}

	def operation(Operation operation_in, String baseurl, String method, String pathitem) {
		
		val sb = new StringBuffer()
		val deprecated = operation_in?.deprecated ?: false
		if (operation_in !== null && !deprecated) {
			count("path")
			count(method)
			sb.append('''- path: "«method.toUpperCase» «baseurl»«pathitem»"''')
			sb.append("\n")

			if (operation_in.parameters !== null) {
				sb.append('''  inputs:''')
				sb.append("\n")
				for (Parameter parameter_in : operation_in.parameters) {
					sb.append('''    "«parameter_in.name»": ""''')
					sb.append("\n")
				}

			}

			if (operation_in.requestBody !== null) {

				var example = operation_in.requestBody?.content?.get("application/json")?.example ?: null;
				if(example===null){
					operation_in.requestBody?.content?.get("application/json-patch+json")?.example ?: null;
				}
				
				if (example !== null && example instanceof BaseJsonNode) {
					var outputs = new JacksonExampleVisitor().traverseRoot(example);
					for (IO output : outputs) {
						sb.append('''    "«output.jsonPath»": ""''')
						sb.append("\n")
					}
				}

			}

			sb.append('''  outputs:''')
			sb.append("\n")
			if (operation_in.responses !== null && !operation_in.responses.empty) {

				for (String responsecode : operation_in.responses.keySet) {

					if (#["200", "201"].contains(responsecode)) {

						System.out.println('''«responsecode»: «method» «pathitem»''')
						var response_in = operation_in?.responses?.get(responsecode);

						var dereferenced_response = null as ApiResponse;

						if (response_in.$ref(response_in.get$ref) !== null) {
							dereferenced_response = response_in.$ref(response_in.get$ref);
						} else {
							dereferenced_response = response_in;

						}

						val example = dereferenced_response?.content?.get("application/json")?.example ?: null;
						
						val schema = dereferenced_response?.content?.get("application/json")?.schema											
						val schemaref = dereferenced_response?.content?.get("application/json")?.schema?.get$ref ?: null
						
						

						if (example !== null && example instanceof BaseJsonNode) {
							var outputs = new JacksonExampleVisitor().traverseRoot(example);
							System.out.println("from example")
							for (IO output : outputs) {
								sb.append('''    "«output.jsonPath»": ""''')
								sb.append("\n")
							}

						}

						else if (schemaref !== null) {

							var outputs = schemavisitor.traverseRoot(components.get(schemaref) as Schema);
							System.out.println("from schema")
							for (IO output : outputs) {
								sb.append('''    "«output.jsonPath»": ""''')
								sb.append("\n")
							}
						}
						else{
							var outputs = schemavisitor.traverseRoot(schema);
							System.out.println("from schema")
							for (IO output : outputs) {
								sb.append('''    "«output.jsonPath»": ""''')
								sb.append("\n")
							}							
						}

					}

				}

			}

		}
		
		sb.toString
	}
}
