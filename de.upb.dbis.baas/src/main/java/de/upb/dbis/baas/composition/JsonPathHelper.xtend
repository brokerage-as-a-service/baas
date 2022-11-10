package de.upb.dbis.baas.composition

import java.util.Stack

class JsonPathHelper {
	
	static def String printJsonPath(Stack<String> segments){
		return printJsonPath(segments, true);
	}
	
	static def String printJsonPath(Stack<String> segments, boolean wildcardIndices){
		
		var buffer = new StringBuffer();
		
		var iter = segments.iterator;
		while(iter.hasNext){
			
			var segment = iter.next;
			if(wildcardIndices && segment.matches('\\[\\d*\\]')){
				buffer.append("[*]");
			}
			else{
				
				buffer.append(segment);
			}
			
			if(iter.hasNext){
				buffer.append(".");
			}
		}
		
		return buffer.toString;
	}
}