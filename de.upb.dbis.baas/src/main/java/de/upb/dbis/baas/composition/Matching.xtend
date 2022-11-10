package de.upb.dbis.baas.composition

import de.upb.dbis.baas.BaasFactory
import de.upb.dbis.baas.IO
import de.upb.dbis.baas.IOMapping
import java.util.ArrayList
import java.util.Collection
import java.util.Collections
import java.util.Comparator
import java.util.HashSet
import java.util.List
import org.apache.lucene.search.spell.LevenshteinDistance
import de.upb.dbis.baas.Operation
import de.upb.dbis.baas.annotator.OWLUtil
import de.upb.dbis.baas.SemanticType
import org.apache.jena.rdf.model.Resource
import org.apache.jena.rdf.model.Model
import org.apache.jena.rdf.model.ModelFactory
import org.apache.jena.ontology.OntModelSpec
import org.eclipse.emf.ecore.EStructuralFeature
import de.upb.dbis.baas.BaasPackage

class Matching {
	
	enum OpenAPIFormat
	{
	  STRING, BOOLEAN, INT32, INT64, FLOAT, DOUBLE, DATE, DATETIME, BYTE, BINARY;
	}
	
	private Model model;
	
	new(){
		model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
		model.read("C:/Users/Simon/Data/workspaces/dissertationOxygen/de.upb.dbis.composition/src/main/resources/schema.owl.nt");
	}
	
	static val FORMAT_COMPATIBILITY = #{
		(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.BOOLEAN) -> 1f, 
		(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.BYTE) -> 0f, 
		(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.INT32) -> 0f, 
		(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.INT64) -> 0f, 
		(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.FLOAT) -> 0f, 
		(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.DOUBLE) -> 0f, 
		(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.STRING) -> 0f, 
		(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.DATE) -> 0f, 
		(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.DATETIME) -> 0f, 
		(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.BINARY) -> 0f, 
		
		(OpenAPIFormat.BYTE -> OpenAPIFormat.BYTE) -> 1f, 
		(OpenAPIFormat.BYTE -> OpenAPIFormat.INT32) -> 0f, 
		(OpenAPIFormat.BYTE -> OpenAPIFormat.INT64) -> 0f, 
		(OpenAPIFormat.BYTE -> OpenAPIFormat.FLOAT) -> 0f, 
		(OpenAPIFormat.BYTE -> OpenAPIFormat.DOUBLE) -> 0f, 
		(OpenAPIFormat.BYTE -> OpenAPIFormat.STRING) -> 0f, 
		(OpenAPIFormat.BYTE -> OpenAPIFormat.DATE) -> 0f, 
		(OpenAPIFormat.BYTE -> OpenAPIFormat.DATETIME) -> 0f, 
		(OpenAPIFormat.BYTE -> OpenAPIFormat.BINARY) -> 0.5f,
		 
		(OpenAPIFormat.INT32 -> OpenAPIFormat.INT32) -> 1f, 
		(OpenAPIFormat.INT32 -> OpenAPIFormat.INT64) -> 0.5f, 
		(OpenAPIFormat.INT32 -> OpenAPIFormat.FLOAT) -> 0.25f, 
		(OpenAPIFormat.INT32 -> OpenAPIFormat.DOUBLE) -> 0.25f, 
		(OpenAPIFormat.INT32 -> OpenAPIFormat.STRING) -> 0f, 
		(OpenAPIFormat.INT32 -> OpenAPIFormat.DATE) -> 0.125f, 
		(OpenAPIFormat.INT32 -> OpenAPIFormat.DATETIME) -> 0.125f, 
		(OpenAPIFormat.INT32 -> OpenAPIFormat.BINARY) -> 0f, 
		
