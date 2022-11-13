package de.upb.dbis.baas.annotator

import de.upb.dbis.baas.AnnotationResult
import de.upb.dbis.baas.IO
import de.upb.dbis.baas.impl.AnnotatorImpl
import de.upb.dbis.baas.composition.AnalyzerHelper
import java.nio.file.Paths
import java.util.ArrayList
import java.util.Collection
import java.util.HashSet
import java.util.List
import java.util.UUID
import org.apache.jena.ontology.OntResource
import org.apache.jena.rdf.model.Model
import org.apache.jena.vocabulary.RDFS
import org.apache.lucene.analysis.Analyzer
import org.apache.lucene.document.Document
import org.apache.lucene.document.Field
import org.apache.lucene.document.StringField
import org.apache.lucene.document.TextField
import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.index.IndexWriterConfig
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser
import org.apache.lucene.queryparser.classic.QueryParser
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.MatchAllDocsQuery
import org.apache.lucene.store.Directory
import org.apache.lucene.store.MMapDirectory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import de.upb.dbis.baas.BaasFactory

class SemanticAnnotator extends AnnotatorImpl {

	static HashSet<Integer> ALL_DOCUMENTS;

	enum IndexField {
		COMMENT,
		LABEL
	}

	enum QueryPart {
		IO_NAME,
		IO_DESCRIPTION,
		IO_JSONPATH,
		OPERATION_ID,
		OPERATION_DESCRIPTION,
		SERVICE_DESCRIPTION
	}

//	public static String FIELD_LABEL = "label";
//	public static String FIELD_COMMENT = "comment";
//	public static String FIELD_URI = "uri";
//	
//	
//	public static String FIELD_IONAME = "io_name";
//	public static String FIELD_IO_DESCRIPTION = "io_description";
//	public static String FIELD_JSONPATH = "io_jsonpath";
//	public static String FIELD_OPERATION_ID = "operation_id"
//	public static String FIELD_OPERATION_DESCRIPTION = "operation_description";
//	public static String FIELD_OPERATION_SUMMARY = "operation_summary";
//	public static String FIELD_SERVICE_DESCRIPTION = "service_description";
	static int CUTOFF = 10000;
	static final Logger logger = LoggerFactory.getLogger(SemanticAnnotator);

	Analyzer analyzer = null;
	Directory index = null;
	QueryParser queryparser = null;

	Collection<IndexField> index_fields = new HashSet<IndexField>();
	Collection<QueryPart> query_parts = new HashSet<QueryPart>();

	new(){
		index = new MMapDirectory(Paths.get(UUID.randomUUID.toString));
	}
	
	

	
	new(List<Object> index_fields, List<Object> query_parts, Analyzer analyzer) {

		val path = "build/tmp/"+UUID.randomUUID.toString;

		this.analyzer = analyzer;
		index = new MMapDirectory(Paths.get(path));
		for (Object object : index_fields) {
			if (object instanceof IndexField) {
				this.index_fields.add(object);
			}
		}

		for (Object object : query_parts) {
			if (object instanceof QueryPart) {
				this.query_parts.add(object);
			}
		}
		
		System.out.println('''index fields: «this.index_fields.map[p|p.name]»''');
		System.out.println('''query parts: «this.query_parts.map[p|p.name]»''');
		
		queryparser = new MultiFieldQueryParser(this.index_fields.map[p|p.name], this.analyzer);
		
		//queryparser = new QueryParser(IndexField.LABEL.name, this.analyzer);
		
		

	}
	
	
	def getIndexFields(){
		return this.index_fields
	}
	
	def getQueryParts(){
		return this.query_parts
	}

	override AnnotationResult searchSemanticType(IO io) {
		return query(io.name);
	}

	def AnnotationResult query(IO io) {

		var parts = new ArrayList<String>();

		if (query_parts.contains(QueryPart.IO_NAME)) {
			parts.add(io.name);
		}
		if (query_parts.contains(QueryPart.IO_DESCRIPTION)) {
			parts.add(io.description);
		}
		if (query_parts.contains(QueryPart.IO_JSONPATH)) {
			parts.add(io.jsonPath);
		}
		if (query_parts.contains(QueryPart.OPERATION_ID)) {
			parts.add(io.operation.operationId);
		}
		if (query_parts.contains(QueryPart.OPERATION_DESCRIPTION)) {
			parts.add(io.operation.description);
		}
		if (query_parts.contains(QueryPart.SERVICE_DESCRIPTION)) {
			parts.add(io.operation.specification.description);
		}

		parts = new ArrayList<String>(parts.filter(p|p !== null && !p.empty).toList);

		var iterator = parts.iterator;

		var stringBuilder = new StringBuilder();
		while (iterator.hasNext) {
			var next = iterator.next;

			// + - && || ! ( ) { } [ ] ^ " ~ * ? : \
			// next = next.replaceAll("[+-!()[]*?:]*"," ");
			//next = next.replace("[*]", " ");
			//next = next.replace(":", " ");
			
			
			stringBuilder.append(next);

			if (iterator.hasNext) {
				stringBuilder.append(" ");
			}
		}
		var querystr = stringBuilder.toString;
		querystr = AnalyzerHelper.normalize(this.analyzer, "", querystr, " ");

		return query(querystr);

	}
	
