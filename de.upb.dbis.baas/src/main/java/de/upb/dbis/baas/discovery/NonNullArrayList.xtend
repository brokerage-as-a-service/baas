package de.upb.dbis.baas.discovery

import java.util.ArrayList

class NonNullArrayList<E> extends ArrayList<E> {
	
	override add(E item){
		if(item!==null){
			super.add(item);
		}
	}
}