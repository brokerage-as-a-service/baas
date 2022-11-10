package de.upb.dbis.baas.evaluation

import com.mongodb.client.model.Filters
import de.upb.dbis.baas.BaasFactory
import de.upb.dbis.baas.BaasPackage
import de.upb.dbis.baas.SemanticTypeMapping
import de.upb.dbis.baas.model.mongodb.EObjectReadingConverter
import de.upb.dbis.baas.discovery.Discoverer
import java.util.HashSet
import de.upb.dbis.baas.evaluation.Collection

class SemanticDiscoverer extends Discoverer{
	
	override semanticAnnotations(String uuid){
		
		var result = new HashSet<String>();
		
		val adapter = new EObjectReadingConverter(BaasPackage.eINSTANCE, BaasFactory.eINSTANCE, Collection.get);
		
		val iter = Collection.get.find(Filters.and(Filters.eq("eType", BaasPackage.Literals.SEMANTIC_TYPE_MAPPING.name), Filters.eq(BaasPackage.Literals.SEMANTIC_TYPE_MAPPING__IO.name, uuid))).iterator;
		
		while(iter.hasNext){
			val dbo = iter.next;
			val mapping = adapter.toEObject(dbo) as SemanticTypeMapping
			val label = mapping.semantictype.label;	
			
			result.add(label);
		}
		
		return result;
		
		
	}
}