package de.upb.dbis.baas.composition

import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.Collections

class IO2 {
	
	@Accessors String name = "";
	@Accessors String description = "";
	
	@Accessors String type = "";
	@Accessors String format = "";
	@Accessors Set<Object> values = Collections.EMPTY_SET;
	
	@Accessors String jsonPath = "";
	
	@Accessors Set<String> semanticTypes = Collections.EMPTY_SET;
	
}
