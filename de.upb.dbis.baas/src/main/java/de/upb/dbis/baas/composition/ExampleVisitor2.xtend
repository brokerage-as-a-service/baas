package de.upb.dbis.baas.composition

import java.util.Map.Entry
import java.util.Stack
import java.util.HashMap
import java.util.Collection
import de.upb.dbis.baas.IO
import de.upb.dbis.baas.BaasFactory
import java.util.Map
import java.util.List
import java.util.UUID
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.BooleanNode
import com.fasterxml.jackson.databind.node.NumericNode
import com.fasterxml.jackson.databind.node.TextNode
import com.google.gson.JsonElement
import com.fasterxml.jackson.databind.JsonNode

class ExampleVisitor2 {
	
	protected Stack<String> jsonPath = new Stack<String>();
	
	protected HashMap<String, IO> registry = new HashMap<String, IO>();
	
	protected String lastName = "";
	
	def Collection<IO> traverseRoot(Object root){
		
		jsonPath.push("$");
		traverseJsonElement(root);
		jsonPath.pop();
		
		return registry.values;
		
	}
	
	protected def void traverseJsonElement(Object jsonElement){

		if(jsonElement instanceof ObjectNode){
			
			traverseJsonObject(jsonElement);
		}
		else if(jsonElement instanceof ArrayNode){
			
			traverseJsonArray(jsonElement);
		}		
		else if(jsonElement instanceof BooleanNode || jsonElement instanceof NumericNode || jsonElement instanceof TextNode){
			traverseJsonPrimitive(jsonElement);
		}
				
//		if(jsonElement.isJsonObject){
//			traverseJsonObject(jsonElement.asJsonObject);
//		}
//		else if(jsonElement.isJsonArray){
//			traverseJsonArray(jsonElement.asJsonArray);
//		}
//		else if(jsonElement.isJsonPrimitive){
//			traverseJsonPrimitive(jsonElement.asJsonPrimitive);
//		}
//		else if(jsonElement.jsonNull){
//		}
		
	}
	
	protected def void traverseJsonObject(ObjectNode jsonObject) {
		
		val iterator = jsonObject.fields;
		while(iterator.hasNext){
			val item = iterator.next;
			
			lastName = item.key;		
			jsonPath.push('''«item.key»''');
			traverseJsonElement(item.value);
			jsonPath.pop();
		}
		
	}
	
	protected def void traverseJsonArray(ArrayNode jsonArray) {
		lastName = "";	
		
		for(var i=0; i < jsonArray.size; i++){
			var jsonElement = jsonArray.get(i);
			
			jsonPath.push('''[«i»]''');
			traverseJsonElement(jsonElement);
			jsonPath.pop();
		}
		
	}
	
	protected def void traverseJsonPrimitive(Object jsonPrimitive) {
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
		 
		 
		if(jsonPrimitive instanceof BooleanNode){
			
			output.datatype = "boolean"
		}
		else if(jsonPrimitive instanceof TextNode){
			output.datatype = "string"
		}
		else if(jsonPrimitive instanceof NumericNode){
			output.datatype = "number"
		}
		 
		
		output.values.add(jsonPrimitive);
		
		registry.put(jsonPath_, output);
	}
	
}