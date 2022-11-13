package de.upb.dbis.baas.model.data

import de.upb.dbis.baas.IO
import de.upb.dbis.baas.Specification
import de.upb.dbis.baas.annotator.SpecificationLoader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.HashMap
import java.util.UUID
import de.upb.dbis.baas.annotator.RapidApiAdapter

class ParameterIndex {

	var index = new HashMap<String, IO>()
	static val singleton2 = new ParameterIndex()

	static def singleton() {
		return singleton2
	}


	def load() {

//		var file = new File("./temp/parameterindex.hashmap")
//		if (file.exists) {
//			try {
//				var fileInput = new FileInputStream(file.absolutePath);
//
//				var objectInput = new ObjectInputStream(fileInput);
//
//				index = objectInput.readObject() as HashMap<String, IO>;
//
//				objectInput.close();
//				fileInput.close();
//			} catch (IOException obj1) {
//				obj1.printStackTrace();
//				return;
//			} catch (ClassNotFoundException obj2) {
//				System.out.println("Class not found");
//				obj2.printStackTrace();
//				return;
//			}
//		}

		System.out.println("WRITE!!!!!!!!!!!")
		var openapis = new RapidApiAdapter().doLoad("./data/apis");
		var specs = new SpecificationLoader().load(openapis);
		for (Specification specification : specs) {

			var treeiterator = specification.eAllContents();

			while (treeiterator.hasNext) {
				var next = treeiterator.next;

				if (next instanceof IO) {
					System.out.
						println('''write «key(next.operation.specification.host, next.operation.operationId, next.name, next.jsonPath?:"")»''');
					index.put(
						key(next.operation.specification.host, next.operation.operationId, next.name?:"",
							next.jsonPath ?: ""), next)
				}

			}
		}

//		try {
//			
//			if(file.exists){
//				file.delete
//				
//			}else{
//				file.getParentFile().mkdirs();
//			}
//			var myFileOutStream
//                = new FileOutputStream(
//                    file.absolutePath);
//
//			var myObjectOutStream = new ObjectOutputStream(myFileOutStream);
//
//			myObjectOutStream.writeObject(index);
//
//			myObjectOutStream.close();
//			myFileOutStream.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

	private def key(String servicename, String operationId, String name, String jsonpath) {
		// System.out.println('''«servicename».«operationId».«name».«jsonpath»''')
		return '''«servicename».«operationId».«name».«jsonpath»'''
	}

	def IO get(String servicename, String operationId, String name, String jsonpath) {
		System.out.println('''read «key(servicename, operationId, name, jsonpath)»''')
		return index.get(key(servicename, operationId, name, jsonpath))
	}
}
