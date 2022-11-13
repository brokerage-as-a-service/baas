package de.upb.dbis.baas.composition

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.util.Map.Entry
import com.google.gson.JsonArray
import com.google.gson.JsonPrimitive
import java.util.Stack
import java.util.HashMap
import java.util.Collection
import de.upb.dbis.baas.IO
import de.upb.dbis.baas.BaasFactory
import java.util.UUID

class GsonExampleVisitor {
	
	protected Stack<String> jsonPath = new Stack<String>();
	
	protected HashMap<String, IO> registry = new HashMap<String, IO>();
	
	protected String lastName = "";
	
	def Collection<IO> traverseRoot(JsonElement root){
		
		jsonPath.push("$");
		traverseJsonElement(root);
		jsonPath.pop();
		
		return registry.values;
		
	}
	
	protected def void traverseJsonElement(JsonElement jsonElement){
				
		if(jsonElement.isJsonObject){
			traverseJsonObject(jsonElement.asJsonObject);
		}
		else if(jsonElement.isJsonArray){
			traverseJsonArray(jsonElement.asJsonArray);
		}
		else if(jsonElement.isJsonPrimitive){
			traverseJsonPrimitive(jsonElement.asJsonPrimitive);
		}
		else if(jsonElement.jsonNull){
		}
		
	}
	
	protected def void traverseJsonObject(JsonObject jsonObject) {
		
		
		for(Entry<String, JsonElement> item:jsonObject.entrySet){
		
			lastName = item.key;		
			//jsonPath.push('''['«item.key»']''');
			jsonPath.push('''«item.key»''');
			traverseJsonElement(item.value);
			
			jsonPath.pop();
		}
	}
	
	protected def void traverseJsonArray(JsonArray jsonArray) {
//		lastName = "";	
		var list = jsonArray.toList;
		
		for(var i=0; i < list.length; i++){
			var jsonElement = list.get(i);
			
			jsonPath.push('''[«i»]''');
			traverseJsonElement(jsonElement);
			jsonPath.pop();
		}
		
	}	
	
	protected def void traverseJsonPrimitive(JsonPrimitive jsonPrimitive) {
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
		
		//TODO output.nameRaw
		output.name = lastName;
		//output.nameTokenized = AnalyzerHelper.normalize(AnalyzerHelper.ANALYZER_ID, lastName);
		
		output.jsonPath = jsonPath_;
		//output.jsonPathTokenized = AnalyzerHelper.normalize(AnalyzerHelper.ANALYZER_ID, jsonPath_);
		 
		if(jsonPrimitive.isBoolean){
			output.datatype = "boolean"
			output.values.add(jsonPrimitive.asBoolean);
		}
		else if(jsonPrimitive.isNumber){
			output.datatype = "number"
			output.values.add(jsonPrimitive.asDouble);
		}
		else if(jsonPrimitive.isString){
			output.datatype = "string"
			output.values.add(jsonPrimitive.asString);
		}
		
		
		registry.put(jsonPath_, output);
	}
	
}