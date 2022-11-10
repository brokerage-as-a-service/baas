package de.upb.dbis.baas.evaluation

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.client.MongoCollection
import com.mongodb.DBObject

class Collection {
	
	
	private static MongoCollection<DBObject> INSTANCE;
	
	static def MongoCollection<DBObject> get(){
		
		if(INSTANCE===null){
			val mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
			
			val database = mongoClient.getDatabase("astro");
			INSTANCE = database.getCollection("eobjects", DBObject);
		}
		
		return INSTANCE;
	}
}