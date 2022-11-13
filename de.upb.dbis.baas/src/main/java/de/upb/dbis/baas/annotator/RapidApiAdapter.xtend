package de.upb.dbis.baas.annotator

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import com.google.gson.stream.JsonReader
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.Operation
import io.swagger.v3.oas.models.PathItem
import io.swagger.v3.oas.models.Paths
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.media.Content
import io.swagger.v3.oas.models.media.MediaType
import io.swagger.v3.oas.models.media.Schema
import io.swagger.v3.oas.models.parameters.Parameter
import io.swagger.v3.oas.models.parameters.Parameter.StyleEnum
import io.swagger.v3.oas.models.parameters.RequestBody
import io.swagger.v3.oas.models.responses.ApiResponse
import io.swagger.v3.oas.models.responses.ApiResponses
import io.swagger.v3.oas.models.servers.Server
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.ArrayList
import java.util.List
import java.util.regex.Pattern

class RapidApiAdapter {

	JsonObject root;
	
	def List<OpenAPI> doLoad(String path){
		var directory = new File(path);
		return loadFromDirectory(directory);
		
	}
	
	def List<OpenAPI> loadFromDirectory(File directory){
		
		var result = new ArrayList<OpenAPI>();
		
		if(directory.exists){
			
			if(directory.isDirectory){
				
				for(File file:directory.listFiles){
					
					if(file.name.endsWith("json") || file.name.endsWith("yaml")){
						var specification = loadFile(file);
						
						if(specification!==null){
							result.add(specification);
						}
					}
				}
			}
		}
		
		return result;
		
	}	
	
