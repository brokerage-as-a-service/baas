package de.upb.dbis.baas.composition

import de.upb.dbis.baas.util.BaasSwitch
import de.upb.dbis.baas.IO
import java.util.HashMap
import org.eclipse.emf.ecore.EObject
import java.util.Set
import de.upb.dbis.baas.Specification

class NameProvider extends BaasSwitch<String> {
	
	private HashMap<EObject, String> registry = new HashMap<EObject, String>();
	
	static Set<String> KEYWORDS = #{
		"abstract",
		"assert",
		"boolean",
		"break",
		"byte",
		"case",
		"catch",
		"char",
		"class",
		"continue",
		"default",
		"do",
		"double",
		"else",
		"enum",
		"exports",
		"extends",
		"final",
		"finally",
		"float",
		"for",
		"if",
		"implements",
		"import",
		"instanceof",
		"int",
		"interface",
		"long",
		"module",
		"native",
		"new",
		"package",
		"private",
		"protected",
		"public",
		"requires",
		"return",
		"short",
		"static",
		"strictfp",
		"super",
		"switch",
		"synchronized",
		"this",
		"throw",
		"throws",
		"transient",
		"try",
		"void",
		"volatile",
		"while",
		"true",
		"null",
		"false",
		"var"
	};
	
	
	override caseSpecification(Specification specification){
		
		return escapeKeyword(specification.name);

		
	}
	
	private def String escapeKeyword(String name){
		var name_ = name;
		if(KEYWORDS.contains(name_)){
			name_ = name+"_";
		}
		return name_;
	}
	
	override caseIO(IO io){
		
		if(registry.containsKey(io)){
			return registry.get(io);
		}
		
		var name = io.name;
		if(registry.values.contains(name)){
			name = io.operation.operationId + "_" + name;
		}		
		
		name = escapeKeyword(name);
		
		registry.put(io, name);
		return name;
		
		
	}
}