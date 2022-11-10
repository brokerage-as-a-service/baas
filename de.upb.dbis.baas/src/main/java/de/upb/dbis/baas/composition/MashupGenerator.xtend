package de.upb.dbis.baas.composition

import java.util.Collection
import de.upb.dbis.baas.Operation
import de.upb.dbis.baas.IO
import de.upb.dbis.baas.IOMapping
import java.time.LocalDate
import java.time.OffsetDateTime

class MashupGenerator {
	
	
	private NameProvider id = new NameProvider();
	
	protected def getType(IO io){
		
		var datatype = io.datatype;
		var format = io.format;
		if(datatype.equals("integer")){
			if(format!==null && !format.empty){
				if(format.equals("int32")){
					return "Integer"
				}
				else if(format.equals("int64")){
					return "Long";
				}	
			}
			else{
				return "Integer";
			}
		}
		else if(datatype.equals("number")){
			if(format!==null && !format.empty){
				if(format.equals("float")){
					return "Float";
				}
				else if(format.equals("double")){
					return "Double";
				}
			}
			else{
				"Double";
			}
		}
		else if(datatype.equals("string")){
			
			if(format!==null && !format.empty){
				if(format.equals("byte")){
					return "byte[]";
				}
				else if(format.equals("binary")){
					return "java.io.File";
				}
				else if(format.equals("date")){
					return "java.time.LocalDate";
				}
				else if(format.equals("date-time")){
					return "java.time.OffsetDateTime";
				}
				else if(format.equals("password")){
					return "String";
				}
			}
			else{
				return "String";
			}
		}
		else if(datatype.equals("boolean")){
			return "Boolean";
		}
	}
	
	protected def String defaultValue(IO io){
		
		//Note: "default" has no meaning for required parameters. (https://github.com/OAI/OpenAPI-Specification/blob/master/versions/2.0.md)
		if(io.datatype.equals("integer") && io.format?.equals("int32")){
			return io.^default ?: "0";
		}
		else if(io.datatype.equals("integer") && io.format?.equals("int64")){
			return io.^default ?: "0L";
		}		
		else if(io.datatype.equals("number") && io.format?.equals("float")){
			return io.^default ?: "0f";
		}
		else if(io.datatype.equals("number") && io.format?.equals("double")){
			return io.^default ?: "0d";
		}
		else if(io.datatype.equals("string") && io.format?.equals("byte")){
			return io.^default ?: "null";
		}
		else if(io.datatype.equals("string") && io.format?.equals("binary")){
			return io.^default ?: "null";
		}
		else if(io.datatype.equals("string") && io.format?.equals("date")){
			//TODO parse java.util.Date from defaulValue
			return io.^default ?: "null";
		}
		else if(io.datatype.equals("string") && io.format?.equals("date-time")){
			//TODO parse java.util.Date from defaulValue
			return io?.^default ?: "null";
		}
		else if(io.datatype.equals("string") && io.format?.equals("password")){
			return '''"«io.^default»"''' ?: "";
		}
		else if(io.datatype.equals("string")){
			return '''"«io.^default»"''' ?: "";
		}
		else if(io.datatype.equals("boolean")){
			return io?.^default ?: "Boolean.FALSE";
		}

	}
	
	def String number_to_bytearrayOld(Class c){
		return 
		'''
		byte[] result;
		«IF c.canonicalName.equals("java.lang.Integer")»
		java.nio.ByteBuffer b = java.nio.ByteBuffer.allocate(4);
		b.putInt(value);
		«ELSEIF c.canonicalName.equals("java.lang.Long")»
		java.nio.ByteBuffer b = java.nio.ByteBuffer.allocate(8);
		b.putLong(value);
		«ELSEIF c.canonicalName.equals("java.lang.Float")»
		java.nio.ByteBuffer b = java.nio.ByteBuffer.allocate(4);
		b.putFloat(value);
		«ENDIF»
		result = b.array();
		return result;
		'''
	}
	
	def String to_bytes(){
		return 
		'''
		result = null;
		java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
		java.io.ObjectOutput out = null;
		try {
			out = new java.io.ObjectOutputStream(bos);
			out.writeObject(value);
			out.flush();
			result = bos.toByteArray();
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bos.close();
			} 
			catch (java.io.IOException ex) {
			}
		}
		'''
	}
	
