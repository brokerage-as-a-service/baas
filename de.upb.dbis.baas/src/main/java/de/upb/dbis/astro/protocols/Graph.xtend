package de.upb.dbis.astro.protocols

import java.io.FileInputStream
import org.yaml.snakeyaml.Yaml
import java.io.File
import java.util.LinkedHashMap
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Collection
import java.util.Collections
import java.io.BufferedWriter
import java.io.FileWriter
import java.util.HashSet

class Graph {
	
	
	static def main(String[] args){
		val inputStream = new FileInputStream(new File("results/simphera.gen2.yaml"));

		val yaml = new Yaml();
		val data = yaml.load(inputStream) as ArrayList<LinkedHashMap>
		
		val inputsBy = new HashMap<String, List<String>>()
		val outputsBy = new HashMap<String, List<String>>()
		for (LinkedHashMap operation : data) {
				
			var path = operation.get("path") as String
			
			
			var inputs = (operation.get("inputs") as LinkedHashMap<String, String>)?.values ?: Collections.EMPTY_LIST
			var outputs = (operation.get("outputs")as LinkedHashMap<String, String>)?.values?: Collections.EMPTY_LIST
			
			outputs.removeAll(inputs)
			
			for(String input:inputs){
				if(!input.empty){
					
				var list = inputsBy.get(input)
				if(list===null){
					list = new ArrayList<String>()
				}
				list.add(path)
				inputsBy.put(input, list)
				}
			}
			for(String output:outputs){
				if(!output.empty) {
					
				var list = outputsBy.get(output)
				if(list===null){
					list = new ArrayList<String>()
				}
				list.add(path)				
				outputsBy.put(output, list)
				}
			}			
			
		}
		
	

		
		val nodes = new StringBuilder()
		val edges = new StringBuilder()
		
		val paths = new HashSet<String>()
		
		for(String output:outputsBy.keySet()){

			
			for(String sourcepath : outputsBy.get(output)){
				paths.add(sourcepath)		
			}
			
		}	
		
		for(String input:inputsBy.keySet()){

			
			for(String targetpath : inputsBy.get(input)){
				paths.add(targetpath)		
			}
			
		}
		
		for(String path:paths){
			nodes.append(
				'''
				<node id="n«path.hashCode»">
				  <data key="d5"/>
				  <data key="d6">
				    <y:GenericNode configuration="com.yworks.bpmn.Activity.withShadow">
				      <y:Geometry height="55.0" width="85.0" x="737.5" y="346.5"/>
				      <y:Fill color="#FFFFFFE6" color2="#D4D4D4CC" transparent="false"/>
				      <y:BorderStyle color="#123EA2" type="line" width="1.0"/>
				      <y:NodeLabel alignment="center" autoSizePolicy="content" fontFamily="Dialog" fontSize="12" fontStyle="plain" hasBackgroundColor="false" hasLineColor="false" height="18.701171875" horizontalTextPosition="center" iconTextGap="4" modelName="custom" textColor="#000000" verticalTextPosition="bottom" visible="true" width="64.046875" x="10.4765625" xml:space="preserve" y="18.1494140625">«path»<y:LabelModel><y:SmartNodeLabelModel distance="4.0"/></y:LabelModel><y:ModelParameter><y:SmartNodeLabelModelParameter labelRatioX="0.0" labelRatioY="0.0" nodeRatioX="0.0" nodeRatioY="0.0" offsetX="0.0" offsetY="0.0" upX="0.0" upY="-1.0"/></y:ModelParameter></y:NodeLabel>
				      <y:StyleProperties>
				        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.line.color" value="#000000"/>
				        <y:Property class="com.yworks.yfiles.bpmn.view.TaskTypeEnum" name="com.yworks.bpmn.taskType" value="TASK_TYPE_ABSTRACT"/>
				        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.fill2" value="#d4d4d4cc"/>
				        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.fill" value="#ffffffe6"/>
				        <y:Property class="com.yworks.yfiles.bpmn.view.BPMNTypeEnum" name="com.yworks.bpmn.type" value="ACTIVITY_TYPE"/>
				        <y:Property class="com.yworks.yfiles.bpmn.view.ActivityTypeEnum" name="com.yworks.bpmn.activityType" value="ACTIVITY_TYPE_TASK"/>
				      </y:StyleProperties>
				    </y:GenericNode>
				  </data>
				</node>
				''')				
		}			
		
		for(String output:outputsBy.keySet()){

			
			for(String sourcepath : outputsBy.get(output)){
			
				
				for(String targetpath : inputsBy.get(output)){
					
					edges.append('''
					    <edge id="n«sourcepath.hashCode»n«targetpath.hashCode»" source="n«sourcepath.hashCode»" target="n«targetpath.hashCode»">
					      <data key="d9"/>
					      <data key="d10">
					        <y:GenericEdge configuration="com.yworks.bpmn.Connection">
					          <y:Path sx="0.0" sy="0.0" tx="0.0" ty="0.0"/>
					          <y:LineStyle color="#000000" type="line" width="1.0"/>
					          <y:Arrows source="none" target="delta"/>
					          <y:EdgeLabel alignment="center" configuration="AutoFlippingLabel" distance="2.0" fontFamily="Dialog" fontSize="12" fontStyle="plain" hasBackgroundColor="false" hasLineColor="false" height="18.701171875" horizontalTextPosition="center" iconTextGap="4" modelName="custom" preferredPlacement="anywhere" ratio="0.5" textColor="#000000" verticalTextPosition="bottom" visible="true" width="38.6875" x="126.6793212890625" xml:space="preserve" y="14.479153991764747"><y:LabelModel><y:SmartEdgeLabelModel autoRotationEnabled="false" defaultAngle="0.0" defaultDistance="10.0"/></y:LabelModel><y:ModelParameter><y:SmartEdgeLabelModelParameter angle="0.0" distance="30.0" distanceToCenter="true" position="right" ratio="0.5" segment="0"/></y:ModelParameter><y:PreferredPlacementDescriptor angle="0.0" angleOffsetOnRightSide="0" angleReference="absolute" angleRotationOnRightSide="co" distance="-1.0" frozen="true" placement="anywhere" side="anywhere" sideReference="relative_to_edge_flow"/></y:EdgeLabel>
					          <y:StyleProperties>
					            <y:Property class="com.yworks.yfiles.bpmn.view.BPMNTypeEnum" name="com.yworks.bpmn.type" value="CONNECTION_TYPE_SEQUENCE_FLOW"/>
					          </y:StyleProperties>
					        </y:GenericEdge>
					      </data>
					    </edge>
					''')
					
					System.out.println('''«sourcepath» -(«output»)-> «targetpath»''')
				}	
			}
			
		}
		var sb = new StringBuffer()
		sb.append('''
			<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<graphml xmlns="http://graphml.graphdrawing.org/xmlns" xmlns:java="http://www.yworks.com/xml/yfiles-common/1.0/java" xmlns:sys="http://www.yworks.com/xml/yfiles-common/markup/primitives/2.0" xmlns:x="http://www.yworks.com/xml/yfiles-common/markup/2.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:y="http://www.yworks.com/xml/graphml" xmlns:yed="http://www.yworks.com/xml/yed/3" xsi:schemaLocation="http://graphml.graphdrawing.org/xmlns http://www.yworks.com/xml/schema/graphml/1.1/ygraphml.xsd">
			  <!--Created by yEd 3.21.1-->
			  <key attr.name="Description" attr.type="string" for="graph" id="d0"/>
			  <key for="port" id="d1" yfiles.type="portgraphics"/>
			  <key for="port" id="d2" yfiles.type="portgeometry"/>
			  <key for="port" id="d3" yfiles.type="portuserdata"/>
			  <key attr.name="url" attr.type="string" for="node" id="d4"/>
			  <key attr.name="description" attr.type="string" for="node" id="d5"/>
			  <key for="node" id="d6" yfiles.type="nodegraphics"/>
			  <key for="graphml" id="d7" yfiles.type="resources"/>
			  <key attr.name="url" attr.type="string" for="edge" id="d8"/>
			  <key attr.name="description" attr.type="string" for="edge" id="d9"/>
			  <key for="edge" id="d10" yfiles.type="edgegraphics"/>
			  <graph edgedefault="directed" id="G">
			    <data key="d0"/>
			    «nodes.toString»
			    «edges.toString»
			  </graph>
			  <data key="d7">
			    <y:Resources/>
			  </data>
			</graphml>
		''')	
		val writer = new BufferedWriter(new FileWriter("./results/simphera.bpmn.graphml", false));
		writer.write(sb.toString);

		writer.close();		
		
	}
}