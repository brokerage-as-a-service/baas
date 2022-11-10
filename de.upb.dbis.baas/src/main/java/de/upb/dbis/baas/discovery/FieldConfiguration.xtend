package de.upb.dbis.baas.discovery

import org.apache.lucene.analysis.Analyzer
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors

class FieldConfiguration {
	
	/**
	 * Field id used to name index fields and query parts
	 */
	@Accessors String id;
	
	/**
	 * Indicates if an index field or query part 
	 */
	@Accessors boolean enabled = false;
	
	/**
	 * Weight (aka Lucene boost) for index fields and query parts.
	 */
	@Accessors float weight;
	
	/**
	 * The analyzer used for an index field or query part.
	 */
	@Accessors Analyzer analyzer;
	

	new(String id, float weight, Analyzer analyzer){
		
		this.id= id;
		
		this.analyzer = analyzer;
		//TODO check if key exists
		
		//this.weight = 1f;
		this.weight = weight;
		this.enabled = weight>0;
	}
}