	def OpenAPI loadFile(File file){
		
		var fis	= new FileInputStream(file);
		var isr = new InputStreamReader(fis)

		
		var reader = new JsonReader(isr);
		var filename = file.name;
		
		root = new JsonParser().parse(reader).asJsonObject;
		var spec = new OpenAPI();
		
		
		//var name_ = root.get("name").asString; //v1
		
		var info = new Info();
		spec.openapi = "3.0.0";
		var apiname = filename.split("_").get(1); //aaronfessler_twinesocial
		
		info.title = apiname; //TODO get title from HTML?
		if(root.has("description")){
			
			var description = root.get("description").asString; 
			//fix for motokaug_motoka-ug
			description = description.replaceAll("\\P{Print}", "");
			info.description = description;
			
		}
		
		spec.info = info;
		//spec.host = '''«apiname».p.mashape.com''';//TODO https://yoda.p.mashape.com/yoda, https://twinesocial.p.mashape.com/v1/content, https://rlanegger-lufthansa-open-v1.p.mashape.com
		
		var server = new Server();
		server.url = filename.replace(".json","");
		spec.servers = new ArrayList<Server>();
		spec.servers.add(server);
		
		if(root.get("endpoints")!==null){
			
			if(root.get("endpoints").isJsonObject){
				
				if(root.get("endpoints").asJsonObject.get("data")!==null){
					
					if(root.get("endpoints").asJsonObject.get("data").isJsonArray){
						
						var data = root.get("endpoints").asJsonObject.get("data").asJsonArray;
						
						for(JsonElement item : data.toList){
							
							var statistics = new Statistics();
							statistics.host = spec.servers.get(0).url;
							
							var o = item.asJsonObject;
							var description_operation_ = o.get("description");
							
							var method_ = o.get("method");
							var slugifiedPrimary_ = o.get("slugifiedPrimary");
							var id = o.get("id");
							var route_ = o.get("route");
							
							
							statistics.endpoint = route_.asString;
							
							if(spec.paths===null){
								spec.paths = new Paths();
							}
							
							var paths = spec.paths;
							
							var pathitem = new PathItem();
							if(route_!==null){
								
								var route = route_.asString;
								route = route.replace("{", ":");
								route = route.replace("}","");
								
								
								/*
								 * HACK: some lazy ass API providers specified always "/" as route. 
								 * So, I append spaces to make the route "distinguishable". 
								 * Before database import, spaces are trimmed.
								 */
								while(paths.containsKey(route)){
									
									route = route+ " ";
								}
								
								
								paths.addPathItem(route, pathitem)
								
							}
							
							
							
							var operation = new Operation();
							operation.parameters = new ArrayList<Parameter>();
							
							if(description_operation_!==null){
								
								operation.description = description_operation_.asString; //should be less than 120 characters
							}
							
							if(slugifiedPrimary_!==null){
								
								operation.operationId = slugifiedPrimary_.asString
							}
							else{
								operation.operationId = id.asString
							}
							
							
							if(method_!==null){
								
								if(method_.asString.toLowerCase.equals("get")){
									pathitem.get = operation; 
									
									statistics.get = 1;
								}
								else if(method_.asString.toLowerCase.equals("post")){
									pathitem.post = operation; 
									statistics.post = 1;
								}
								else if(method_.asString.toLowerCase.equals("put")){
									pathitem.put = operation;
									statistics.put = 1; 
								}
								else if(method_.asString.toLowerCase.equals("delete")){
									pathitem.delete = operation;
									statistics.delete = 1;
								}
								else if(method_.asString.toLowerCase.equals("options")){
									pathitem.options = operation;
									statistics.options = 1;
								}
								else if(method_.asString.toLowerCase.equals("head")){
									pathitem.head = operation;
									statistics.head = 1;
								}
								else if(method_.asString.toLowerCase.equals("patch")){
									pathitem.patch = operation;
									statistics.patch = 1;
								}
					
							}
							
							
							
							var response_ = o.get("response");
							
							if(response_!==null){
								
								operation.responses = new ApiResponses();
								
								
								
								var response = new ApiResponse();
								
								var content = new Content();
								var mediatype = new MediaType();
								
								if(response_.asJsonObject.has("format")){
									
									if(response_.asJsonObject.get("format").asString.toLowerCase.equals("json")){
										
										if(response_.asJsonObject.has("body")){
											
											
											//TODO introduce classes JsonArray, JsonObject, JsonPrimitive to OpenAPI model and model example by these concepts
											
											var body = response_.asJsonObject.get("body").asString;
											if(body.startsWith("{") || body.startsWith("[")){
												
												statistics.response_examples_json++;
												
												try{
													var json = new JsonParser().parse(body);
													mediatype.example = json;
													statistics.responses_examples_json_valid++;
													
												}
												catch(JsonSyntaxException e){
													e.printStackTrace();
												}
												
												/*
												try{
													
													var mapper = Json.mapper()
													var json = mapper.readTree(body);
													mediatype.example = json;
													
													statistics.responses_examples_json_valid++;
													
													
													
												}
												catch(Exception e){
													
													System.out.println('''parser error in «body»''');
												}
												*/
												
																							
											}
											else if(body.startsWith("<")){
												//TODO convert with JAXB
											}

										}
									}
									else{
										
									}
								}
								
								content.addMediaType("application/json", mediatype);
								
								response.content = content;
								
								if(response_.asJsonObject.has("description")){
									
									response.description = response_.asJsonObject.get("description").asString;
								}
								
								if(o.has("code")){
									
									operation.responses.addApiResponse(o.get("code").asString, response);
									
									statistics.response_codes.add(o.get("code").asString);
								}
								
								
							}
							
							if(o.has("payload")){
								
								if(o.get("payload").isJsonObject){
									statistics.body++;
									
									var request_body = new RequestBody();
									var content = new Content();
									var mediatype = new MediaType();
									
									var payload = o.get("payload").asJsonObject;
									mediatype.example = payload;
									
									if(payload.has("name")){
										
										var parametername = payload.get("name").asString;
										content.addMediaType(parametername, mediatype);

									}
									request_body.content = content;
									
									if(payload.has("description")){
										request_body.description = payload.get("description").asString;
									}
									
									operation.requestBody = request_body;
									
									
																	
									if(payload.has("format")){ //JSON, BINARY, TEXT
										//TODO validate
									}
									
									
								}
								
							}
							
							if(o.has("parameters")){
								
								if(o.get("parameters").isJsonObject){
									
									if(o.get("parameters").asJsonObject.has("data")){
										
										if(o.get("parameters").asJsonObject.get("data").isJsonArray){
										
											var parameters = o.get("parameters").asJsonObject.get("data").asJsonArray
											
											for(JsonElement item2 : parameters.toList){
												var o2 = item2.asJsonObject;
												
													
												//var status_ = o.get("status").asString; //"ACTIVE"
												//TODO only if status_ = ACTIVE?
					
												var parameter = new Parameter();
												
												parameter.in = "query";
												parameter.style = StyleEnum.FORM;
												statistics.formData++;
												
												if(o2.has("name")){
													
													var parametername = o2.get("name").asString;
													
													parameter.name = parametername; //"bid"

												}
												
												if(o2.has("required")){
													
													parameter.required = o2.get("required").asString.equals("REQUIRED"); //"REQUIRED"
												}
												
												if(o2.has("condition")){
													
													parameter.required = o2.get("condition").asString.equals("REQUIRED"); //"REQUIRED"
												}
												
												if(o2.has("description")){
													
													parameter.description = o2.get("description").asString;
												}
												
												if(o2.has("type")){
													var type_ = o2.get("type").asString
													
													parameter.schema = new Schema();
													if(type_.toLowerCase.equals("string")){
														parameter.schema.type = "string";
														statistics.parameter_string++;
													}
													else if(type_.toLowerCase.equals("number")){
														parameter.schema.type = "number";
														parameter.schema.format = "double";
														statistics.parameter_number++;
													}
													if(type_.toLowerCase.equals("boolean")){
														parameter.schema.type = "boolean";
														statistics.parameter_boolean++;
													}
													if(type_.toLowerCase.equals("binary")){
														parameter.schema.type = "string";
														parameter.schema.format = "binary";
														statistics.parameter_binary++;
													}
													

												}
												
												operation.parameters.add(parameter);
													
											}
										}
										
									}
										
								}
										
							}
							
							
							if(o.has("routeparameters")){
								
								if(o.get("routeparameters").isJsonObject){
									
									if(o.get("routeparameters").asJsonObject.has("data")){
										
										if(o.get("routeparameters").asJsonObject.get("data").isJsonArray){
										
											var data2 = o.get("routeparameters").asJsonObject.get("data").asJsonArray
											
											statistics.parameters = data2.length;
											
											for(JsonElement item2 : data2.toList){
												var o2 = item2.asJsonObject;
													
												//var status_ = o.get("status").asString; //"ACTIVE"
												//TODO only if status_ = ACTIVE?
					
												var parameter = new Parameter();
												
												parameter.in = "query";
												
												if(o2.has("name")){
													
													var parametername = o2.get("name").asString;
													
													parameter.name = parametername; //"bid"
													
													if(parameter.name.contains("[")){
														System.out.println('''«apiname» uses special character for input parameter «parameter.name»''');
														
														parameter.name = parameter.name.replace("[","").replace("]","");
													}
													

													
													var pattern = Pattern.compile("[?].*=\\{"+parameter.name+"\\}");
													
														
													//if(route_.asString.matches(patt)){
													if(pattern.matcher(route_.asString).find){
														
														parameter.in = "query";
														statistics.query++;
													}
													else{ //} if(route_.asString.contains('''?«parameter.name»''')){
														
														parameter.in = "path";
														statistics.path++;
														
														//FIXME createQueryParameterSubSchema
													}
													
												}
												
												if(o2.has("required")){
													
													parameter.required = o2.get("required").asString.equals("REQUIRED"); //"REQUIRED"
												}
												
												if(o2.has("condition")){
													
													parameter.required = o2.get("condition").asString.equals("REQUIRED"); //"REQUIRED"
												}
												
												if(o2.has("description")){
													
													parameter.description = o2.get("description").asString;
												}
												

												
												if(o2.has("type")){
													var type_ = o2.get("type").asString
													
													parameter.schema = new Schema();
													
													if(type_.toLowerCase.equals("string")){
														parameter.schema.type = "string";
														statistics.parameter_string++;
													}
													else if(type_.toLowerCase.equals("number")){
														parameter.schema.type = "number";
														parameter.schema.format = "double";
														statistics.parameter_number++;
													}
													if(type_.toLowerCase.equals("boolean")){
														parameter.schema.type = "boolean";
														statistics.parameter_boolean++;
													}
													if(type_.toLowerCase.equals("binary")){
														parameter.schema.type = "string";
														parameter.schema.format = "binary";
														statistics.parameter_binary++;
													}
													
												}
												
												if(o2.has("value")){
													parameter.schema.example = o2.get("value");
												}
												
												operation.parameters.add(parameter);
													
											}
										}
										
									}
										
								}
										
							}
							
							if(o.has("headers")){
								
								if(o.get("headers").isJsonObject){
									
									if(o.get("headers").asJsonObject.has("data")){
										
										if(o.get("headers").asJsonObject.get("data").isJsonArray){
										
											var headers = o.get("headers").asJsonObject.get("data").asJsonArray
											
											
											for(JsonElement item2 : headers.toList){
												
												var header = item2.asJsonObject;
												
												System.out.println('''Header found in «filename»: «header.asJsonObject.get("name").asString»: «header.asJsonObject.get("type").asString»''');
												
												var parameter = new Parameter();
												parameter.in = "header"
												
												statistics.header++;
												
												if(header.has("name")){
													
													var headername = header.get("name").asString;
													parameter.name = headername; //"bid"
													
												}
												
												if(header.has("condition")){
													
													parameter.required = header.get("condition").asString.equals("REQUIRED"); //"REQUIRED"
												}
												
												if(header.has("description")){
													
													parameter.description = header.get("description").asString;
												}
												
												if(header.has("type")){
													var type_ = header.get("type").asString
													parameter.schema = new Schema();
													if(type_.toLowerCase.equals("string")){
														parameter.schema.type = "string";
														statistics.parameter_string++;
													}
													else if(type_.toLowerCase.equals("number")){
														parameter.schema.type = "number";
														parameter.schema.format = "double";
														statistics.parameter_number++;
													}
													else if(type_.toLowerCase.equals("boolean")){
														parameter.schema.type = "boolean";
														statistics.parameter_boolean++;
													}
													else if(type_.toLowerCase.equals("binary")){
														parameter.schema.type = "string";
														parameter.schema.format = "binary";
														statistics.parameter_binary++;
													}
													
												}
												
												operation.parameters.add(parameter);
											}

													
										}
									}
										
								}
							}							
							
							statistics.write();
						}
						
					}
				}
			}
		}
		
		fis.close;
		isr.close;

		
		return spec;
	}
	
	
	private def isValidJson(String json){
		try{
			
			new JsonParser().parse(json);
			return true;
		}
		catch(JsonSyntaxException e){
			e.printStackTrace();
		}
		return false;
	}


	
}
