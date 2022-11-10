package de.upb.dbis.baas.model.mongodb

import com.mongodb.BasicDBObject
import com.mongodb.DBObject
import com.mongodb.client.MongoCollection
import java.util.ArrayList
import java.util.Collection
import java.util.HashMap
import java.util.HashSet
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EFactory
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import java.util.UUID

class EObjectReadingConverter{
	
	
	EFactory efactory;
	EPackage epackage;
	MongoCollection<DBObject> resolveIn
	
	static HashMap<Object, EObject> eobject_registry = new HashMap<Object, EObject>(100000);
	static HashMap<Object, DBObject> dbobject_registry = new HashMap<Object, DBObject>(100000);
	static HashSet<Object> ids_of_resolved_eobjects = new HashSet<Object>(100000);
	
	new(EPackage package_, EFactory factory, MongoCollection<DBObject> resolveIn){
		
		efactory = factory;
		epackage = package_;
		this.resolveIn = resolveIn;
	}
	
    static def toDBObject(EObject eobject) {
        var dbObject = new BasicDBObject();
        
        var eidattribute = eobject.eClass.EIDAttribute;
        
        if(eidattribute!==null){
        	
		    dbObject.put("_id", eobject.eGet(eidattribute));
        }
        else{
        	
        	dbObject.put("_id", UUID.randomUUID.toString);
        }
        
	    
      	dbObject.put("eType", eobject.eClass.name);
        
        for(EStructuralFeature feature: eobject.eClass.EAllStructuralFeatures){
        	
        	var value = eobject.eGet(feature);
        	dbObject.put(feature.name, value);	
        }
        
        for(EReference reference: eobject.eClass.EAllReferences){
        	
        	if(eobject.eGet(reference)!==null){
        		
	        	if(reference.many){
	        		
	        		var values = eobject.eGet(reference) as Collection<EObject>;
	        		var ids = new ArrayList<Object>();
	        		
	        		for(EObject value:values){
	        			
	        			var idattribute = value.eClass.EIDAttribute;
		        		var id = value.eGet(idattribute);
	        			ids.add(id);
	        		}
	        		dbObject.put(reference.name, ids); 	
	        	}
	        	else{
	        		
	        		
		        	var value = eobject.eGet(reference) as EObject;
		        	
		        	
		        	
		        	var idattribute = value.eClass.EIDAttribute;
		        	
		        	var id = value.eGet(idattribute);
		        	
		        	dbObject.put(reference.name, id);	
	        	}
        	}
        	
        }
        


        return dbObject;
    }
    
    protected def EObject loadEAttributes(DBObject source){
		var eType = source.get("eType") as String;
		
		var eclass = epackage.getEClassifier(eType) as EClass;

		var id_attribute = eclass.EIDAttribute;
		var id2 = source.get(id_attribute.name);
		
		
		if(eclass instanceof EClass){
			
			
			if(dbobject_registry.containsKey(id2)){
				
				if(eobject_registry.containsKey(id2)){
					return eobject_registry.get(id2);
				}
			}
			else{
				dbobject_registry.put(id2, source);
			}
			
			var eobject = efactory.create(eclass);
			
			
			for(EAttribute feature: eclass.EAllAttributes){
	        	
	        	if(source.containsField(feature.name)){
	        		
	        		eobject.eSet(feature, source.get(feature.name))
	        	}
	        }
	        
	        eobject_registry.put(id2, eobject);
        
	        for(EReference reference: eclass.EAllReferences){
	        	
	        	if(source.containsField(reference.name)){
	        		
	        		if(reference.many){
	        			
	        			var ids = source.get(reference.name) as Collection<String>;
	        			
	        			val query = new BasicDBObject((reference.EType as EClass).EIDAttribute.name, new BasicDBObject("$in", ids))
	        			
						var cursor = resolveIn.find(query).iterator();
						
						while(cursor.hasNext){
							
							var dobject = cursor.next;
							
							loadEAttributes(dobject);
							
						}

		        	}
		        	else{
		        		
		        		var id = source.get(reference.name)
		        		val query = new BasicDBObject((reference.EType as EClass).EIDAttribute.name, id)
		        		
		        		var optional = resolveIn.find(query).first;
		        		
		        		
			        	loadEAttributes(optional);
	
		        	}
	        		
	        	}
	        	

	        }
	        

			
			
			return eobject;
		}
		
		return null;    	
    }
    
    static protected def void loadEReferences(DBObject source, EObject eobject){
    	
    	
    	
    	var id_attribute = eobject.eClass.EIDAttribute;
		var id2 = source.get(id_attribute.name);
    	ids_of_resolved_eobjects.add(id2);
    	
    	
    	for(EReference reference: eobject.eClass.EAllReferences){
    		if(reference.many){
    			var ids = source.get(reference.name) as Collection<Object>;
    			var values = new BasicEList<EObject>();
    			
    			for(Object id : ids){
    				
    				if(!ids_of_resolved_eobjects.contains(id)){
    					
	    				loadEReferences(dbobject_registry.get(id), eobject_registry.get(id));
    				}
    				
    				var referenced_eobject = eobject_registry.get(id);
    				values.add(referenced_eobject);
    				
    			}
    			eobject.eSet(reference, values);
    			
    		}
    		else{
    			
    			var id = source.get(reference.name);
    			
    			if(id!==null){
    				
				    if(!ids_of_resolved_eobjects.contains(id)){
	    				loadEReferences(dbobject_registry.get(id), eobject_registry.get(id));
					}
	    			
	    			var referenced_eobject = eobject_registry.get(id);
	    			
	    			eobject.eSet(reference, referenced_eobject);
    			}
    			
    		}
    	}
    	//eobject_registry.put(id2, eobject);
    	
    	
    }	
	
	def EObject toEObject(DBObject source) {

		val eobject = loadEAttributes(source);
		loadEReferences(source, eobject);
		
		val id_attribute = eobject.eClass.EIDAttribute;
		val id = eobject.eGet(id_attribute);

		/*
		eobject_registry.clear;
		dbobject_registry.clear;
		ids_of_resolved_eobjects.clear;		
		 */
		 
		val e2 = eobject_registry.get(id);
		return e2;
		
	}
	
}
