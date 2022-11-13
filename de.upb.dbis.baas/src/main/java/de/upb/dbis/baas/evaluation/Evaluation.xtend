package de.upb.dbis.baas.evaluation


import de.upb.dbis.baas.DiscoveryResult
import de.upb.dbis.baas.IO
import de.upb.dbis.baas.Mapping
import de.upb.dbis.baas.Operation
import de.upb.dbis.baas.OperationMapping
import de.upb.dbis.baas.SemanticTypeMapping
import de.upb.dbis.baas.composition.AnalyzerHelper
import de.upb.dbis.baas.model.data.AlignmentIndex
import java.io.BufferedWriter
import java.io.FileWriter
import java.util.ArrayList
import java.util.List
import java.util.Set
import org.apache.jena.ontology.OntModelSpec
import org.apache.jena.rdf.model.Model
import org.apache.jena.rdf.model.ModelFactory
import org.apache.lucene.analysis.Analyzer
import org.apache.lucene.analysis.core.LowerCaseFilterFactory
import org.apache.lucene.analysis.custom.CustomAnalyzer
import org.apache.lucene.analysis.en.EnglishMinimalStemFilterFactory
import org.apache.lucene.analysis.en.EnglishPossessiveFilterFactory
import org.apache.lucene.analysis.en.KStemFilterFactory
import org.apache.lucene.analysis.miscellaneous.WordDelimiterGraphFilterFactory
import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory
import org.apache.lucene.analysis.standard.StandardTokenizerFactory
import org.apache.lucene.analysis.synonym.SynonymGraphFilterFactory
import org.paukov.combinatorics3.Generator
import de.upb.dbis.baas.model.data.Database
import java.util.Map
import java.util.Collections
import java.util.HashMap
import java.io.File
import java.util.LinkedHashMap
import org.apache.lucene.analysis.util.TokenFilterFactory
import de.upb.dbis.baas.annotator.SemanticAnnotator
import de.upb.dbis.baas.annotator.SemanticAnnotator.IndexField
import de.upb.dbis.baas.annotator.SemanticAnnotator.QueryPart

class Evaluation {
	
	
	
	List<Object> bestIndexFields = null
	List<Object> bestQueryParts = null

	static Model ontology = {
		val o = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
		o.read("./data/schema.owl.nt");
  		 
	}
	
	
	
	static def void main(String[] args){
				
		Database.singleton.load()	
		val evaluation = new Evaluation()
//		evaluation.featureSelection()
		evaluation.singleFeatures()
//		evaluation.pipeline()
	}
	
	
	private def printIndexedOperation(Operation operation, Set<String> semanticInputLabels, Set<String> semanticOutputLabels, Analyzer analyzer){
		
		val inputs = operation.ios.filter[i|i.type.equals("input")];
		val outputs = operation.ios.filter[i|i.type.equals("output")];
		
		val inputIds = inputs.map[i|i.name];
		val outputIds = outputs.map[i|i.name];
		
		val inputDescriptions = inputs.map[i|i.description];
		val outputDescriptions = outputs.map[i|i.description];
		
		
		var latex = 
		'''
		\begin{table}
			\centering
			\newcolumntype{P}[1]{>{\raggedright\arraybackslash}p{#1}}
			\footnotesize
			\renewcommand{\arraystretch}{1.5}
			
			\begin{tabular}{P{3.5cm}P{5.2cm}P{5.2cm}}
				\hline
				\rowcolor{grey}
				Index Field & Sample Input & Indexed Terms \\ 	
				\hline 
				Operation Id & «operation.operationId» & «AnalyzerHelper.normalize(analyzer, operation.operationId)»  \\
				
				Operation Description & «operation.description» & «AnalyzerHelper.normalize(analyzer, operation.description)»  \\
				
				Service Description & «operation.specification.description» & «AnalyzerHelper.normalize(analyzer, operation.specification.description)»  \\
				
				Input Parameter Ids & «inputIds» & «AnalyzerHelper.normalize(analyzer, inputIds.toString)»  \\
				
				Output Parameter Ids & «outputIds» & «AnalyzerHelper.normalize(analyzer, outputIds.toString)»  \\  \\
				
				Input Parameter Descriptions & «inputDescriptions» & «AnalyzerHelper.normalize(analyzer, inputDescriptions.toString)»  \\
				
				Output Parameter Descriptions & «outputDescriptions» & «AnalyzerHelper.normalize(analyzer, outputDescriptions.toString)»  \\
				
				Semantic Input Types & «semanticInputLabels» & «AnalyzerHelper.normalize(analyzer, semanticInputLabels.toString)»  \\
				
				Semantic Output Types & «semanticOutputLabels» & «AnalyzerHelper.normalize(analyzer, semanticOutputLabels.toString)»  \\
				
				\hline 
			\end{tabular}
			\caption{Index fields for the indexed operation X}
			\label{tab:IndexFieldsOperation}
		\end{table}		
		'''
		System.out.println(latex);
	}
	