	def String from_bytes(Class type){
		return 
		'''
		result = null;
		java.io.ByteArrayInputStream bis = new java.io.ByteArrayInputStream(value);
		java.io.ObjectInput in = null;
		try {
		  in = new java.io.ObjectInputStream(bis);
		  result = («type.canonicalName») in.readObject();
		} catch (java.io.IOException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		 
		} finally {
		  try {
		    if (in != null) {
		      in.close();
		    }
		  } catch (java.io.IOException ex) {
			  
		  }
		}
		'''
	}	
	
	def String from_file(Class type){
		return
		'''
		result = null;
		java.io.FileInputStream fin = null;
		java.io.ObjectInputStream ois = null;

		try {

			fin = new java.io.FileInputStream(value);
			ois = new java.io.ObjectInputStream(fin);
			result = («type.canonicalName») ois.readObject();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			if (fin != null) {
				try {
					fin.close();
				} catch (java.io.IOException e) {
					e.printStackTrace();
				}
			}

			if (ois != null) {
				try {
					ois.close();
				} catch (java.io.IOException e) {
					e.printStackTrace();
				}
			}

		}
		'''		
	}
	
	
	def String to_file(){
		
		return 
		'''
		result = null;
		java.io.FileOutputStream fos = null;
		try {
			fos = new java.io.FileOutputStream(result);
			java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(fos);
			oos.writeObject(value);
			
		} catch (java.io.FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fos.close();
			} catch (java.io.IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		'''
	}	
	


	
	def to_date(Class target){
		return 
		'''
		result = java.time.Instant.ofEpochMilli(
		value.longValue()
		).atZone(java.time.ZoneId.systemDefault())
		«IF target.canonicalName.equals("java.time.OffsetDateTime")»
		.toOffsetDateTime();
		«ELSEIF target.canonicalName.equals("java.time.LocalDate")»
		.toLocalDate();
		«ENDIF»
		'''
	}
	
