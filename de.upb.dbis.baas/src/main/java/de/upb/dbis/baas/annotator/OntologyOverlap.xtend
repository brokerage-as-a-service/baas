package de.upb.dbis.baas.annotator

import de.upb.dbis.baas.IO
import de.upb.dbis.baas.Operation
import de.upb.dbis.baas.Specification
import de.upb.dbis.baas.composition.AnalyzerHelper
import java.util.HashSet
import java.util.Set
import org.apache.jena.ontology.DatatypeProperty
import org.apache.jena.ontology.ObjectProperty
import org.apache.jena.ontology.OntClass
import org.apache.jena.ontology.OntModel
import org.apache.jena.ontology.OntModelSpec
import org.apache.jena.rdf.model.ModelFactory
import org.apache.jena.vocabulary.RDFS

class OntologyOverlap {
	
	
	static Set<String> tokens_normalized = new HashSet<String>();
	static Set<String> tokens = new HashSet<String>();
	
	static def main(String[] args){
		
		var openapis = new MashapeAdapter().doLoad("C:/Users/Simon/Data/workspaces/newAstro/de.upb.dbis.astro/data/apis");
		var specs = new SpecificationLoader().load(openapis);
		
		tokens_normalized = new HashSet<String>();
		tokens = new HashSet<String>();
		
		for(Specification spec: specs){
			
			for(Operation operation: spec.operations){
				
				tokens.add(operation.operationId.toLowerCase);
				tokens_normalized.addAll(AnalyzerHelper.normalize(AnalyzerHelper.ANALYZER_ID, operation.operationId));
				
				
				for(IO io: operation.ios){
					tokens.add(io.name.toLowerCase);
					tokens_normalized.addAll(AnalyzerHelper.normalize(AnalyzerHelper.ANALYZER_ID, io.name));	
				}
			}
		}
		
		var schemaorg = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
		schemaorg.read("C:/Users/Simon/Data/workspaces/dissertationOxygen/de.upb.dbis.composition/src/main/resources/schema.owl.nt");
		xx(schemaorg);
		
		var dbpedia = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
		dbpedia.read("data/ontologies/dbpedia_2016-10.owl");
		xx(dbpedia);
		
		var umbel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
		umbel.read("data/ontologies/umbel.n3");
		xx(umbel);		
		
	}
	
	static def xx(OntModel ontology){
		
		var mytokens = new HashSet<String>();
		var mytokens_normalized = new HashSet<String>();
		var classes = OWLUtil.listClasses(ontology);
		var datatype_properties = OWLUtil.listDatatypeProperties(ontology);
		var object_properties = OWLUtil.listObjectProperties(ontology);
		
		for(OntClass r:classes){
			var label = OWLUtil.getLiteral(r, RDFS.label);
			
			
			if(label.equals("")){
				mytokens_normalized.addAll(AnalyzerHelper.normalize(AnalyzerHelper.ANALYZER_ID, r.localName));
				mytokens.add(r.localName);
			}
			else{
				
				mytokens_normalized.addAll(AnalyzerHelper.normalize(AnalyzerHelper.ANALYZER_ID, label));
				mytokens.add(label);
			}
			
		}
		
		for(DatatypeProperty r:datatype_properties){
			var label = OWLUtil.getLiteral(r, RDFS.label);
			if(label.equals("")){
				mytokens_normalized.addAll(AnalyzerHelper.normalize(AnalyzerHelper.ANALYZER_ID, r.localName));
				mytokens.add(r.localName);
			}
			else{
				
				mytokens_normalized.addAll(AnalyzerHelper.normalize(AnalyzerHelper.ANALYZER_ID, label));
				mytokens.add(label);
			}
		}
		
		for(ObjectProperty r:object_properties){
			var label = OWLUtil.getLiteral(r, RDFS.label);
			if(label.equals("")){
				mytokens_normalized.addAll(AnalyzerHelper.normalize(AnalyzerHelper.ANALYZER_ID, r.localName));
				mytokens.add(r.localName);
			}
			else{
				
				mytokens_normalized.addAll(AnalyzerHelper.normalize(AnalyzerHelper.ANALYZER_ID, label));
				mytokens.add(label);
			}
		}
		
		var intersection = new HashSet<String>(tokens); 
		intersection.retainAll(mytokens);
		
		var intersection_normalized = new HashSet<String>(tokens_normalized); 
		intersection_normalized.retainAll(mytokens_normalized);
		
		
		var coverage = intersection.size as double / tokens.size as double
		var coverage_normalized = intersection_normalized.size as double / tokens_normalized.size as double	
		
		System.out.println(
		'''
		#tokens: «tokens.size»
		#classes: «classes.size»
		#datatype properties: «datatype_properties.size»
		#object properties: «object_properties.size»
		#coverage lowercase: «coverage*100» %
		#coverage tokenized: «coverage_normalized*100» %
		''');
		
		
	}
}