		(OpenAPIFormat.INT64 -> OpenAPIFormat.INT64) -> 1f, 
		(OpenAPIFormat.INT64 -> OpenAPIFormat.FLOAT) -> 0.25f, 
		(OpenAPIFormat.INT64 -> OpenAPIFormat.DOUBLE) -> 0.25f, 
		(OpenAPIFormat.INT64 -> OpenAPIFormat.STRING) -> 0f, 
		(OpenAPIFormat.INT64 -> OpenAPIFormat.DATE) -> 0.5f, 
		(OpenAPIFormat.INT64 -> OpenAPIFormat.DATETIME) -> 0.5f, 
		(OpenAPIFormat.INT64 -> OpenAPIFormat.BINARY) -> 0f, 
		
		(OpenAPIFormat.FLOAT -> OpenAPIFormat.FLOAT) -> 1f, 
		(OpenAPIFormat.FLOAT -> OpenAPIFormat.DOUBLE) -> 0.5f, 
		(OpenAPIFormat.FLOAT -> OpenAPIFormat.STRING) -> 0f, 
		(OpenAPIFormat.FLOAT -> OpenAPIFormat.DATE) -> 0f, 
		(OpenAPIFormat.FLOAT -> OpenAPIFormat.DATETIME) -> 0f, 
		(OpenAPIFormat.FLOAT -> OpenAPIFormat.BINARY) -> 0f, 
		
		(OpenAPIFormat.DOUBLE -> OpenAPIFormat.DOUBLE) -> 1f, 
		(OpenAPIFormat.DOUBLE -> OpenAPIFormat.STRING) -> 0f, 
		(OpenAPIFormat.DOUBLE -> OpenAPIFormat.DATE) -> 0f, 
		(OpenAPIFormat.DOUBLE -> OpenAPIFormat.DATETIME) -> 0f, 
		(OpenAPIFormat.DOUBLE -> OpenAPIFormat.BINARY) -> 0f,
		 
		(OpenAPIFormat.STRING -> OpenAPIFormat.STRING) -> 1f, 
		(OpenAPIFormat.STRING -> OpenAPIFormat.DATE) -> 0f, 
		(OpenAPIFormat.STRING -> OpenAPIFormat.DATETIME) -> 0f, 
		(OpenAPIFormat.STRING -> OpenAPIFormat.BINARY) -> 0f, 
		
		(OpenAPIFormat.DATE -> OpenAPIFormat.DATE) -> 1f, 
		(OpenAPIFormat.DATE -> OpenAPIFormat.DATETIME) -> 0.5f, 
		(OpenAPIFormat.DATE -> OpenAPIFormat.BINARY) -> 0f,
		 
		(OpenAPIFormat.DATETIME -> OpenAPIFormat.DATETIME) -> 1f, 
		(OpenAPIFormat.DATETIME -> OpenAPIFormat.BINARY) -> 0f,
		
