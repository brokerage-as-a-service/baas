package de.upb.dbis.baas.evaluation

import java.io.BufferedReader
import java.io.FileReader
import java.io.File
import java.util.ArrayList
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale
import java.util.Comparator

class Csv2Tex {

	static def void main(String[] args) {

		Csv2Tex.print(new File("results/featureSelection.csv"), true, 10)
		Csv2Tex.print(new File("results/pipelineSelection.csv"), false, -1)
	}

	static def void print(File file, boolean sort, int cutoff) {

		var line = "";
		val br = new BufferedReader(new FileReader(file));
		val rows = new ArrayList<ArrayList<Float>>()
		val header = new ArrayList<String>()
		var rowCount = 0
		while ((line = br.readLine()) !== null) {

			val parts = line.split(";");
			val x = new ArrayList<Float>();

			for (var i = 0; i < parts.length; i++) {

				if (parts.get(i).startsWith("\"") && parts.get(i).endsWith("\"")) {
					parts.set(i, parts.get(i).substring(1, parts.get(i).length - 1));
				}

				if (rowCount === 0) {
					header.add(parts.get(i))
				} else {
					val value = Float.parseFloat(parts.get(i));

					x.add(value);
				}

			}
			if (rowCount > 0) {

				rows.add(x);
			}

			rowCount++

		}

		if(sort){
			
			rows.sort(new Comparator<ArrayList<Float>>() {
	
				override compare(ArrayList<Float> o1, ArrayList<Float> o2) {
					return o2.last.compareTo(o1.last)
				}
	
			})
		}

		val cut = rows.subList(0, cutoff===-1?rows.length:cutoff)

		val nf = NumberFormat.getNumberInstance(Locale.US);
		val df = nf as DecimalFormat;
		df.applyPattern(".###");

		var i = 0;
		var result = '''
			\begin{table}
				\centering
				\renewcommand{\arraystretch}{1.5}
				\begin{tabular}{p{5cm}p{1cm}p{1cm}p{1cm}p{1cm}p{1cm}p{1cm}p{1cm}p{1cm}}
					\hline
					 «FOR head : header SEPARATOR "&"»
					 	\rotatebox{60}{\parbox{4cm}{«head»}}
					 «ENDFOR»
					\hline 
					
					«FOR ArrayList<Float> r : cut»
						«{i=0;''}»
					«FOR Float f : r SEPARATOR ' & ' AFTER '\\\\'»«IF f===1f»\cmark{}«ENDIF»«IF i===r.size-1»«df.format(f)»«ENDIF»«{i++;''}»«ENDFOR»
					
				«ENDFOR»
				\hline 
				\end{tabular}
				\caption{Index fields and indexed tokens of the semantic type \texttt{schema:Flight}}
				\label{tab:IndexFieldTokens}
			\end{table}		
		'''

		System.out.println(result);

	}
}
