package de.upb.dbis.baas.annotator

import org.apache.jena.rdf.model.Resource
import org.apache.jena.vocabulary.RDFS

class NameProvider {
	
	static def String getLabel(Resource r){
		
		var result = "";
		
		if(r!==null && !r.isAnon){
			
			result = OWLUtil.getLiteral(r.model, r, RDFS.label);
			
			if(result.empty && r.localName !== null){
				result = r.localName;
			}
		}
		

		return result;
	}
	
}
