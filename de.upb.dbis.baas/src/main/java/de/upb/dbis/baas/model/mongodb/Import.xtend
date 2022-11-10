package de.upb.dbis.baas.model.mongodb

import java.io.File
import org.apache.jena.rdf.model.ModelFactory
import org.apache.jena.ontology.OntModelSpec
import de.upb.dbis.baas.annotator.SpecificationLoader
import de.upb.dbis.baas.annotator.MashapeAdapter
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.DBObject
import com.mongodb.BasicDBObject

class Import {
	def static void main(String[] args) {
		
		val mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		
		val database = mongoClient.getDatabase("astro");
		val collection = database.getCollection("eobjects", DBObject);
		
		val document = new BasicDBObject();
		collection.deleteMany(document);
		
		val ontology = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
		ontology.read("./data/schema.owl.nt");
		new SemanticTypeImporter().doImport(ontology);
		
		var openapis = new MashapeAdapter().doLoad("./data/apis");
		var specs = new SpecificationLoader().load(openapis);
		new SpecificationImporter().doImport(specs);
		
		val file = new File("./data/alignment.csv");
		new AlignmentImporter().loadAlignment(file);
	}
}