	def bytearray_to_number(Class c){
		return
		'''
		ByteBuffer b = b.wrap(value);
		«c.canonicalName» result; 
		«IF c.canonicalName.equals("java.lang.Integer")»
		result = b.getInt();
		«ELSEIF c.canonicalName.equals("java.lang.Long")»
		result = b.getLong();
		«ENDIF»		
		Integer result = wrapped.getInt();
		return result;
		'''
	}
	
	
	def generate(Collection<Operation> orderedOperations, Collection<IOMapping> mappings){
		
		return 
		'''
		
		class Mashup{
			//define APIs
			«FOR Operation operation: orderedOperations»
			io.swagger.client.api.DefaultApi «id.doSwitch(operation.specification)» = new io.swagger.client.api.DefaultApi();
			«ENDFOR»
			
			public void doCall(){
			«FOR Operation operation: orderedOperations»
				«FOR IO input: operation.ios.filter[i | i.type=="input"]»
					«IF mappings.exists[m | m.right == input]»
					«var mapping = mappings.findFirst[m | m.right == input]»
					//values of input '«input.name»' of operation '«input.operation.operationId»' of API '«input.operation.specification.name»': 
					/*	
						«mapping.right.values»
					*/
					//values of «mapping.left.name»: «mapping.left.values»
						«IF mapping.left.type=="output"»
							«getType(mapping.left)» «id.doSwitch(mapping.left)» = JsonPath.parse(response).read("«mapping.left.jsonPath»", «getType(mapping.left)».class);
							«getType(input)» «id.doSwitch(input)» = «mapping.left.name»_to_«mapping.right.name»(«id.doSwitch(mapping.left)»);
						«ENDIF»
					«ELSE»
					«getType(input)» «id.doSwitch(input)» = «defaultValue(input)»;
					«ENDIF»
				«ENDFOR»
			
				
				Object response = api.«operation.operationId»(
					«FOR IO input: operation.ios.filter[i|i.type=="input"] SEPARATOR ', '»
						«id.doSwitch(input)»
					«ENDFOR»
				);
			«ENDFOR»
			}
			«FOR IOMapping mapping: mappings»
				protected «getType(mapping.right)» «mapping.left.name»_to_«mapping.right.name»(«getType(mapping.left)» value){
					//TODO review autogenerated function
					«getType(mapping.right)» result;
					«IF mapping.left.datatype.equals("integer") && mapping.left.format?.equals("int32")»
						«IF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int32")»
						result = value;
						«ELSEIF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int64")»
						result = value.longValue();
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("float")»
						result = value.floatValue();
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("double")»
						result = value.doubleValue();
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("byte")»
						«to_bytes()»
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("binary")»
						«to_file()»
						«ELSEIF mapping.right.datatype.equals("boolean")»
						result = value > 0 ? Boolean.TRUE : Boolean.FALSE; 
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date")»
						«to_date(LocalDate)»
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date-time")»
						«to_date(OffsetDateTime)»
						«ELSEIF mapping.right.datatype.equals("string")»
						result = value.toString();
						«ENDIF»
					«ELSEIF mapping.left.datatype.equals("integer") && mapping.left.format?.equals("int64")»
						«IF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int32")»
						result = value.intValue(); //WARNING: possible overflow
						«ELSEIF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int64")»
						result = value;
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("float")»
						result = value.floatValue();
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("double")»
						result = value.doubleValue();
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("byte")»
						«to_bytes()»
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("binary")»
						«to_file()»
						«ELSEIF mapping.right.datatype.equals("boolean")»
						result = value > 0 ? Boolean.TRUE : Boolean.FALSE;
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date")»
						«to_date(LocalDate)»
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date-time")»
						«to_date(OffsetDateTime)»
						«ELSEIF mapping.right.datatype.equals("string")»
						result = value.toString();
						«ENDIF»
					«ELSEIF mapping.left.datatype.equals("number") && mapping.left.format?.equals("float")»
						«IF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int32")»
						result = value.intValue(); //WARNING: possible precision loss
						«ELSEIF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int64")»
						result = value.longValue(); //WARNING: possible precision loss
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("float")»
						result = value;
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("double")»
						result = value.doubleValue();
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("byte")»
						«to_bytes()»
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("binary")»
						«to_file()» 
						«ELSEIF mapping.right.datatype.equals("boolean")»
						result = value > 0 ? Boolean.TRUE : Boolean.FALSE; //WARNING: possible precision loss
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date")»
						«to_date(LocalDate)»
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date-time")»
						«to_date(OffsetDateTime)»
						«ELSEIF mapping.right.datatype.equals("string")»
						result = value.toString();
						«ENDIF»	
					«ELSEIF mapping.left.datatype.equals("number") && mapping.left.format?.equals("double")»
						«IF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int32")»
						result = value.intValue(); //WARNING: possible precision loss
						«ELSEIF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int64")»
						result = value.longValue(); //WARNING: possible precision loss
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("float")»
						result = value.floatValue(); //WARNING: possible precision loss
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("double")»
						result = value;
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("byte")»
						«to_bytes()»
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("binary")»
						«to_file()» 
						«ELSEIF mapping.right.datatype.equals("boolean")»
						result = value > 0 ? Boolean.TRUE : Boolean.FALSE; //WARNING: possible precision loss
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date")»
						«to_date(LocalDate)»
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date-time")»
						«to_date(OffsetDateTime)»
						«ELSEIF mapping.right.datatype.equals("string")»
						result = value.toString();
						«ENDIF»	
					«ELSEIF mapping.left.datatype.equals("string") && mapping.left.format?.equals("byte")»
						«IF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int32")»
						«from_bytes(Integer)»
						«ELSEIF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int64")»
						«from_bytes(Long)»
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("float")»
						«from_bytes(Float)»
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("double")»
						«from_bytes(Double)»
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("byte")»
						result = value;
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("binary")»
						//Hassel
						«ELSEIF mapping.right.datatype.equals("boolean")»
						«from_bytes(Boolean)»
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date")»
						«from_bytes(LocalDate)»
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date-time")»
						«from_bytes(OffsetDateTime)»
						«ELSEIF mapping.right.datatype.equals("string")»
						result = value.toString();
						«ENDIF»					
					«ELSEIF mapping.left.datatype.equals("string") && mapping.left.format?.equals("binary")»
						«IF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int32")»
						«from_file(Integer)» 
						«ELSEIF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int64")»
						«from_file(Long)» 
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("float")»
						«from_file(Float)» 
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("double")»
						«from_file(Double)» 
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("byte")»
						//hassel
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("binary")»
						result = value;
						«ELSEIF mapping.right.datatype.equals("boolean")»
						«from_file(Boolean)»
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date")»
						«from_file(LocalDate)»
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date-time")»
						«from_file(OffsetDateTime)»
						«ELSEIF mapping.right.datatype.equals("string")»
						«from_file(String)»
						«ENDIF»	
					«ELSEIF mapping.left.datatype.equals("boolean")»
						«IF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int32")»
						result = value == Boolean.TRUE ? 1 : 0 ; 
						«ELSEIF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int64")»
						result = value == Boolean.TRUE ? 1L : 0L ; 
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("float")»
						result = value == Boolean.TRUE ? 1f : 0f ; 
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("double")»
						result = value == Boolean.TRUE ? 1d : 0d ; 
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("byte")»
						«to_bytes» 
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("binary")»
						«to_file»
						«ELSEIF mapping.right.datatype.equals("boolean")»
						result = value;
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date")»
						result = null;
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date-time")»
						result = null;
						«ELSEIF mapping.right.datatype.equals("string")»
						result = value == Boolean.TRUE ? "true" : "false";
						«ENDIF»					
					«ELSEIF mapping.left.datatype.equals("string") && mapping.left.format?.equals("date")»
						«IF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int32")»
						result = new Long(value.toEpochDay()).intValue();
						«ELSEIF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int64")»
						result = new Long(value.toEpochDay());
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("float")»
						result = new Long(value.toEpochDay()).floatValue();
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("double")»
						result = new Long(value.toEpochDay()).doubleValue();
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("byte")»
						«to_bytes()»
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("binary")»
						«to_file()»
						«ELSEIF mapping.right.datatype.equals("boolean")»
						result = Boolean.FALSE; 
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date")»
						result = value;
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date-time")»
						result = java.time.Instant.ofEpochMilli(
						value.toEpochDay()
						).atZone(java.time.ZoneId.systemDefault())
						.toOffsetDateTime();
						«ELSEIF mapping.right.datatype.equals("string")»
						result = value.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd"));
						«ENDIF»				
					«ELSEIF mapping.left.datatype.equals("string") && mapping.left.format?.equals("date-time")»
						«IF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int32")»
						result = new Long(value.toEpochSecond()).intValue();
						«ELSEIF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int64")»
						result = new Long(value.toEpochSecond()); 
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("float")»
						result = new Long(value.toEpochSecond()).floatValue();
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("double")»
						result = new Long(value.toEpochSecond()).doubleValue();
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("byte")»
						«to_bytes()»
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("binary")»
						«to_file()»
						«ELSEIF mapping.right.datatype.equals("boolean")»
						result = Boolean.FALSE; 
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date")»
						result = value.toLocalDate();
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date-time")»
						result = value;
						«ELSEIF mapping.right.datatype.equals("string")»
						result = value.format(java.time.format.DateTimeFormatter.ISO_INSTANT);
						«ENDIF»					
					«ELSEIF mapping.left.datatype.equals("string")»
						«IF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int32")»
						result = Integer.parseInt(value);  
						«ELSEIF mapping.right.datatype.equals("integer") && mapping.right.format?.equals("int64")»
						result = Long.parseLong(value);
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("float")»
						result = Float.parseFloat(value);
						«ELSEIF mapping.right.datatype.equals("number") && mapping.right.format?.equals("double")»
						result = Double.parseDouble(value);
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("byte")»
						result = value.getBytes();
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("binary")»
						«to_file()»
						«ELSEIF mapping.right.datatype.equals("boolean")»
						result = value.equals("true") ? Boolean.TRUE : Boolean.FALSE; 
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date")»
						result = java.time.LocalDate.parse(value, java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd"));
						«ELSEIF mapping.right.datatype.equals("string") && mapping.right.format?.equals("date-time")»
						result = java.time.OffsetDateTime.parse(value);
						«ELSEIF mapping.right.datatype.equals("string")»
						result = value.toString();
						«ENDIF»				
					«ENDIF»
					return result;
				}
			«ENDFOR»
		}
		'''
		
		
	}
}