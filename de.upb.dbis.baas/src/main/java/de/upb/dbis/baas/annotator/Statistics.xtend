package de.upb.dbis.baas.annotator

import java.io.BufferedWriter
import java.io.FileWriter
import java.util.PriorityQueue

class Statistics {
	
	/*
	 * 
	 * 
How often JSON-LD?

How many datatype properties per JSON response?
most datatypes?
average object nesting?
most frequent keys?
Malformed JSON
	 */
	 
	 public String host;
	 public String endpoint;
	 public int parameters = 0;
	 public int parameter_number = 0;
	 public int parameter_string = 0;
	 public int parameter_boolean = 0;
	 public int parameter_binary = 0;
	 public int get = 0;
	 public int post = 0;
	 public int delete = 0;
	 public int put = 0;
	 public int responses = 0;
	 public int options = 0;
	 public int head = 0;
	 public int patch = 0;
	 public int body = 0;
	 public int header = 0;
	 public int query = 0;
	 public int path = 0;
	 public int formData = 0;
	 //public int response_200 = 0;
	 public PriorityQueue<String> response_codes = new PriorityQueue<String>;
	 public int response_examples = 0;
	 public int response_examples_json = 0;
	 public int responses_examples_json_valid = 0;
	 
	 static def header(){
	 	'''Host;Endpoint;Parameters;Parameters Number;Parameters String;Parameters Boolean;Parameters Binary;Query;Path;Header;Body;FormData;GET;POST;DELETE;PUT;HEAD;OPTIONS;PATCH;Responses Number;Response Codes;Response Examples;Response Json Examples;Response Valid Json''';
	 }
	 
	 def write(){
	 	
	 	var output = new BufferedWriter(new FileWriter("data/_stats2.csv",true));  //clears file every time
	 	
	 	var line = '''"«host»";"«endpoint»";«parameters»;«parameter_number»;«parameter_string»;«parameter_boolean»;«parameter_binary»;«query»;«path»;«header»;«body»;«formData»;«get»;«post»;«delete»;«put»;«head»;«options»;«patch»;«responses»;«response_codes»;«response_examples»;«response_examples_json»;«responses_examples_json_valid»'''
	 	line+="\n";
	 	
		output.append(line);
		output.close();
	 }
	 
	 static def truncate(){
	 	
	 	var output = new BufferedWriter(new FileWriter("data/_stats2.csv",false));  //clears file every time
	 	

	 	
		output.append(header()+"\n");
		output.close();
	 }
	 
	 
}
