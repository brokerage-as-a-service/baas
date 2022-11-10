package de.upb.dbis.baas.model.mongodb

import java.io.File
import java.io.BufferedReader
import java.io.FileReader
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.DBObject
import de.upb.dbis.baas.BaasPackage
import de.upb.dbis.baas.BaasFactory
import java.util.HashSet
import com.mongodb.client.model.Filters
import de.upb.dbis.baas.Specification
import de.upb.dbis.baas.DiscoveryResult
import java.util.ArrayList
import java.util.UUID
import com.mongodb.BasicDBObject

class RelevanceSet {

	static def void main(String[] args) {

		var file = new File(
			"C:/Users/Simon/Data/git2/dissertation/implementation/de.upb.is.sme2/testcollections/unnormalized/matrix.csv");
		new RelevanceSet().loadAlignment(file);
	}

	def loadAlignment(File file) {

		var operations = 0;

		val mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

		val database = mongoClient.getDatabase("astro");
		val collection = database.getCollection("eobjects", DBObject);
		
		val document = new BasicDBObject("eType", BaasPackage.Literals.DISCOVERY_RESULT.name);
		collection.deleteMany(document);
		
		val document2 = new BasicDBObject("eType", BaasPackage.Literals.OPERATION_MAPPING.name);
		collection.deleteMany(document2);


		var adapter = new EObjectReadingConverter(BaasPackage.eINSTANCE, BaasFactory.eINSTANCE, collection);

		/*
		 * 
		 * 
		 */
		 
		 
		val queries = new ArrayList<DiscoveryResult>();
		
		var distance_query = BaasFactory.eINSTANCE.createDiscoveryResult();
		distance_query.name = "distance";
		distance_query.query = '''GeoCoordinate Distance'''
		distance_query.uuid = UUID.randomUUID.toString;

		var flight_query = BaasFactory.eINSTANCE.createDiscoveryResult();
		flight_query.name = "flight";
		flight_query.query = '''Origin Airport, Destination Airport, DepartureDate departureTime, Flights Flight'''
		flight_query.uuid = UUID.randomUUID.toString;

		var movie_query = BaasFactory.eINSTANCE.createDiscoveryResult();
		movie_query.name = "movie";
		movie_query.query = '''Actor Person, Movies Movie'''
		movie_query.uuid = UUID.randomUUID.toString;

		var music_query = BaasFactory.eINSTANCE.createDiscoveryResult();
		music_query.name = "music";
		music_query.query = '''Artist MusicGroup, Album MusicAlbum'''
		music_query.uuid = UUID.randomUUID.toString;

		var soccer_query = BaasFactory.eINSTANCE.createDiscoveryResult();
		soccer_query.name = "soccer";
		soccer_query.query = '''Season SportsEvent, League SportsOrganization, Team SportsTeam, Matches SportsEvent''';
		soccer_query.uuid = UUID.randomUUID.toString;
		
		queries.add(distance_query);
		queries.add(flight_query);
		queries.add(movie_query);
		queries.add(music_query);
		queries.add(soccer_query);

		/*
		 * Load Specifications from Database 
		 */
		val specifications = new HashSet<Specification>();

		val cursor = collection.find(Filters.eq("eType", BaasPackage.Literals.SPECIFICATION.name)).iterator;

		while (cursor.hasNext) {

			val next = cursor.next;
			val specification = adapter.toEObject(next) as Specification;

			specifications.add(specification);

		}

		val prefixes = specifications.map[s|s.host].toSet;

		val br = new BufferedReader(new FileReader(file));

		var header = true;
		var line = "";
		while ((line = br.readLine()) !== null) {

			if (header) {
				header = false;
			} else {

				val parts = line.split(",");

				for (var i = 0; i < parts.length; i++) {

					if (parts.get(i).startsWith("\"") && parts.get(i).endsWith("\"")) {
						parts.set(i, parts.get(i).substring(1, parts.get(i).length - 1));
					}

				}

				var method = "";
				var operationId__ = "";
				val operationId = parts.get(0);


				val prefix_iterator = prefixes.iterator;

				var prefix = "";

				while (prefix_iterator.hasNext) {
					val next = prefix_iterator.next;

					if (operationId.startsWith(next)) {

						if (next.length > prefix.length) {
							prefix = next;
						}
					}

				}

				val host = prefix;

				if (operationId.endsWith("-get.owls")) {

					operationId__ = operationId;
					operationId__ = operationId__.replace(prefix + "-", "");
					operationId__ = operationId__.replace("-get.owls", "");

					method = "get"
				} else if (operationId.endsWith("-post.owls")) {

					operationId__ = operationId;
					operationId__ = operationId__.replace(prefix + "-", "");
					operationId__ = operationId__.replace("-post.owls", "");
					method = "post"
				} else if (operationId.endsWith("-put.owls")) {

					operationId__ = operationId;
					operationId__ = operationId__.replace(prefix + "-", "");
					operationId__ = operationId__.replace("-put.owls", "");
					method = "put"
				} else if (operationId.endsWith("-delete.owls")) {
					operationId__ = operationId;
					operationId__ = operationId__.replace(prefix + "-", "");
					operationId__ = operationId__.replace("-delete.owls", "");
					method = "delete"
				}

				val oo = operationId__;
				val m = method;

				System.out.println('''«host»	«operationId__»		«method»''');

				val operation = specifications.filter[s|s.host == host].head.operations.filter[ o |
					o.operationId == oo && o.method == m
				].head;
				
				for(var i=1; i<parts.size;i++){
					
					var relevance = Integer.parseInt(parts.get(i));
					var query = queries.get(i-1);
					val operationMapping = BaasFactory.eINSTANCE.createOperationMapping;
					operationMapping.uuid = UUID.randomUUID.toString;
					operationMapping.relevance = relevance;
					operationMapping.operation = operation;
					query.mappings.add(operationMapping);
				}




			// System.out.println(operation);
			}
		}


		for(DiscoveryResult q:queries){
			
			collection.insertOne(EObjectReadingConverter.toDBObject(q));
			
			
			var treeiterator = q.eAllContents();
			
			while(treeiterator.hasNext){
				var next = treeiterator.next;
				
				collection.insertOne(EObjectReadingConverter.toDBObject(next));
			}			
		}
		

		System.out.println(operations);

	}

}
