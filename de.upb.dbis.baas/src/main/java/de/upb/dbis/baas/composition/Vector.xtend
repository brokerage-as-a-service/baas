package de.upb.dbis.baas.composition

import java.util.List
import java.util.ArrayList

class Vector extends ArrayList<Double>{
	
	
	def length(List<Double> vector){
		
		var sum = 0d;
		for(var i =0; i<vector.size; i++){
			
			sum = sum + (vector.get(i)*vector.get(i));
			
		}
		
		return Math.sqrt(sum)
	}
}