	private def printOperations(List<Operation> operations){
		
		var latex = 
		'''
		\begin{table}
			\centering
			\renewcommand{\arraystretch}{1.5}
			\begin{tabular}{p{4cm}p{4cm}p{6cm}}
				
				\rowcolor{grey}
				API & 
				OperationId &
				Description \\
				\hline
				«FOR Operation operation:operations»
				 & «operation.operationId» & «operation.description» \\
				«ENDFOR»
				\hline 
			\end{tabular}
			\label{tab:Operations}
		\end{table}
		'''
		
		System.out.println(latex);
	}
	
	
	private def printResults(DiscoveryResult unaligned, DiscoveryResult aligned){
		
		val unaligned_reduced = unaligned.mappings.filter[m|m.relevance>=0];
		val aligned_reduced = aligned.mappings.filter[m|m.relevance>=0];
		
		var pairs= new ArrayList<Pair>();
		var bound = Math.min(unaligned_reduced.size, aligned_reduced.size);
		bound = Math.min(10, bound);
		
		//Math.min(unaligned_reduced.size, aligned_reduced.size)
		for(var i=0; i<bound;i++){
			
			var pair = unaligned_reduced.get(i) -> aligned_reduced.get(i);
			pairs.add(pair);
			
		}
		
		var i =1;
		
		var latex = 
		'''
		\begin{table}
			\centering
			\renewcommand{\arraystretch}{1.5}
			\begin{tabular}{p{1cm}p{6cm}p{6cm}}
				
				\rowcolor{grey}
				Rank & 
				Experiment 1 &
				Experiment 2 \\
				\hline
				«FOR pair:pairs»
				«i» & «IF (pair.key as OperationMapping).relevance>0»\cellcolor{relevant}«ELSE»\cellcolor{irrelevant}«ENDIF»«(pair.key as OperationMapping).operation.operationId» & «IF (pair.value as OperationMapping).relevance>0»\cellcolor{relevant}«ELSE»\cellcolor{irrelevant}«ENDIF» «(pair.value as OperationMapping).operation.operationId» \\
				«{i++; ""}»
				«ENDFOR»
				\hline 
			\end{tabular}
			\label{tab:«unaligned.name»Results}
		\end{table}
		'''
		
		System.out.println(latex);
	}
	
	private def assignRelevance(DiscoveryResult result, DiscoveryResult reference){
		
		for(Mapping mapping:result.mappings){
				
				val refMap = reference.mappings.filter[m|(m as OperationMapping).operation.uuid == (mapping as OperationMapping).operation.uuid];
				
				if(refMap!==null && !refMap.isEmpty){
					mapping.relevance = refMap.head.relevance;
				}
				
				if(mapping.relevance>=0){
					
					//System.out.println('''«mapping.score» («mapping.relevance»): «(mapping as OperationMapping).operation.operationId»''');
				}
				
			}
		return result;
	}
	
