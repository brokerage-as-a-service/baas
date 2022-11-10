package de.upb.dbis.baas.discovery

import de.upb.dbis.baas.annotator.SpecificationLoader
import de.upb.dbis.baas.BaasFactory
import de.upb.dbis.baas.DiscoveryResult
import de.upb.dbis.baas.Operation
import de.upb.dbis.baas.Specification
import java.io.File
import java.nio.file.Paths
import java.util.ArrayList
import java.util.Collections
import java.util.HashSet
import java.util.List
import java.util.Set
import java.util.UUID
import org.apache.lucene.analysis.Analyzer
import org.apache.lucene.analysis.core.LowerCaseFilterFactory
import org.apache.lucene.analysis.custom.CustomAnalyzer
import org.apache.lucene.analysis.en.EnglishMinimalStemFilterFactory
import org.apache.lucene.analysis.miscellaneous.WordDelimiterGraphFilterFactory
import org.apache.lucene.analysis.standard.StandardTokenizerFactory
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute
import org.apache.lucene.document.Document
import org.apache.lucene.document.Field
import org.apache.lucene.document.StringField
import org.apache.lucene.document.TextField
import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.index.IndexWriterConfig
import org.apache.lucene.index.Term
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser
import org.apache.lucene.queryparser.classic.QueryParser
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.TermQuery
import org.apache.lucene.store.Directory
import org.apache.lucene.store.MMapDirectory

class Discoverer {
	
	static int CUTOFF = 10000;
	
	public static Analyzer DEFAULT_ANALYZER = CustomAnalyzer.builder()
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
			.build();
	
	enum IndexField{
		OPERATION_ID,
		OPERATION_DESCRIPTION,
		SERVICE_DESCRIPTION,
		IN,
		OUT,
		IN_DESCRIPTIONS,
		OUT_DESCRIPTIONS,
		SEMANTIC_IN,
		SEMANTIC_OUT	
	}
	
	static String FIELD_PATH = "path";
	static String FIELD_METHOD = "method";
	static String FIELD_RESPONSE = "response";
	static String FIELD_OPERATION_UUID = "uuid";
	
	String path = null;
	Analyzer analyzer = null;
	Directory index = null;
	QueryParser queryparser = null;
	
	List<IndexField> index_fields = new ArrayList<IndexField>();
	
