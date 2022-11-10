package de.upb.dbis.baas.model.mongodb

import com.mongodb.DBObject
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import de.upb.dbis.baas.Operation
import de.upb.dbis.baas.Specification
import java.util.List

class SpecificationImporter {
	
	static int operations = 0;
	
	def doImport(List<Specification> specifications){
		
		val mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		
		val database = mongoClient.getDatabase("astro");
		val collection = database.getCollection("eobjects", DBObject);
		
		
			
		for(Specification specification: specifications){
			
			collection.insertOne(EObjectReadingConverter.toDBObject(specification));
			
			var treeiterator = specification.eAllContents();
			
			while(treeiterator.hasNext){
				var next = treeiterator.next;
				
				if(next instanceof Operation){
					operations++;
				}
				collection.insertOne(EObjectReadingConverter.toDBObject(next));
			}
		}
		
		System.out.println('''imported operations: «operations»''');
			
	}
}