	def evaluateWithConfiguration2(Analyzer analyzer, File file){
		
		val index_fields = new ArrayList<Object>();
		index_fields.add(SemanticAnnotator.IndexField.LABEL); 
		
		val query_parts = new ArrayList<Object>();
		query_parts.add(SemanticAnnotator.QueryPart.IO_NAME);
		query_parts.add(SemanticAnnotator.QueryPart.IO_DESCRIPTION);
		query_parts.add(SemanticAnnotator.QueryPart.IO_JSONPATH);
		query_parts.add(SemanticAnnotator.QueryPart.OPERATION_ID);
		val annotator = new SemanticAnnotator(index_fields, query_parts, analyzer);
		annotator.doIndex(ontology);
		
		val semanticTypeMappings = AlignmentIndex.singleton.values()
				
		var sum = 0d;
		
		val mappedIOs = semanticTypeMappings.map[m | m.io].toSet;
		
		
		for(IO io : mappedIOs){
			val annotationResult = annotator.query(io);
			
			if(!annotationResult.mappings.empty){
				
				val filteredMapping = semanticTypeMappings.filter[m | m.io.uuid.equals(io.uuid)]
				val semanticTypes = filteredMapping.map[m | m.semantictype.uri].toSet;
				annotationResult.mappings.forEach[m | m.relevance = if(semanticTypes.contains((m as SemanticTypeMapping).semantictype.uri)){1d}else{0d}]
				
				val ap =annotationResult.averagePrecision(semanticTypes.size); 
				
				sum += ap;
			}
			
		}
		var result = sum / mappedIOs.size;
		var stringbuilder = new LinkedHashMap<String, String>();
		stringbuilder.put(LowerCaseFilterFactory.name, "0");
		stringbuilder.put(EnglishMinimalStemFilterFactory.name, "0");
		stringbuilder.put(EnglishPossessiveFilterFactory.name, "0");
		stringbuilder.put(SnowballPorterFilterFactory.name, "0");
		stringbuilder.put(KStemFilterFactory.name, "0");
		stringbuilder.put("ConceptNet Synonyms", "0");
		stringbuilder.put("ConceptNet Related To", "0");
		
		for(TokenFilterFactory factory: (analyzer as CustomAnalyzer).tokenFilterFactories){
			
			if(factory.class === LowerCaseFilterFactory){
				stringbuilder.put(LowerCaseFilterFactory.name, "1");
			}
			if(factory.class === EnglishMinimalStemFilterFactory){
				stringbuilder.put(EnglishMinimalStemFilterFactory.name, "1");
			}
			if(factory.class === EnglishPossessiveFilterFactory){
				stringbuilder.put(EnglishPossessiveFilterFactory.name, "1");
			}
			if(factory.class === SnowballPorterFilterFactory){
				stringbuilder.put(SnowballPorterFilterFactory.name, "1");
			}
			if(factory.class === KStemFilterFactory){
				stringbuilder.put(KStemFilterFactory.name, "1");
			}
			if(factory.class === SynonymGraphFilterFactory){
				if(factory.originalArgs.get("synonyms").equals("conceptnet.synonym.txt")){
					stringbuilder.put("ConceptNet Synonyms", "1");
				}
				
				if(factory.originalArgs.get("synonyms").equals("conceptnet.relatedto.txt")){
					stringbuilder.put("ConceptNet Related To", "1");
				}
				
			}
						
		}
		write(stringbuilder.values.join(";")+";"+result, file);		
		
				
	}	
	

	def evaluateWithConfiguration(List<Object> configuration, Analyzer analyzer, File file){
		
		val index_fields = new ArrayList<Object>();
		val query_parts = new ArrayList<Object>();
		configuration.filter[p | p instanceof IndexField].forEach[i|index_fields.add(i)];
		configuration.filter[p | p instanceof QueryPart].forEach[i|query_parts.add(i)];
		
		
		val annotator = new SemanticAnnotator(index_fields, query_parts, analyzer);
		annotator.doIndex(ontology);
		
		val semanticTypeMappings = AlignmentIndex.singleton.values()
				
		var sum = 0d;
		
		val mappedIOs = semanticTypeMappings.map[m | m.io].toSet;
		
		var maximum = 0d;
		
		
		for(IO io : mappedIOs){
			val annotationResult = annotator.query(io);
			
			if(!annotationResult.mappings.empty){
				
				val filteredMapping = semanticTypeMappings.filter[m | m.io.uuid.equals(io.uuid)]
				val semanticTypes = filteredMapping.map[m | m.semantictype.uri].toSet;
				annotationResult.mappings.forEach[m | m.relevance = if(semanticTypes.contains((m as SemanticTypeMapping).semantictype.uri)){1d}else{0d}]
				
				val ap =annotationResult.averagePrecision(semanticTypes.size); 
				
				sum += ap;
			}
			
		}
		var result = sum / mappedIOs.size;
		if(result>maximum){
			maximum = result
			
			bestIndexFields = annotator.indexFields.map[i|i as Object].toList
			bestQueryParts = annotator.queryParts.map[i|i as Object].toList
		}
		
		var contents = '''«IF configuration.contains(IndexField.LABEL)»1«ELSE»0«ENDIF»;«IF configuration.contains(IndexField.COMMENT)»1«ELSE»0«ENDIF»;«IF configuration.contains(QueryPart.IO_NAME)»1«ELSE»0«ENDIF»;«IF configuration.contains(QueryPart.IO_JSONPATH)»1«ELSE»0«ENDIF»;«IF configuration.contains(QueryPart.IO_DESCRIPTION)»1«ELSE»0«ENDIF»;«IF configuration.contains(QueryPart.OPERATION_ID)»1«ELSE»0«ENDIF»;«IF configuration.contains(QueryPart.OPERATION_DESCRIPTION)»1«ELSE»0«ENDIF»;«IF configuration.contains(QueryPart.SERVICE_DESCRIPTION)»1«ELSE»0«ENDIF»;«result»'''
		write(contents, file);
				
	}
	
