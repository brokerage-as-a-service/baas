package de.upb.dbis.baas.model.mongodb

import java.util.HashMap
import org.apache.jena.rdf.model.ModelFactory
import org.apache.jena.ontology.OntModelSpec
import de.upb.dbis.baas.SemanticType
import java.util.ArrayList
import org.apache.jena.ontology.OntResource
import de.upb.dbis.baas.annotator.OWLUtil
import de.upb.dbis.baas.BaasFactory
import org.apache.jena.vocabulary.RDFS
import java.util.Collection

class SemanticTypeIndex {

	val index = new HashMap<String, SemanticType>()
	static val singleton2 = new SemanticTypeIndex()

	static def singleton() {
		return singleton2
	}

	def load() {

		val ontology = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);

		ontology.read("./data/schema.owl.nt");

		var resources = new ArrayList<OntResource>();
		resources.addAll(OWLUtil.listClasses(ontology));
		for (OntResource resource : resources) {

			var semanticType = BaasFactory.eINSTANCE.createSemanticType();
			semanticType.label = OWLUtil.getLiteral(resource, RDFS.label);
			semanticType.comment = OWLUtil.getLiteral(resource, RDFS.comment);
			semanticType.uri = resource.URI;

			index.put(semanticType.uri, semanticType)

		}

	}

	def SemanticType get(String uuid) {
		return index.get(uuid)
	}
	

}
