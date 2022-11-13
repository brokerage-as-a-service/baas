package de.upb.dbis.baas.model.data

class Database {
	
	
	static val singleton2 = new Database()

	static def singleton() {
		return singleton2
	}
	
	def load(){
				
		SemanticTypeIndex.singleton.load()
		
		ParameterIndex.singleton.load()
		
		AlignmentIndex.singleton.load()
	}
}