	protected def write(String line, File file){
		
		if(!file.parentFile.exists){
			file.parentFile.mkdirs
			file.createNewFile
		}
		
		System.out.println(line);
		this.write(line, file, true);
	}
	
	protected def write(String line, File file, boolean append){
	 	
	 	var output = new BufferedWriter(new FileWriter(file.absolutePath, append));  //clears file every time
	 	
	 	
		output.append(line+"\n");
		output.close();
	 }
	 
	def pipeline(){
		
		val file = new File("./results/pipelineSelection.csv")
		var lowerCase = new ArrayList<Pair<Class, Map>>();
		lowerCase.add(null);
		lowerCase.add(LowerCaseFilterFactory -> Collections.EMPTY_MAP);
		
		var stemmers = new ArrayList<Pair<Class, Map>>();
		stemmers.add(null);
		stemmers.add(EnglishMinimalStemFilterFactory -> Collections.EMPTY_MAP);
		stemmers.add(EnglishPossessiveFilterFactory -> Collections.EMPTY_MAP);
		stemmers.add(SnowballPorterFilterFactory -> Collections.EMPTY_MAP);	
		stemmers.add(KStemFilterFactory -> Collections.EMPTY_MAP);
		
		var synomys = new ArrayList<Pair<Class, Map>>();
		synomys.add(null);
		synomys.add(SynonymGraphFilterFactory -> #{"synonyms"-> "conceptnet.synonym.txt", "format"->"solr", "ignoreCase"->"false", "expand"->"true"});
		synomys.add(SynonymGraphFilterFactory -> #{"synonyms"-> "conceptnet.relatedto.txt", "format"->"solr", "ignoreCase"->"false", "expand"->"true"});

		
		var contents = '''"Lowercase";"English Minimal Stemmer";"English Possessive Stemmer";"Snowball Porter Stemmer";"KStemmer";"ConceptNet Synonyms";"ConceptNet Related To";"MAP"''';
		write(contents, file)
		
		Generator.cartesianProduct(
			lowerCase, 
			stemmers,
			synomys
		).stream()
		.forEach( x | {
			val a = CustomAnalyzer.builder()
   			.withTokenizer(StandardTokenizerFactory)
   			.addTokenFilter(WordDelimiterGraphFilterFactory, 
   				"preserveOriginal", "0",
   				"splitOnNumerics", "1",
   				"splitOnCaseChange", "1", 
   				"catenateWords", "0",
   				"catenateNumbers", "0",
   				"catenateAll", "0",
   				"generateWordParts", "1",
   				"generateNumberParts", "0",
   				"stemEnglishPossessive", "0"
   				)
			x.forEach[k | 
			if(k !==null){
				if(k.value.empty){
					
					a.addTokenFilter(k.key);
				}
				else{
					a.addTokenFilter(k.key, new HashMap<String, String>(k.value));
				}
			}]
			evaluateWithConfiguration2(a.build(), file);
			
		}
		)
	}
	
	def featureSelection(){
		
		
		val file = new File("./results/featureSelection.csv")
		
		val index_fields = new ArrayList<Object>();
		index_fields.add(SemanticAnnotator.IndexField.LABEL); 
		index_fields.add(SemanticAnnotator.IndexField.COMMENT); 
		
		val query_parts = new ArrayList<Object>();
		query_parts.add(SemanticAnnotator.QueryPart.IO_NAME);
		query_parts.add(SemanticAnnotator.QueryPart.IO_DESCRIPTION);
		query_parts.add(SemanticAnnotator.QueryPart.IO_JSONPATH);
		query_parts.add(SemanticAnnotator.QueryPart.OPERATION_ID);
		query_parts.add(SemanticAnnotator.QueryPart.OPERATION_DESCRIPTION); 
		query_parts.add(SemanticAnnotator.QueryPart.SERVICE_DESCRIPTION); 
		
		val analyzer = CustomAnalyzer.builder()
   			.withTokenizer(StandardTokenizerFactory)
   			.addTokenFilter(WordDelimiterGraphFilterFactory, 
   				"preserveOriginal", "0",
   				"splitOnNumerics", "1",
   				"splitOnCaseChange", "1", 
   				"catenateWords", "0",
   				"catenateNumbers", "0",
   				"catenateAll", "0",
   				"generateWordParts", "1",
   				"generateNumberParts", "0",
   				"stemEnglishPossessive", "0"
   				)
   			.addTokenFilter(LowerCaseFilterFactory)
   			.addTokenFilter(EnglishMinimalStemFilterFactory)
   			//.addTokenFilter(PatternCaptureGroupFilterFactory, "preserve_original", "true", "pattern", "(([a-z]+)(id$)|(brand)|(info))")
			//.addTokenFilter(StopFilterFactory, "ignoreCase", "true", "words", "stopwords.txt", "format", "wordset")
			//.addTokenFilter(SynonymGraphFilterFactory, "synonyms", "synonyms.txt", "format", "solr", "ignoreCase", "false", "expand", "true")
			//.addTokenFilter(SynonymGraphFilterFactory, "synonyms", "conceptnet.synonym.txt", "format", "solr", "ignoreCase", "false", "expand", "true")
			.build();
			
		
		var contents = '''"«IndexField.LABEL.name»";"«IndexField.COMMENT.name»";"«QueryPart.IO_NAME»";"«QueryPart.IO_JSONPATH»";"«QueryPart.IO_DESCRIPTION»";"«QueryPart.OPERATION_ID»";"«QueryPart.OPERATION_DESCRIPTION»";"«QueryPart.SERVICE_DESCRIPTION»";"MeanAveragePrecision"''';
		
		//contents = '''"«LowerCaseFilterFactory.name»";"«EnglishMinimalStemFilterFactory.name»";"«EnglishPossessiveFilterFactory.name»";"«SnowballPorterFilterFactory.name»";"«KStemFilterFactory.name»";"ConceptNet Synonyms";"ConceptNet Related To";"MAP"''';
		
		write(contents, file, false);
		

		Generator.cartesianProduct(
			Generator.subset(index_fields).simple().toList, 
			Generator.subset(query_parts).simple().toList
		).stream()
		.forEach( x | evaluateWithConfiguration(x.flatten.toList, analyzer, file))
		 
		
		/*
		
		var lowerCase = new ArrayList<Pair<Class, Map>>();
		lowerCase.add(null);
		lowerCase.add(LowerCaseFilterFactory -> Collections.EMPTY_MAP);
		
		var stemmers = new ArrayList<Pair<Class, Map>>();
		stemmers.add(null);
		stemmers.add(EnglishMinimalStemFilterFactory -> Collections.EMPTY_MAP);
		stemmers.add(EnglishPossessiveFilterFactory -> Collections.EMPTY_MAP);
		stemmers.add(SnowballPorterFilterFactory -> Collections.EMPTY_MAP);	
		stemmers.add(KStemFilterFactory -> Collections.EMPTY_MAP);
		
		//.addTokenFilter(SynonymGraphFilterFactory, "synonyms", "conceptnet.synonym.txt", "format", "solr", "ignoreCase", "false", "expand", "true")
		var synomys = new ArrayList<Pair<Class, Map>>();
		synomys.add(null);
		synomys.add(SynonymGraphFilterFactory -> #{"synonyms"-> "conceptnet.synonym.txt", "format"->"solr", "ignoreCase"->"false", "expand"->"true"});
		synomys.add(SynonymGraphFilterFactory -> #{"synonyms"-> "conceptnet.relatedto.txt", "format"->"solr", "ignoreCase"->"false", "expand"->"true"});
		
		Generator.cartesianProduct(
			lowerCase, 
			stemmers,
			synomys
		).stream()
		.forEach( x | {
			val a = CustomAnalyzer.builder()
   			.withTokenizer(StandardTokenizerFactory)
   			.addTokenFilter(WordDelimiterGraphFilterFactory, 
   				"preserveOriginal", "0",
   				"splitOnNumerics", "1",
   				"splitOnCaseChange", "1", 
   				"catenateWords", "0",
   				"catenateNumbers", "0",
   				"catenateAll", "0",
   				"generateWordParts", "1",
   				"generateNumberParts", "0",
   				"stemEnglishPossessive", "0"
   				)
			x.forEach[k | if(k !==null){
//				System.out.println(k);
//				System.out.println(k.key);
//				System.out.println(k.value);
				if(k.value.empty){
					
					a.addTokenFilter(k.key);
				}
				else{
					a.addTokenFilter(k.key, new HashMap<String, String>(k.value));
				}
			}]
			evaluateWithConfiguration(#[IndexField.LABEL, QueryPart.IO_NAME, QueryPart.IO_DESCRIPTION, QueryPart.OPERATION_ID], a.build());
			
		}
		)
		*/
       
	}
	
	def singleFeatures(){
		
		
		val file = new File("./results/singleFeature.csv")
		
		val index_fields = new ArrayList<Object>();
		index_fields.add(SemanticAnnotator.IndexField.LABEL); 
		index_fields.add(SemanticAnnotator.IndexField.COMMENT); 
		
		val query_parts = new ArrayList<Object>();
		query_parts.add(SemanticAnnotator.QueryPart.IO_NAME);
		query_parts.add(SemanticAnnotator.QueryPart.IO_DESCRIPTION);
		query_parts.add(SemanticAnnotator.QueryPart.IO_JSONPATH);
		query_parts.add(SemanticAnnotator.QueryPart.OPERATION_ID);
		query_parts.add(SemanticAnnotator.QueryPart.OPERATION_DESCRIPTION); 
		query_parts.add(SemanticAnnotator.QueryPart.SERVICE_DESCRIPTION); 
		
		val analyzer = CustomAnalyzer.builder()
   			.withTokenizer(StandardTokenizerFactory)
   			.addTokenFilter(WordDelimiterGraphFilterFactory, 
   				"preserveOriginal", "0",
   				"splitOnNumerics", "1",
   				"splitOnCaseChange", "1", 
   				"catenateWords", "0",
   				"catenateNumbers", "0",
   				"catenateAll", "0",
   				"generateWordParts", "1",
   				"generateNumberParts", "0",
   				"stemEnglishPossessive", "0"
   				)
   			.addTokenFilter(LowerCaseFilterFactory)
   			.addTokenFilter(EnglishMinimalStemFilterFactory)
   			//.addTokenFilter(PatternCaptureGroupFilterFactory, "preserve_original", "true", "pattern", "(([a-z]+)(id$)|(brand)|(info))")
			//.addTokenFilter(StopFilterFactory, "ignoreCase", "true", "words", "stopwords.txt", "format", "wordset")
			//.addTokenFilter(SynonymGraphFilterFactory, "synonyms", "synonyms.txt", "format", "solr", "ignoreCase", "false", "expand", "true")
			//.addTokenFilter(SynonymGraphFilterFactory, "synonyms", "conceptnet.synonym.txt", "format", "solr", "ignoreCase", "false", "expand", "true")
			.build();
			
		
		var contents = '''"«IndexField.LABEL.name»";"«IndexField.COMMENT.name»";"«QueryPart.IO_NAME»";"«QueryPart.IO_JSONPATH»";"«QueryPart.IO_DESCRIPTION»";"«QueryPart.OPERATION_ID»";"«QueryPart.OPERATION_DESCRIPTION»";"«QueryPart.SERVICE_DESCRIPTION»";"MeanAveragePrecision"''';
		
		//contents = '''"«LowerCaseFilterFactory.name»";"«EnglishMinimalStemFilterFactory.name»";"«EnglishPossessiveFilterFactory.name»";"«SnowballPorterFilterFactory.name»";"«KStemFilterFactory.name»";"ConceptNet Synonyms";"ConceptNet Related To";"MAP"''';
		
		write(contents, file, false);
		

		Generator.cartesianProduct(
			Generator.combination(index_fields).simple(1).toList, 
			Generator.combination(query_parts).simple(1).toList
		).stream()
		.forEach( x | evaluateWithConfiguration(x.flatten.toList, analyzer, file))
		 
       
	}	
	

}