	SpecificationLoader loader = new SpecificationLoader();
	
	
	new(){
		
		this.analyzer=DEFAULT_ANALYZER;
		this.index_fields = new ArrayList<IndexField>(#[
			IndexField.OPERATION_ID, 
			IndexField.OPERATION_DESCRIPTION, 
			IndexField.SERVICE_DESCRIPTION, 
			IndexField.IN,
			IndexField.IN_DESCRIPTIONS,  
			IndexField.OUT,
			IndexField.OUT_DESCRIPTIONS
		]);
		this.path = UUID.randomUUID.toString; 
		
	}
	
	
	def indexFields(List<Object> index_fields){
		this.index_fields.clear;
		for (Object object : index_fields) {
			if (object instanceof IndexField) {
				this.index_fields.add(object);
			}
		}
		return this;	
	}
	def analyzer(Analyzer analyzer){
		this.analyzer = analyzer;
		return this;
	}
	
	def path(String path){
		this.path = path;
		return this;
	}
	
	def build(){
		index = new MMapDirectory(Paths.get(path));
		queryparser = new MultiFieldQueryParser(this.index_fields.map[p|p.name], this.analyzer);
		return this;
	}
	
	def Document getDocumentById(String id){
		
		val reader = DirectoryReader.open(index);
        val searcher = new IndexSearcher(reader);
        
        val docs = searcher.search(new TermQuery(new Term(FIELD_OPERATION_UUID,id)),1);
        
         if (docs.totalHits > 0) {
        	 val doc = searcher.doc(docs.scoreDocs.get(0).doc);
    	     return doc;
	     }
		
	}
	
 	def DiscoveryResult query(String querystring){
 		
 		var result = BaasFactory.eINSTANCE.createDiscoveryResult;
 		
		if(index_fields.empty && !querystring.empty){
			System.out.println("There is nothing to query.");
			return result;
		}
		
		if (!DirectoryReader.indexExists(index)) {
			throw new IllegalStateException("create index before you query");
		}
 		
 		var reader = DirectoryReader.open(index);
        var searcher = new IndexSearcher(reader);
        
        try{
	    	val query = queryparser.parse(querystring);
	        val docs = searcher.search(query, CUTOFF);
	        val hits = docs.scoreDocs;
	        var score = 0d;
	        for(var i=0; i<hits.length; i++) {
	            var docId = hits.get(i).doc;
	            
	            score = hits.get(i).score;
	            var d = searcher.doc(docId);
	            //result.add(d.get(FIELD_OPID));
	            
	            var mapping = BaasFactory.eINSTANCE.createOperationMapping;
	            mapping.score = score;
	            var operation = BaasFactory.eINSTANCE.createOperation;
	            operation.uuid = d.get(FIELD_OPERATION_UUID)
	            operation.method =d.get(FIELD_METHOD)
	            operation.path = d.get(FIELD_PATH)
	            operation.responseCode = d.get(FIELD_RESPONSE)
	            operation.operationId = d.get(IndexField.OPERATION_ID.name);
	            operation.description = d.get(IndexField.OPERATION_DESCRIPTION.name);
	            
	            /*
				System.out.println(
				'''
				«score»: «operation.operationId»
					«FOR IndexField i_:this.index_fields»
						«i_.name» = «tokenstream2set("", d.get(i_.name))»;
					«ENDFOR»
				''');
				*/
				//System.out.println('''«score»: «operation.operationId» («operation.description»)''');				
				
	            
	            mapping.operation = operation;
	            result.mappings.add(mapping);
	            
	        } 
	        //System.out.println("============");       
        	
        }
        catch(Exception e){
        	
        }
        finally{
        	
        	reader.close;
        }
        
    	
        
        
        
        return result;
        
 	}
 	
 	def tokenstream2set(String field, String text){
            
        var results = new HashSet<String>();
        val stream = analyzer.tokenStream(field, text);
        stream.reset();
        while (stream.incrementToken()) {
            var ct = stream.getAttribute(CharTermAttribute);
            results.add(ct.toString());
        }
        stream.end();
        stream.close();
        return results;

 	}	
	
	def doIndex(String repositoryPath){
		
		var dir = new File(repositoryPath);
		
		
		doIndex(dir);
		
	}
	
	def doIndex(File directory){
		
		var specs = new ArrayList<Specification>();
		for(File spec :directory.listFiles){
			
			if(spec.name.endsWith("json") || spec.name.endsWith("yaml")){
				
				//var openAPI = new OpenAPIV3Parser().read(spec.absolutePath);
				var openAPI = loader.load(spec.absolutePath);
				specs.add(openAPI);
			}
		}
		doIndex(specs);
		
	}
	
	def Set<String> semanticAnnotations(String uuid){
		
		return Collections.EMPTY_SET;
	}
	
	def boolean hasIndex(){
		return DirectoryReader.indexExists(index);
		
	}
	
	def void doIndex(List<Specification> openAPIs){
		
		if(index_fields.empty){
			System.out.println("Nothing to index");
			return;
		}
		
		
		var config = new IndexWriterConfig(analyzer);
		var writer = new IndexWriter(index, config);
		
		
		for(Specification openAPI : openAPIs){
			
			val specification_description = openAPI.description ?: "";
			
			for(Operation operation: openAPI.operations){
				
				var doc = new Document();
				
				doc.add(new StringField(FIELD_OPERATION_UUID, operation.uuid, Field.Store.YES));
				doc.add(new StringField(FIELD_RESPONSE, operation.responseCode ?: "", Field.Store.YES));
				doc.add(new StringField(FIELD_PATH, operation.path, Field.Store.YES));
				doc.add(new StringField(FIELD_METHOD, operation.method ?: "", Field.Store.YES));
				
				if (index_fields.contains(IndexField.OPERATION_ID)) {
					val contents = operation.operationId ?:"" ;
					doc.add(new TextField(IndexField.OPERATION_ID.name, contents, Field.Store.YES));

				}
				if (index_fields.contains(IndexField.OPERATION_DESCRIPTION)) {
					val contents = operation.description ?: "";
					doc.add(new TextField(IndexField.OPERATION_DESCRIPTION.name, contents, Field.Store.YES));

				}
				if (index_fields.contains(IndexField.SERVICE_DESCRIPTION)) {
					doc.add(new TextField(IndexField.SERVICE_DESCRIPTION.name, specification_description, Field.Store.YES));

				}
				if (index_fields.contains(IndexField.IN)) {
					
					val tokens = operation.ios.filter[io|io.type=="input"].map[io|io.name].toSet;
					doc.add(new TextField(IndexField.IN.name, tokens.toString, Field.Store.YES));
				}
				
				if (index_fields.contains(IndexField.OUT)) {
					
					val tokens = operation.ios.filter[io|io.type=="output"].map[io|io.name].toSet;
					doc.add(new TextField(IndexField.OUT.name, tokens.toString, Field.Store.YES));
				}
				
				if (index_fields.contains(IndexField.IN_DESCRIPTIONS)) {
					
					val tokens = operation.ios.filter[io|io.type=="input"].map[io|io.description].toSet;
					doc.add(new TextField(IndexField.IN_DESCRIPTIONS.name, tokens.toString, Field.Store.YES));
				}
				
				if (index_fields.contains(IndexField.OUT_DESCRIPTIONS)) {
					
					val tokens = operation.ios.filter[io|io.type=="output"].map[io|io.description].toSet;
					doc.add(new TextField(IndexField.OUT_DESCRIPTIONS.name, tokens.toString, Field.Store.YES));
				}				
				
				if (index_fields.contains(IndexField.OUT)) {
					
					val tokens = operation.ios.filter[io|io.type=="output"].map[io|io.name].toSet;
					doc.add(new TextField(IndexField.OUT.name, tokens.toString, Field.Store.YES));
				}				

			
				
				if (index_fields.contains(IndexField.SEMANTIC_IN)) {
					val inputs = operation.ios.filter[io|io.type=="input"].iterator;
					
					var tokens = new HashSet<String>();					
					while(inputs.hasNext){
						val input = inputs.next;
						
						val strings = semanticAnnotations(input.uuid);
						
						tokens.addAll(strings);
						

					}

					doc.add(new TextField(IndexField.SEMANTIC_IN.name, tokens.toString, Field.Store.YES));					
				}
				
				if (index_fields.contains(IndexField.SEMANTIC_OUT)) {
					val inputs = operation.ios.filter[io|io.type=="output"].iterator;
					var tokens = new HashSet<String>();
					
					while(inputs.hasNext){
						val input = inputs.next;
						
						val strings = semanticAnnotations(input.uuid);
						
						tokens.addAll(strings);
						
					}

					doc.add(new TextField(IndexField.SEMANTIC_OUT.name, tokens.toString, Field.Store.YES));					
				}				
				
				
				writer.addDocument(doc);
				
			}
			
		}
		
		writer.close;
		
		
	}	
	

	



	
}