		(OpenAPIFormat.BINARY -> OpenAPIFormat.BINARY) -> 1f
		
	};
	
	
	static val FORMAT_COMPATIBILITY_ASYM = #{
			(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.BOOLEAN) -> 1f, 
			(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.BYTE) -> 0f, 
			(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.INT32) -> 0f, 
			(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.INT64) -> 0f, 
			(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.FLOAT) -> 0f, 
			(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.DOUBLE) -> 0f, 
			(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.STRING) -> 0f, 
			(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.DATE) -> 0f, 
			(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.DATETIME) -> 0f, 
			(OpenAPIFormat.BOOLEAN -> OpenAPIFormat.BINARY) -> 0f, 
			
			(OpenAPIFormat.BYTE -> OpenAPIFormat.BOOLEAN) -> 0f, 
			(OpenAPIFormat.BYTE -> OpenAPIFormat.BYTE) -> 1f, 
			(OpenAPIFormat.BYTE -> OpenAPIFormat.INT32) -> 0f, 
			(OpenAPIFormat.BYTE -> OpenAPIFormat.INT64) -> 0f, 
			(OpenAPIFormat.BYTE -> OpenAPIFormat.FLOAT) -> 0f, 
			(OpenAPIFormat.BYTE -> OpenAPIFormat.DOUBLE) -> 0f, 
			(OpenAPIFormat.BYTE -> OpenAPIFormat.STRING) -> 0f, 
			(OpenAPIFormat.BYTE -> OpenAPIFormat.DATE) -> 0f, 
			(OpenAPIFormat.BYTE -> OpenAPIFormat.DATETIME) -> 0f, 
			(OpenAPIFormat.BYTE -> OpenAPIFormat.BINARY) -> 0.5f, 
			
			(OpenAPIFormat.INT32 -> OpenAPIFormat.BOOLEAN) -> 0f, 
			(OpenAPIFormat.INT32 -> OpenAPIFormat.BYTE) -> 0f, 
			(OpenAPIFormat.INT32 -> OpenAPIFormat.INT32) -> 1f, 
			(OpenAPIFormat.INT32 -> OpenAPIFormat.INT64) -> 0.5f, 
			(OpenAPIFormat.INT32 -> OpenAPIFormat.FLOAT) -> 0.125f, 
			(OpenAPIFormat.INT32 -> OpenAPIFormat.DOUBLE) -> 0.125f, 
			(OpenAPIFormat.INT32 -> OpenAPIFormat.STRING) -> 0f, 
			(OpenAPIFormat.INT32 -> OpenAPIFormat.DATE) -> 0.125f, 
			(OpenAPIFormat.INT32 -> OpenAPIFormat.DATETIME) -> 0.125f, 
			(OpenAPIFormat.INT32 -> OpenAPIFormat.BINARY) -> 0f, 
			
			(OpenAPIFormat.INT64 -> OpenAPIFormat.BOOLEAN) -> 0f, 
			(OpenAPIFormat.INT64 -> OpenAPIFormat.BYTE) -> 0f, 
			(OpenAPIFormat.INT64 -> OpenAPIFormat.INT32) -> 0.5f, 
			(OpenAPIFormat.INT64 -> OpenAPIFormat.INT64) -> 1f, 
			(OpenAPIFormat.INT64 -> OpenAPIFormat.FLOAT) -> 0.125f, 
			(OpenAPIFormat.INT64 -> OpenAPIFormat.DOUBLE) -> 0.125f, 
			(OpenAPIFormat.INT64 -> OpenAPIFormat.STRING) -> 0f, 
			(OpenAPIFormat.INT64 -> OpenAPIFormat.DATE) -> 0.25f, 
			(OpenAPIFormat.INT64 -> OpenAPIFormat.DATETIME) -> 0.25f, 
			(OpenAPIFormat.INT64 -> OpenAPIFormat.BINARY) -> 0f, 
			
			(OpenAPIFormat.FLOAT -> OpenAPIFormat.BOOLEAN) -> 0f, 
			(OpenAPIFormat.FLOAT -> OpenAPIFormat.BYTE) -> 0f, 
			(OpenAPIFormat.FLOAT -> OpenAPIFormat.INT32) -> 0.125f, 
			(OpenAPIFormat.FLOAT -> OpenAPIFormat.INT64) -> 0.125f, 
			(OpenAPIFormat.FLOAT -> OpenAPIFormat.FLOAT) -> 1f, 
			(OpenAPIFormat.FLOAT -> OpenAPIFormat.DOUBLE) -> 0.5f, 
			(OpenAPIFormat.FLOAT -> OpenAPIFormat.STRING) -> 0f, 
			(OpenAPIFormat.FLOAT -> OpenAPIFormat.DATE) -> 0f, 
			(OpenAPIFormat.FLOAT -> OpenAPIFormat.DATETIME) -> 0f, 
			(OpenAPIFormat.FLOAT -> OpenAPIFormat.BINARY) -> 0f, 
			
			(OpenAPIFormat.DOUBLE -> OpenAPIFormat.BOOLEAN) -> 0f, 
			(OpenAPIFormat.DOUBLE -> OpenAPIFormat.BYTE) -> 0f, 
			(OpenAPIFormat.DOUBLE -> OpenAPIFormat.INT32) -> 0.125f, 
			(OpenAPIFormat.DOUBLE -> OpenAPIFormat.INT64) -> 0.125f, 
			(OpenAPIFormat.DOUBLE -> OpenAPIFormat.FLOAT) -> 0.25f, 
			(OpenAPIFormat.DOUBLE -> OpenAPIFormat.DOUBLE) -> 1f, 
			(OpenAPIFormat.DOUBLE -> OpenAPIFormat.STRING) -> 0f, 
			(OpenAPIFormat.DOUBLE -> OpenAPIFormat.DATE) -> 0f, 
			(OpenAPIFormat.DOUBLE -> OpenAPIFormat.DATETIME) -> 0f, 
			(OpenAPIFormat.DOUBLE -> OpenAPIFormat.BINARY) -> 0f, 
			
			(OpenAPIFormat.STRING -> OpenAPIFormat.BOOLEAN) -> 0f, 
			(OpenAPIFormat.STRING -> OpenAPIFormat.BYTE) -> 0f, 
			(OpenAPIFormat.STRING -> OpenAPIFormat.INT32) -> 0f, 
			(OpenAPIFormat.STRING -> OpenAPIFormat.INT64) -> 0f, 
			(OpenAPIFormat.STRING -> OpenAPIFormat.FLOAT) -> 0f, 
			(OpenAPIFormat.STRING -> OpenAPIFormat.DOUBLE) -> 0f, 
			(OpenAPIFormat.STRING -> OpenAPIFormat.STRING) -> 1f, 
			(OpenAPIFormat.STRING -> OpenAPIFormat.DATE) -> 0f, 
			(OpenAPIFormat.STRING -> OpenAPIFormat.DATETIME) -> 0f, 
			(OpenAPIFormat.STRING -> OpenAPIFormat.BINARY) -> 0f, 
			
			(OpenAPIFormat.DATE -> OpenAPIFormat.BOOLEAN) -> 0f, 
			(OpenAPIFormat.DATE -> OpenAPIFormat.BYTE) -> 0f, 
			(OpenAPIFormat.DATE -> OpenAPIFormat.INT32) -> 0.125f, 
			(OpenAPIFormat.DATE -> OpenAPIFormat.INT64) -> 0.25f, 
			(OpenAPIFormat.DATE -> OpenAPIFormat.FLOAT) -> 0f, 
			(OpenAPIFormat.DATE -> OpenAPIFormat.DOUBLE) -> 0f, 
			(OpenAPIFormat.DATE -> OpenAPIFormat.STRING) -> 0f, 
			(OpenAPIFormat.DATE -> OpenAPIFormat.DATE) -> 1f, 
			(OpenAPIFormat.DATE -> OpenAPIFormat.DATETIME) -> 0.5f, 
			(OpenAPIFormat.DATE -> OpenAPIFormat.BINARY) -> 0f, 
			
			(OpenAPIFormat.DATETIME -> OpenAPIFormat.BOOLEAN) -> 0f, 
			(OpenAPIFormat.DATETIME -> OpenAPIFormat.BYTE) -> 0f, 
			(OpenAPIFormat.DATETIME -> OpenAPIFormat.INT32) -> 0f, 
			(OpenAPIFormat.DATETIME -> OpenAPIFormat.INT64) -> 0f, 
			(OpenAPIFormat.DATETIME -> OpenAPIFormat.FLOAT) -> 0f, 
			(OpenAPIFormat.DATETIME -> OpenAPIFormat.DOUBLE) -> 0f, 
			(OpenAPIFormat.DATETIME -> OpenAPIFormat.STRING) -> 0f, 
			(OpenAPIFormat.DATETIME -> OpenAPIFormat.DATE) -> 0.25f, 
			(OpenAPIFormat.DATETIME -> OpenAPIFormat.DATETIME) -> 1f, 
			(OpenAPIFormat.DATETIME -> OpenAPIFormat.BINARY) -> 0f, 
			
			(OpenAPIFormat.BINARY -> OpenAPIFormat.BOOLEAN) -> 0f, 
			(OpenAPIFormat.BINARY -> OpenAPIFormat.BYTE) -> 0.5f, 
			(OpenAPIFormat.BINARY -> OpenAPIFormat.INT32) -> 0f, 
			(OpenAPIFormat.BINARY -> OpenAPIFormat.INT64) -> 0f, 
			(OpenAPIFormat.BINARY -> OpenAPIFormat.FLOAT) -> 0f, 
			(OpenAPIFormat.BINARY -> OpenAPIFormat.DOUBLE) -> 0f, 
			(OpenAPIFormat.BINARY -> OpenAPIFormat.STRING) -> 0f, 
			(OpenAPIFormat.BINARY -> OpenAPIFormat.DATE) -> 0f, 
			(OpenAPIFormat.BINARY -> OpenAPIFormat.DATETIME) -> 0f, 
			(OpenAPIFormat.BINARY -> OpenAPIFormat.BINARY) -> 1f

		};
	
	
	def match(List<Operation> operations){
		var result = new ArrayList<IOMapping>();
		
		
		for(var i =0; i<operations.length-1; i++){
			
			System.out.println();
			
			for(var j =i+1; j<operations.length; j++){
			
				
			
				val op1 = operations.get(i);
				val op2 = operations.get(j);
				
				
				for(IO io1 : op1.ios){
					for(IO io2 : op2.ios){
						
						val match = match(io1, io2);
							result.add(match);
					}
				}
			}
		}
		
		
		Collections.sort(result, new Comparator<IOMapping>(){
			override compare(IOMapping arg0, IOMapping arg1) {
				if(arg0.score===arg1.score){
					return 0;
				}
				else if(arg0.score>arg1.score){
					return -1;
				}
				else{
					return 1;
				}
			}
		});	
				
		return result;
	}
	
	def match(IO selection, List<Operation> operations){
		
		var result = new ArrayList<IOMapping>();
		
		var ios = new ArrayList<IO>();
		
		for(Operation operation:operations){
			ios.addAll(operation.ios);
		}
		
		for(IO io:ios){
			var mapping = match(selection, io);
			result.add(mapping);				
		}
		
		Collections.sort(result, new Comparator<IOMapping>(){
			override compare(IOMapping arg0, IOMapping arg1) {
				if(arg0.score===arg1.score){
					return 0;
				}
				else if(arg0.score>arg1.score){
					return -1;
				}
				else{
					return 1;
				}
			}
		});	
		
		//Collections.reverse(result);
		
		return result;		
	}
	
	def IOMapping match(IO selection, IO other){

		var mapping = BaasFactory.eINSTANCE.createIOMapping();
		mapping.left = selection;
		mapping.right = other;
		
		var vector = BaasFactory.eINSTANCE.createVector();
		
		var sim1 = BaasFactory.eINSTANCE.createSimilarity();
		sim1.name = "Levenshtein"
		sim1.sigma = new LevenshteinDistance().getDistance(selection.name, other.name);
		vector.similarities.add(sim1);
		
		var sim2 = BaasFactory.eINSTANCE.createSimilarity();
		sim2.name = "Format"
		sim2.sigma = similarity(inferType(selection), inferType(other))
		vector.similarities.add(sim2);	

		var sim3 = BaasFactory.eINSTANCE.createSimilarity();
		sim3.name = "Subject"
		sim3.sigma = upwardCotopicSimilarity(selection, other, BaasPackage.Literals.IO__SUBJECT);
		vector.similarities.add(sim3);	
		
		var sim4 = BaasFactory.eINSTANCE.createSimilarity();
		sim4.name = "Predicate"
		sim4.sigma = sim(selection, other);
		vector.similarities.add(sim4);	
		
		var sim5 = BaasFactory.eINSTANCE.createSimilarity();
		sim5.name = "Object"
		sim5.sigma = upwardCotopicSimilarity(selection, other, BaasPackage.Literals.IO__OBJECT);
		vector.similarities.add(sim5);	
		
		
	
		
		mapping.score = vector.average;
		mapping.vector = vector;
		
		return mapping;
		
	}
	
	private def sim(IO first, IO second){
		
		//System.out.println('''«first?.predicate?.uri» <<>> «second?.predicate?.uri»''');
		
		if(first?.predicate?.uri?.equals(second?.predicate?.uri)){
			return 1f
		}
		else{
			return 0f;
		}
	}
	
	private def upwardCotopicSimilarity(IO first, IO second, EStructuralFeature feature){
		
		

		
		val resource1 = model.getResource((first.eGet(feature) as SemanticType)?.uri);
		val resource2 = model.getResource((second.eGet(feature) as SemanticType)?.uri);
		
		if(model.containsResource(resource1) && model.containsResource(resource2)){
			
			return upwardCotopicSimilarity(resource1, resource2);	
		}
		else{
			return 0;
		}
		
		

		
	}
	
	
	private def upwardCotopicSimilarity(Resource a, Resource b){
		
		
		val x = OWLUtil.listAllSuperClasses(a);
		val y = OWLUtil.listAllSuperClasses(b);
		
		
		return jaccard(x,y);
	}
	
	private def <T> double jaccard(Collection<T> s1, Collection<T> s2){
		
		if(s1.empty && s2.empty){
			return 0;
		}
		
		var union = new HashSet<T>(s1);
		union.addAll(s2);
		
		
		var intersection = new HashSet<T>(s1);
		intersection.retainAll(s2);
		
		return intersection.size as double / union.size as double;
		
	}
	
	private def double similarity(OpenAPIFormat format1, OpenAPIFormat format2){
		
		if(FORMAT_COMPATIBILITY.containsKey(format1 -> format2)){
			return FORMAT_COMPATIBILITY.get(format1 -> format2);
		}
		else{
			return 0f;
		}
	}
	
	private def OpenAPIFormat inferType(IO io){
		
		var default_ = OpenAPIFormat.STRING;
		
		switch(io.datatype){
			case "string": default_ = OpenAPIFormat.STRING
			case "integer": default_=  OpenAPIFormat.INT64
			case "number": default_=   OpenAPIFormat.DOUBLE
			case "boolean": default_=  OpenAPIFormat.BOOLEAN
		}
		
		
		var latest = null as OpenAPIFormat;
		
		for(Object value:io.values){
			
			var sample = value.toString;
			
			var current = null as OpenAPIFormat;
			
			if(sample.matches("^-?\\d+\\.\\d+$")){
				//1.1
				current = OpenAPIFormat.DOUBLE;
			}
			else if(sample.matches("^-?\\d+$")){
				//12
				current = OpenAPIFormat.INT64;
			}
			else if(sample.matches("^\\d{4}[-/]\\d{2}[-/]\\d{2}$")){
				//2014-05-31
				current = OpenAPIFormat.DATE;
			}
			else if(sample.matches("^\\d{4}[-/]\\d{2}[-/]\\d{2}T\\d{2}:\\d{2}$")){
				//2014-05-31T20:00
				current = OpenAPIFormat.DATETIME;
			}
			else if(sample.matches("^\\d{4}[-/]\\d{2}[-/]\\d{2}T\\d{2}:\\d{2}:\\d{2}$")){
				//2014-05-31T20:00:00
				current = OpenAPIFormat.DATETIME;
			}
			else if(sample.matches("^(true|false)$")){
				//true
				current = OpenAPIFormat.BOOLEAN;
			}
			else if(sample.matches("^(yes|no)$")){
				//true
				current = OpenAPIFormat.BOOLEAN;
			}

			
			if(latest===null){
				latest = current;
			}
			else if(!latest.equals(current)){
				
				return default_;
			}

		}
		
		if(latest!==null){
			return latest;
		}
		else{
			
			return default_;
		}
		
	}	
	
	
}