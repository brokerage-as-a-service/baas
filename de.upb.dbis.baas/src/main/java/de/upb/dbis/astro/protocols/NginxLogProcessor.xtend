package de.upb.dbis.astro.protocols

import io.swagger.parser.OpenAPIParser
import io.swagger.v3.oas.models.OpenAPI
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.util.HashMap
import java.util.regex.Pattern
import java.util.LinkedHashMap
import java.util.Arrays
import java.util.Comparator
import java.util.Collections
import java.util.ArrayList

class NginxLogProcessor {
	
	public static def main(String[] args){
		new NginxLogProcessor().read()
		return
		
	}
	
	LinkedHashMap<Pattern, String> sortedPatterns = new LinkedHashMap<Pattern, String>(); 
	HashMap<String, StringBuffer> traces = new HashMap<String, StringBuffer>()
	
	def path2pattern(OpenAPI openAPI){
		
		
		val basePath = "" //openAPI.servers.get(0).url.replace("///","/");
		
		val patterns = new HashMap<Pattern, String>(); 
		
		for (String key : openAPI.paths.keySet) {

			var path = openAPI.paths.get(key);

			var patternstring = key;//.replaceAll("\\{(.*)\\}", "(<$1>.*)");
			
			patternstring = patternstring.replace("{", "(?<");
			patternstring = patternstring.replace("}", ">.*)");
			
			var pattern = null as Pattern;
			
			
			if(path.get!==null){
				
				pattern = Pattern.compile("GET " + basePath + patternstring);
				
				patterns.put(pattern, "GET "+key);
			}
			
			if(path.put!==null){
				
				pattern = Pattern.compile("PUT " + basePath + patternstring);
				patterns.put(pattern, "PUT "+key);
			}
			
			if(path.post!==null){
				
				pattern = Pattern.compile("POST " + basePath + patternstring);
				patterns.put(pattern, "POST "+key);
			}
			
			if(path.delete!==null){
				
				pattern = Pattern.compile("DELETE " + basePath + patternstring);
				patterns.put(pattern, "DELETE "+key);
			}			
			
		}
		
		var arraylist = new ArrayList<Pattern>(patterns.keySet)
		
		Collections.sort(arraylist, new Comparator<Pattern>(){
			
			override compare(Pattern o1, Pattern o2) {
				return patterns.get(o2).split("/").size() - patterns.get(o1).split("/").size()
			}
			
		})
		
		for(Pattern p : arraylist){
			sortedPatterns.put(p, patterns.get(p))
		}
		
		return sortedPatterns;
	}
	
	def generalize(String path){
		for(Pattern pattern:sortedPatterns.keySet()){
			
			val matcher = pattern.matcher(path);
			if(matcher.matches){
				return sortedPatterns.get(pattern)
			}
		}
	}
	
	def read(){

		val filepath = "C:/data/repos2/example-simphera/de.upb.dbis.baas.example.simphera/data/simphera.json"
		val spec = new OpenAPIParser().readLocation(filepath, null, null);
		path2pattern(spec.openAPI)
		
		var count=10

		
		try {
			val reader = new BufferedReader(new FileReader("./data/call.log"));
			var line = reader.readLine();

			while (line !== null) {
				line = reader.readLine();
							
				
				if(line?.startsWith("[")){
					
					val parts = line.split(" ")
					
					if(parts.length===8){
						
						val timestamp = parts.get(0).substring(1, parts.get(0).length-2);
						val method = parts.get(2).substring(1)
						var path = parts.get(3)
						if(path.contains("?")){
							path = path.substring(0,path.indexOf("?"))
						}
						
						val path_generalized = generalize(method + " "+ path)
						val statuscode = parts.get(5);
						
						val token = parts.get(7).substring(0, parts.get(7).length-2)
						
						if(path.startsWith("/api") && #["201", "202"].contains(statuscode)){
							
//							System.out.println('''«timestamp» «path_generalized» «token»''')
							
							
							val sb = traces.get(token) ?: new StringBuffer()
							sb.append('''
								<event>
									<date key="time:timestamp" value="2022-12-05T07:18:«count++».886+0000" />
									<string key="concept:name" value="«path_generalized»" />
								</event>
							''')
							traces.put(token, sb)
							
						}
						else{
							println('''«path» «path_generalized» «statuscode»''')
						}
					
					}
					else{
						println("not 8: "+line)
					}
											
				}
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		print()
		
	}
	
	def print(){
		val content = '''
			<?xml version="1.0" encoding="UTF-8" ?>
			<log xes.version="1.0" xes.features="nested-attributes" openxes.version="1.0RC7" xmlns="http://www.xes-standard.org/">
				<extension name="Lifecycle" prefix="lifecycle" uri="http://www.xes-standard.org/lifecycle.xesext"/>
				<extension name="Organizational" prefix="org" uri="http://www.xes-standard.org/org.xesext"/>
				<extension name="Time" prefix="time" uri="http://www.xes-standard.org/time.xesext"/>
				<extension name="Concept" prefix="concept" uri="http://www.xes-standard.org/concept.xesext"/>
				<extension name="Semantic" prefix="semantic" uri="http://www.xes-standard.org/semantic.xesext"/>
				<global scope="trace">
					<string key="concept:name" value="__INVALID__"/>
				</global>
				<global scope="event">
					<string key="concept:name" value="__INVALID__"/>
					<string key="lifecycle:transition" value="complete"/>
				</global>
				<classifier name="Event Name" keys="concept:name"/>
				<string key="source" value="CPN Tools"/>
				<string key="concept:name" value="excercise7.mxml"/>
				<string key="lifecycle:model" value="standard"/>
				<string key="description" value="Log file created in CPN Tools"/>
				<trace>
				«FOR String group : traces.keySet»
					«traces.get(group)»
				«ENDFOR»
				</trace>
			</log>
		'''
		print(content)
	}
	
	
	
}