	protected def getAll(){
			if (!DirectoryReader.indexExists(index)) {
			throw new IllegalStateException("create index before you query");
		}

		var reader = DirectoryReader.open(index);
		
		ALL_DOCUMENTS = new HashSet<Integer>();

		var searcher = new IndexSearcher(reader);
		try {
			val query = new MatchAllDocsQuery();
			var docs = searcher.search(query, CUTOFF);
			var hits = docs.scoreDocs;
			for (var i = 0; i < hits.length; i++) {
				var docId = hits.get(i).doc;
				ALL_DOCUMENTS.add(docId);
			}
			reader.close;

		} catch (Exception e) {

			e.printStackTrace();
		}	
	}

	def AnnotationResult query(String querystring) {

		// TODO querystring is an xput
		var realResult = BaasFactory.eINSTANCE.createAnnotationResult;
		
		if(index_fields.empty || query_parts.empty){
			System.out.println("There is nothing to query.");
			return realResult;
		}

		// var result = new ArrayList<String>();
		if (!DirectoryReader.indexExists(index)) {
			throw new IllegalStateException("create index before you query");
		}

		var reader = DirectoryReader.open(index);

		var searcher = new IndexSearcher(reader);
		try {

			var query = queryparser.parse(querystring);
			logger.debug('''query: «query»''');
			var docs = searcher.search(query, CUTOFF);
			var hits = docs.scoreDocs;

			var score = 0d;
			for (var i = 0; i < hits.length; i++) {
				var docId = hits.get(i).doc;

				score = hits.get(i).score;
				var d = searcher.doc(docId);
				var uri = d.get("uri");
				var label = d.get("raw_label");
				var comment = d.get("raw_comment");

				var semanticType = BaasFactory.eINSTANCE.createSemanticType;

				var mapping = BaasFactory.eINSTANCE.createSemanticTypeMapping();

				semanticType.uri = uri;
				semanticType.comment = comment;
				semanticType.label = label;

				mapping.semantictype = semanticType;
				mapping.score = score;
				// mapping.io = TODO
				realResult.mappings.add(mapping);
			}
			
			var left = new HashSet<Integer>();
			left.addAll(ALL_DOCUMENTS);
			left.removeAll(hits.map[h|h.doc]);
			
			for(int docId : left){
				var d = searcher.doc(docId);
				var uri = d.get("uri");
				var label = d.get("raw_comment");
				var comment = d.get("raw_comment");

				var semanticType = BaasFactory.eINSTANCE.createSemanticType;

				var mapping = BaasFactory.eINSTANCE.createSemanticTypeMapping();

				semanticType.uri = uri;
				semanticType.comment = comment;
				semanticType.label = label;

				mapping.semantictype = semanticType;
				mapping.score = 0;
				realResult.mappings.add(mapping);	
				
			}
			
			
			

			reader.close;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return realResult;

	}
	
	

	def void doIndex(Model ontology) {

		if(index_fields.empty){
			System.out.println("Nothing to index");
			return;
		}

		var config = new IndexWriterConfig(analyzer);
		var writer = new IndexWriter(index, config);

		var resources = new ArrayList<OntResource>();
		resources.addAll(OWLUtil.listClasses(ontology));
//		resources.addAll(OWLUtil.listDatatypeProperties(ontology));
//		resources.addAll(OWLUtil.listObjectProperties(ontology));

		for (OntResource p : resources) {

			var doc = new Document();
			var label = NameProvider.getLabel(p);
			var comment = OWLUtil.getLiteral(p, RDFS.comment);

			if (index_fields.contains(IndexField.LABEL)) {

				doc.add(new TextField(IndexField.LABEL.name, label, Field.Store.YES));

			}
			if (index_fields.contains(IndexField.COMMENT)) {

				doc.add(new TextField(IndexField.COMMENT.name, comment, Field.Store.YES));
			}

			doc.add(new StringField("uri", p.URI, Field.Store.YES));
			doc.add(new StringField("raw_label", label, Field.Store.YES));
			doc.add(new StringField("raw_comment", comment, Field.Store.YES));
			writer.addDocument(doc);
		}

		writer.close;
		
		this.all;


	}
}
