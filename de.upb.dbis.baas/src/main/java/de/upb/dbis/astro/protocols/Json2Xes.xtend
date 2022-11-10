package de.upb.dbis.astro.protocols

import com.google.gson.JsonElement
import com.google.gson.JsonParser
import io.swagger.v3.oas.models.OpenAPI
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.TimeZone
import java.util.regex.Pattern
import java.io.FileReader
import com.google.gson.stream.JsonReader
import java.util.Collections
import java.util.Arrays
import java.util.Comparator

class Json2Xes {
	
	
	public static String NOISE = "NOISE";
	
	protected def path2pattern(OpenAPI openAPI){
		
		
		val basePath = openAPI.servers.get(0).url.replace("///","/"); 
		//TODO get base path prefix
		var patterns = new HashMap<Pattern, String>();
		
		
		for (String key : openAPI.paths.keySet) {

			var path = openAPI.paths.get(key);

			var patternstring = key;//.replaceAll("\\{(.*)\\}", "(<$1>.*)");
			
			patternstring = patternstring.replace("{", "(?<");
			patternstring = patternstring.replace("}", ">.*)");
			
			var pattern = null as Pattern;
			
			
			if(path.get!==null){
				
				pattern = Pattern.compile("GET " + basePath + patternstring);
				patterns.put(pattern, path.get.operationId);
			}
			
			if(path.put!==null){
				
				pattern = Pattern.compile("PUT " + basePath + patternstring);
				patterns.put(pattern, path.put.operationId);
			}
			
			if(path.post!==null){
				
				pattern = Pattern.compile("(POST|OPTIONS) " + basePath + patternstring); //https://github.com/angular/angular/issues/7445
				patterns.put(pattern, path.post.operationId);
			}
			
			if(path.delete!==null){
				
				pattern = Pattern.compile("DELETE " + basePath + patternstring);
				patterns.put(pattern, path.delete.operationId);
			}			
			
			
		}
		
		return patterns;
	}

	
	def getCallTraces(String filePath, OpenAPI openapi){
		
		val result = new ArrayList<CallTrace>();
		val reader = new JsonReader(new FileReader(filePath));
		val root = new JsonParser().parse(reader);
		
		val hits = root.asJsonObject.getAsJsonObject("hits").getAsJsonArray("hits");
		
		val tz = TimeZone.getTimeZone("UTC");
		val dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX"); // Quoted "Z" to indicate UTC, no timezone offset
		dateFormat.setTimeZone(tz);		
		
		val path_parameter_pattern = Pattern.compile("<(.*?)>");
		
		val patterns = path2pattern(openapi);
		for(JsonElement item : hits){

			val source = item.asJsonObject.getAsJsonObject("_source");
			
			val calltrace = new CallTrace();
			
			val timestamp = source.getAsJsonPrimitive("@timestamp").asString; //"2019-02-13T13:28:44.669+0000",
			calltrace.timestamp = dateFormat.parse(timestamp);
			calltrace.clientHost = source.getAsJsonPrimitive("clientHost").asString; //"10.244.0.1",
			val requestURL = source.getAsJsonPrimitive("requestURL").asString; //"GET /api/requests/c5c68ea7-e78b-42c4-a156-6046648093c2/monitor_sources HTTP/1.1"
			calltrace.statusCode = source.getAsJsonPrimitive("statusCode").asString; //"500"
			
			val requestParts = requestURL.split(" ");
			calltrace.method = requestParts.get(0);
			calltrace.url = requestParts.get(1);
			
			var hasMatch = false;
			for(Pattern pattern: patterns.keySet){
			
					
				val matcher = pattern.matcher(calltrace.method+" "+calltrace.url);
				if(matcher.matches){
					hasMatch = true;
					calltrace.operationId = patterns.get(pattern);
					calltrace.parameterValues = new HashMap<String, String>();
					calltrace.url = pattern.pattern;
					
					val regexp = pattern.pattern;
					System.out.println(calltrace.url);
					System.out.println(regexp);
					
					val matcher2 = path_parameter_pattern.matcher(regexp);
					
					while (matcher2.find()) {
						
						
						var path_parameter_name = matcher2.group();
						System.out.println('''access «path_parameter_name»''');
						path_parameter_name = path_parameter_name.substring(1, path_parameter_name.length-1);
							
						
						val path_parameter_value = matcher.group(path_parameter_name);
						System.out.println('''«path_parameter_name»=«path_parameter_value»''');
						
						calltrace.parameterValues.put(path_parameter_name, path_parameter_value);
					}
					System.out.println("");
					
					result.add(calltrace);					
					
					//TODO 
					//List<NameValuePair> params = URLEncodedUtils.parse(new URI(url), "UTF-8");
				}

			}
			
			if(!hasMatch){
				System.out.println('''Error: «calltrace.url» not matched''');
				
			}
			
		}
		
		return result;
	}
	
	def cluster(List<CallTrace> traces){
		
		val clusters = new HashMap<String, List<CallTrace>>();
		
		clusters.put(NOISE, new ArrayList<CallTrace>());
		
		//val traces = new ArrayList<CallTrace>(traces_);
		
		Collections.sort(traces, new Comparator<CallTrace>(){
			
			override compare(CallTrace arg0, CallTrace arg1) {
				
				return arg0.timestamp.compareTo(arg1.timestamp);
				
			}
			
		});
		
		
		
		for(CallTrace trace: traces){
			
			System.out.println(trace.timestamp);
			
			if(trace.parameterValues.containsKey("requestUUID") && false){
				
				val value = trace.parameterValues.get("requestUUID");
				
				if(!clusters.containsKey(value)){
					clusters.put(value, new ArrayList<CallTrace>());	
				}
				
				val t = clusters.get(value);
				t.add(trace);
				clusters.put(value, t);
				
			}
			else{
				
				val t = clusters.get(NOISE);
				t.add(trace);
				clusters.put(NOISE, t);
			}
		}
		
		return clusters;
	}
	
	def print(HashMap<String, List<CallTrace>> traces){
		
		val tz = TimeZone.getTimeZone("UTC");
		//val dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
		val dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
		dateFormat.setTimeZone(tz);
		
		var content = '''
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
				«FOR String group : traces.keySet»
					<trace>
						<string key="concept:name" value="«group»"/>
						«FOR CallTrace event:traces.get(group)»
							<event>
								<date key="time:timestamp" value="«dateFormat.format(event.timestamp)»"/>
								<string key="concept:name" value="«event.operationId»"/>
								<string key="http_method" value="«event.method»"/>
							</event>
						«ENDFOR»
					</trace>
				«ENDFOR»
			</log>
		'''
		
		return content;
	}
}