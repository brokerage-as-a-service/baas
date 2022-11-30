package de.upb.dbis.baas.composition

import io.swagger.v3.oas.models.media.ArraySchema
import io.swagger.v3.oas.models.media.BinarySchema
import io.swagger.v3.oas.models.media.BooleanSchema
import io.swagger.v3.oas.models.media.ByteArraySchema
import io.swagger.v3.oas.models.media.ComposedSchema
import io.swagger.v3.oas.models.media.DateSchema
import io.swagger.v3.oas.models.media.DateTimeSchema
import io.swagger.v3.oas.models.media.EmailSchema
import io.swagger.v3.oas.models.media.FileSchema
import io.swagger.v3.oas.models.media.IntegerSchema
import io.swagger.v3.oas.models.media.MapSchema
import io.swagger.v3.oas.models.media.NumberSchema
import io.swagger.v3.oas.models.media.ObjectSchema
import io.swagger.v3.oas.models.media.PasswordSchema
import io.swagger.v3.oas.models.media.Schema
import io.swagger.v3.oas.models.media.StringSchema
import io.swagger.v3.oas.models.media.UUIDSchema
import java.util.Collection
import java.util.HashMap
import java.util.Stack
import de.upb.dbis.baas.IO
import de.upb.dbis.baas.BaasFactory
import java.util.UUID
import java.util.LinkedHashMap

class SchemaVisitor {

	protected Stack<String> jsonPath = new Stack<String>()

	protected LinkedHashMap<String, IO> registry = new LinkedHashMap<String, IO>()

	protected String lastName = ""

	protected HashMap<String, Object> components = new HashMap<String, Object>()

	new() {
	}

	new(HashMap<String, Object> components) {
		this.components = components
		
	}

	def Collection<IO> traverseRoot(Schema schema) {
		registry = new LinkedHashMap<String, IO>()
		jsonPath = new Stack<String>()
		if (schema !== null) {

			jsonPath.push("$");
			System.out.println(jsonPath)
			traverseSchema(schema);
			jsonPath.pop();
			System.out.println(jsonPath)
		}

		return registry.values;

	}

	protected def void traverseSchema(Schema schema) {

		if (schema instanceof BooleanSchema || schema instanceof BinarySchema || schema instanceof DateSchema ||
			schema instanceof DateTimeSchema || schema instanceof EmailSchema || schema instanceof FileSchema ||
			schema instanceof IntegerSchema || schema instanceof NumberSchema || schema instanceof PasswordSchema ||
			schema instanceof StringSchema || schema instanceof UUIDSchema) {

			var jsonPath_ = JsonPathHelper.printJsonPath(jsonPath);

			var output = null as IO;
			if (registry.containsKey(jsonPath)) {
				output = registry.get(jsonPath);
			} else {
				output = BaasFactory.eINSTANCE.createIO();
				output.type = "output";
				output.uuid = UUID.randomUUID.toString;
			}

			output.name = lastName;
			// output.nameTokenized = AnalyzerHelper.normalize(AnalyzerHelper.ANALYZER_ID, lastName);
			output.jsonPath = JsonPathHelper.printJsonPath(jsonPath);
			// output.jsonPathTokenized = AnalyzerHelper.normalize(AnalyzerHelper.ANALYZER_ID, jsonPath_);
			output.description = schema.description;
			// output.descriptionTokenized = AnalyzerHelper.normalize(AnalyzerHelper.ANALYZER_TEXT, output.descriptionRaw);
			output.datatype = schema.type;
			output.format = schema.format;
			
			registry.put(jsonPath_, output);
			System.out.println(jsonPath)
		} else if (schema instanceof ArraySchema) {

			if (schema.items !== null) {
				val schemaref = schema.items.get$ref()


				if (schemaref !== null) {
					val component2 = schema.items.$ref(schema.items.get$ref)
					val component = components.get(schemaref) as Schema
					jsonPath.push("[*]");
					System.out.println(jsonPath)
					traverseSchema(component)
					jsonPath.pop()
					System.out.println(jsonPath)
				}
				else{
					jsonPath.push("[*]");
					var childschema = null as StringSchema
					switch(schema.items.type){
						case "string": childschema = new StringSchema()
					}
					traverseSchema(childschema)
					jsonPath.pop()					
				}

			}

		} else if (schema instanceof ByteArraySchema) {
		} else if (schema instanceof ComposedSchema) {
		} else if (schema instanceof MapSchema) {
		} else if (schema instanceof ObjectSchema) {
			if (schema.properties !== null) {

				for (Object name : schema.properties.keySet) {
					var item = schema.properties.get(name);
					if (item instanceof Schema) {
						jsonPath.push('''«name»''');
						System.out.println(jsonPath)
						lastName = name as String;
						traverseSchema(item as Schema);
						jsonPath.pop();
						System.out.println(jsonPath)
					}

				}
				
				schema.additionalProperties

			}
			
			if(schema.additionalProperties instanceof Schema){
				val childschema = schema.additionalProperties as Schema
				val component = components.get(childschema.get$ref()) as Schema
				jsonPath.push("[*]");
				traverseSchema(component)
				jsonPath.pop();
				
			}
			
			

		} else {
		}

	}

}
