package de.upb.dbis.baas.model.mongodb

import com.mongodb.DBObject
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import de.upb.dbis.baas.annotator.OWLUtil
import de.upb.dbis.baas.BaasFactory
import java.util.ArrayList
import org.apache.jena.ontology.OntResource
import org.apache.jena.rdf.model.Model
import org.apache.jena.vocabulary.RDFS
import java.util.HashMap
import de.upb.dbis.baas.SemanticType

class SemanticTypeImporter {
	
	def doImport(Model ontology){
		var index = new HashMap<String, SemanticType>()
		var resources = new ArrayList<OntResource>();
		resources.addAll(OWLUtil.listClasses(ontology));
		//resources.addAll(OWLUtil.listDatatypeProperties(ontology));
		//resources.addAll(OWLUtil.listObjectProperties(ontology));
		
		val mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		
		val database = mongoClient.getDatabase("astro");
		var collection = database.getCollection("eobjects", DBObject);
		
		for(OntResource resource:resources){
			
			var semanticType = BaasFactory.eINSTANCE.createSemanticType();
			semanticType.label = OWLUtil.getLiteral(resource, RDFS.label);
			semanticType.comment = OWLUtil.getLiteral(resource, RDFS.comment);
			semanticType.uri = resource.URI;
			
			collection.insertOne(EObjectReadingConverter.toDBObject(semanticType));
			
			index.put(semanticType.uri, semanticType)
			
			
		}
		
		return index
		
		
	}
}