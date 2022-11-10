package de.upb.dbis.baas.model.mongodb

import de.upb.dbis.baas.BaasFactory
import de.upb.dbis.baas.SemanticTypeMapping
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.HashMap
import java.util.UUID
import java.util.Collection
import java.util.ArrayList

class AlignmentIndex {

	val index = new ArrayList<SemanticTypeMapping>()
	static val singleton2 = new AlignmentIndex()

	static def singleton() {
		return singleton2
	}

	def load() {
		
		System.out.println("READ!!!!!!!!!!!!!!!!!!!")
		val file = new File("./data/alignment.csv")
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

			val concept = SemanticTypeIndex.singleton.get(subject_uri)
			var mapping = BaasFactory.eINSTANCE.createSemanticTypeMapping();
			mapping.uuid = UUID.randomUUID.toString;
			mapping.semantictype = concept;
			val io_ = ParameterIndex.singleton.get(serviceId, operationId, io_name, json_path)
			if(io_==null){
				System.out.println(io_)
			}
			mapping.io = io_;
			mapping.relevance = 1d;
			index.add(mapping)

		}
	}


	def Collection<SemanticTypeMapping> values(){
		return index
	}	
}
