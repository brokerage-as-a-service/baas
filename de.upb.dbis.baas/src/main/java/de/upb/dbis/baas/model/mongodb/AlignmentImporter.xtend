package de.upb.dbis.baas.model.mongodb

import com.mongodb.BasicDBObject
import com.mongodb.DBObject
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import de.upb.dbis.baas.BaasFactory
import de.upb.dbis.baas.BaasPackage
import de.upb.dbis.baas.IO
import de.upb.dbis.baas.Operation
import de.upb.dbis.baas.SemanticType
import de.upb.dbis.baas.Specification
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.UUID

class AlignmentImporter {
	
	def static void main(String[] args) {
		
		val file = new File("./data/alignment.csv");
		new AlignmentImporter().loadAlignment(file);
	}
	
		
	def loadAlignment(File file) {

		
		val mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

		val database = mongoClient.getDatabase("astro");
		val collection = database.getCollection("eobjects", DBObject);

		var adapter = new EObjectReadingConverter(BaasPackage.eINSTANCE, BaasFactory.eINSTANCE, collection);

		val document = new BasicDBObject("eType", BaasPackage.Literals.SEMANTIC_TYPE_MAPPING.name);
		collection.deleteMany(document);


		val br = new BufferedReader(new FileReader(file));

		var line = "";
		while ((line = br.readLine()) !== null) {

			val parts = line.split(",");

			for (var i = 0; i < parts.length; i++) {

				if (parts.get(i).startsWith("\"") && parts.get(i).endsWith("\"")) {
					parts.set(i, parts.get(i).substring(1, parts.get(i).length - 1));
				}

			}

			val serviceId = parts.get(0);
			val operationId = parts.get(1);
			val http_method = parts.get(2);
			val io_name = parts.get(3);
			val json_path = parts.get(4);

			val subject_uri = parts.get(5);
//			val predicate_uri = parts.get(6);
//			val object_uri = parts.get(7);
			
			
			
			val query = new BasicDBObject("eType", BaasPackage.Literals.SPECIFICATION.name).append(
				BaasPackage.Literals.SPECIFICATION__HOST.name, serviceId);
			val specification_dob = collection.find(query).first;
			val specification = adapter.toEObject(specification_dob) as Specification;
			var io_ = null as IO;

			for (Operation operation : specification.operations) {

				if (operation.operationId.equals(operationId) && operation.method.equals(http_method)) {

					for (IO io : operation.ios) {
						if (io.type.equals("output") && json_path !== null && io.jsonPath !== null && io.jsonPath.equals(json_path)) {
							io_ = io;
						} else if (io.type.equals("input") && io.name.equals(io_name)) {
							io_ = io;
						}
					}
				}

			}
			/*
			 * Subject
			 */
			 
			
			var query2 = new BasicDBObject("eType", BaasPackage.Literals.SEMANTIC_TYPE.name).append(
				BaasPackage.Literals.SEMANTIC_TYPE__URI.name, subject_uri);

			var next = collection.find(query2).first;
			
			var concept = adapter.toEObject(next) as SemanticType;
			var mapping = BaasFactory.eINSTANCE.createSemanticTypeMapping();
			mapping.uuid = UUID.randomUUID.toString;
			mapping.semantictype = concept;
			mapping.io = io_;
			mapping.relevance = 1d;
			mapping.io.operation.specification
			System.out.println('''import «mapping.io.operation.specification.name» «mapping.io.operation.path» «mapping.io.name» => «mapping.semantictype.uri»''')
			var dbo = EObjectReadingConverter.toDBObject(mapping);
			collection.insertOne(dbo);
			
			
//			/*
//			 * Predicate
//			 */			
//			query2 = new BasicDBObject("eType", BaasPackage.Literals.SEMANTIC_TYPE.name).append(
//				BaasPackage.Literals.SEMANTIC_TYPE__URI.name, predicate_uri);
//
//			next = collection.find(query2).first;
//			
//			concept = adapter.toEObject(next) as SemanticType;
//			mapping = BaasFactory.eINSTANCE.createSemanticTypeMapping();
//			mapping.uuid = UUID.randomUUID.toString;
//			mapping.semantictype = concept;
//			mapping.io = io_;
//			mapping.relevance = 1d;
//			dbo = EObjectReadingConverter.toDBObject(mapping);
//			collection.insertOne(dbo);
//			/*
//			 * Object
//			 */
//			
//			query2 = new BasicDBObject("eType", BaasPackage.Literals.SEMANTIC_TYPE.name).append(
//				BaasPackage.Literals.SEMANTIC_TYPE__URI.name, object_uri);
//
//			next = collection.find(query2).first;
//			
//			concept = adapter.toEObject(next) as SemanticType;
//			mapping = BaasFactory.eINSTANCE.createSemanticTypeMapping();
//			mapping.uuid = UUID.randomUUID.toString;
//			mapping.semantictype = concept;
//			mapping.io = io_;
//			mapping.relevance = 1d;
//			dbo = EObjectReadingConverter.toDBObject(mapping);
//			collection.insertOne(dbo);								
			

		}
		
	}
}
