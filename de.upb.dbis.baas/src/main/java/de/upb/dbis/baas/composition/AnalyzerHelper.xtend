package de.upb.dbis.baas.composition

import java.util.HashSet
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute
import org.apache.lucene.analysis.Analyzer
import org.apache.lucene.analysis.custom.CustomAnalyzer
import org.apache.lucene.analysis.standard.StandardTokenizerFactory
import org.apache.lucene.analysis.core.LowerCaseFilterFactory
import org.apache.lucene.analysis.en.EnglishMinimalStemFilterFactory
import org.apache.lucene.analysis.core.StopFilterFactory
import org.apache.lucene.analysis.miscellaneous.WordDelimiterGraphFilterFactory

class AnalyzerHelper {
	
		public static Analyzer ANALYZER_TEXT = CustomAnalyzer.builder()
			.withTokenizer(StandardTokenizerFactory)
			.addTokenFilter(LowerCaseFilterFactory)
			.addTokenFilter(EnglishMinimalStemFilterFactory)
			.addTokenFilter(StopFilterFactory, "ignoreCase", "true", "words", "stopwords.txt", "format", "wordset")
			.build();
			
		public static Analyzer ANALYZER_ID = CustomAnalyzer.builder()
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
//   		.addTokenFilter(EnglishPossessiveFilterFactory)
//   		.addTokenFilter(PorterStemFilterFactory)
//			.addTokenFilter(KStemFilterFactory)
			//.addTokenFilter(PatternCaptureGroupFilterFactory, "preserve_original", "true", "pattern", "(([a-z]+)(id$)|(brand)|(info))")
   			//.addTokenFilter(SynonymGraphFilterFactory, "synonyms", "synonyms.txt", "format", "solr", "ignoreCase", "false", "expand", "true")
			.addTokenFilter(StopFilterFactory, "ignoreCase", "true", "words", "stopwords.txt", "format", "wordset")
			.build();
	
	
	static def HashSet<String> normalize(Analyzer a, String s){
		return normalize(a, "", s);
	}
	
	static def HashSet<String> normalize(Analyzer a, String field, String s){
		
		if(s===null || s.empty){
			return new HashSet<String>(); //TODO memory optimization
		}
		
		
		var result = new HashSet<String>();
		var tokenStream = a.tokenStream(field, s);
		var charTermAttribute = tokenStream.addAttribute(CharTermAttribute);
		
		tokenStream.reset();
		while (tokenStream.incrementToken()) {
		    var term = charTermAttribute.toString();
		    result.add(term);
		}
		tokenStream.end();
		tokenStream.close();
		
		return result;
	}
	
	static def String normalize(Analyzer a, String field, String s, String delimiter){
		
		var sb = new StringBuilder();
		
		var tokens = normalize(a, field, s).iterator;
		
		while(tokens.hasNext){
			
			var next = tokens.next;
			sb.append(next);
			if(tokens.hasNext){
				sb.append(delimiter);
				
			}
		}
		
		return sb.toString;
		


	}	
}