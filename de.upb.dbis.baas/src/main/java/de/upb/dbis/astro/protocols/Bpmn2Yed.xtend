package de.upb.dbis.astro.protocols

import java.util.ArrayList
import java.util.HashMap
import java.util.Stack
import java.util.UUID
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import javax.xml.stream.XMLInputFactory
import javax.xml.namespace.QName

class Bpmn2Yed {

	public static String ID = "id";
	public static String NAME = "name";
	public static String SOURCE = "source";
	public static String TARGET = "target";

	public Stack<String> stack = new Stack<String>();
	public String lastId = "";

	public ArrayList<HashMap<String, String>> start_events = new ArrayList<HashMap<String, String>>();
	public ArrayList<HashMap<String, String>> end_events = new ArrayList<HashMap<String, String>>();
	public ArrayList<HashMap<String, String>> xor_gateways = new ArrayList<HashMap<String, String>>();
	public ArrayList<HashMap<String, String>> or_gateways = new ArrayList<HashMap<String, String>>();
	public ArrayList<HashMap<String, String>> and_gateways = new ArrayList<HashMap<String, String>>();
	public ArrayList<HashMap<String, String>> tasks = new ArrayList<HashMap<String, String>>();
	public ArrayList<HashMap<String, String>> edges = new ArrayList<HashMap<String, String>>();

	public def parse(InputStream inputStream) {
		var xmlInputFactory = XMLInputFactory.newInstance();

		var xmlEventReader = xmlInputFactory.createXMLEventReader(inputStream);
		while (xmlEventReader.hasNext()) {
			var xmlEvent = xmlEventReader.nextEvent();

			if (xmlEvent.isCharacters) {
				var character = xmlEvent.asCharacters;
				var data = character.data;

				val item = new HashMap<String, String>();
				item.put(ID, UUID.randomUUID.toString);
				if (stack.peek.equals("incoming")) {
					item.put(SOURCE, data);
					item.put(TARGET, lastId);
				} else if (stack.peek.equals("outgoing")) {
					item.put(SOURCE, lastId);
					item.put(TARGET, data);
				}
			}
			if (xmlEvent.isStartElement()) {
				var startElement = xmlEvent.asStartElement();
				stack.push(startElement.name.localPart);

				if (startElement.getName().getLocalPart().equals("startEvent")) {
					val item = new HashMap<String, String>();
					val id = startElement.getAttributeByName(new QName("id")).value;
					item.put(ID, id);
					start_events.add(item);
				}
				if (startElement.getName().getLocalPart().equals("endEvent")) {
					val item = new HashMap<String, String>();
					val id = startElement.getAttributeByName(new QName("id")).value;
					item.put(ID, id);
					end_events.add(item);
				}
				if (startElement.getName().getLocalPart().equals("task")) {
					val item = new HashMap<String, String>();
					val id = startElement.getAttributeByName(new QName("id")).value;
					val name = startElement.getAttributeByName(new QName("name")).value;
					item.put(ID, id);
					item.put(NAME, name);
					tasks.add(item);
				}
				if (startElement.getName().getLocalPart().equals("exclusiveGateway")) {
					val item = new HashMap<String, String>();
					val id = startElement.getAttributeByName(new QName("id")).value;
					item.put(ID, id);
					lastId = id;
					xor_gateways.add(item);
				}
				if (startElement.getName().getLocalPart().equals("parallelGateway")) {
					val item = new HashMap<String, String>();
					val id = startElement.getAttributeByName(new QName("id")).value;
					item.put(ID, id);
					lastId = id;
					and_gateways.add(item);
				}
				if (startElement.getName().getLocalPart().equals("sequenceFlow")) {
					val item = new HashMap<String, String>();
					val id = startElement.getAttributeByName(new QName("id")).value;
					val source = startElement.getAttributeByName(new QName("sourceRef")).value;
					val target = startElement.getAttributeByName(new QName("targetRef")).value;
					item.put(ID, id);
					item.put(SOURCE, source);
					item.put(TARGET, target);
					edges.add(item);
				}
			}
			if (xmlEvent.isEndElement()) {
				stack.pop();
			}

		}

	}

	public static def main(String[] args) {
		var fis = new FileInputStream(new File("results/heuristics.bpmn"));
		var converter = new Bpmn2Yed();
		converter.parse(fis);

		System.out.println(converter.convert);
	}
	
	
	public def String convert2(){
		
		val nodes = new ArrayList<HashMap<String, String>>();
		nodes.addAll(start_events);
		nodes.addAll(end_events);
		nodes.addAll(tasks);
		nodes.addAll(xor_gateways);
		nodes.addAll(or_gateways);
		nodes.addAll(and_gateways);
		
		val numeric_ids = new HashMap<String, Integer>();
		
		
		for(var i=0; i<nodes.length;i++){
			val node = nodes.get(i);
			numeric_ids.put(node.get(ID), i);
			
		}
		
		return 
		'''
		graph [
			directed 1
			«FOR n:nodes»
			node [
				id «numeric_ids.get(n.get(ID))»
				«IF n.containsKey(NAME)»
				label "«n.get(NAME)»"
				«ELSE»
				label "«n.get(ID)»"
				«ENDIF»
			]
			«ENDFOR»
			«FOR e:edges»
			edge [
				source «numeric_ids.get(e.get(SOURCE))»
				target «numeric_ids.get(e.get(TARGET))»
			]
			«ENDFOR»
		]
		'''
	}

	public def String convert() {

		return '''
			<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<graphml xmlns="http://graphml.graphdrawing.org/xmlns" xmlns:java="http://www.yworks.com/xml/yfiles-common/1.0/java" xmlns:sys="http://www.yworks.com/xml/yfiles-common/markup/primitives/2.0" xmlns:x="http://www.yworks.com/xml/yfiles-common/markup/2.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:y="http://www.yworks.com/xml/graphml" xmlns:yed="http://www.yworks.com/xml/yed/3" xsi:schemaLocation="http://graphml.graphdrawing.org/xmlns http://www.yworks.com/xml/schema/graphml/1.1/ygraphml.xsd">
			  <!--Created by yEd 3.19-->
			  <key attr.name="Beschreibung" attr.type="string" for="graph" id="d0"/>
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
			    «FOR s : start_events»
			    	<node id="«s.get(ID)»">
			    	  <data key="d5"/>
			    	  <data key="d6">
			    	    <y:GenericNode configuration="com.yworks.bpmn.Event.withShadow">
			    	      <y:Geometry height="30.0" width="30.0" x="279.0" y="217.0"/>
			    	      <y:Fill color="#FFFFFFE6" color2="#D4D4D4CC" transparent="false"/>
			    	      <y:BorderStyle color="#27AE27" type="line" width="1.0"/>
			    	      <y:NodeLabel alignment="center" autoSizePolicy="content" fontFamily="Dialog" fontSize="12" fontStyle="plain" hasBackgroundColor="false" hasLineColor="false" hasText="false" height="4.0" horizontalTextPosition="center" iconTextGap="4" modelName="custom" textColor="#000000" verticalTextPosition="bottom" visible="true" width="4.0" x="13.0" y="34.0">
			    	        <y:LabelModel>
			    	          <y:SmartNodeLabelModel distance="4.0"/>
			    	        </y:LabelModel>
			    	        <y:ModelParameter>
			    	          <y:SmartNodeLabelModelParameter labelRatioX="0.0" labelRatioY="-0.5" nodeRatioX="0.0" nodeRatioY="0.5" offsetX="0.0" offsetY="4.0" upX="0.0" upY="-1.0"/>
			    	        </y:ModelParameter>
			    	      </y:NodeLabel>
			    	      <y:StyleProperties>
			    	        <y:Property class="com.yworks.yfiles.bpmn.view.EventCharEnum" name="com.yworks.bpmn.characteristic" value="EVENT_CHARACTERISTIC_START"/>
			    	        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.line.color" value="#000000"/>
			    	        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.fill2" value="#d4d4d4cc"/>
			    	        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.fill" value="#ffffffe6"/>
			    	        <y:Property class="com.yworks.yfiles.bpmn.view.BPMNTypeEnum" name="com.yworks.bpmn.type" value="EVENT_TYPE_PLAIN"/>
			    	      </y:StyleProperties>
			    	    </y:GenericNode>
			    	  </data>
			    	</node>
			    «ENDFOR»
			    «FOR s : tasks»
			    	<node id="«s.get(ID)»">
			    	  <data key="d5"/>
			    	  <data key="d6">
			    	    <y:GenericNode configuration="com.yworks.bpmn.Activity.withShadow">
			    	      <y:Geometry height="55.0" width="85.0" x="385.5" y="204.5"/>
			    	      <y:Fill color="#FFFFFFE6" color2="#D4D4D4CC" transparent="false"/>
			    	      <y:BorderStyle color="#123EA2" type="line" width="1.0"/>
			    	      <y:NodeLabel alignment="center" autoSizePolicy="content" fontFamily="Dialog" fontSize="12" fontStyle="plain" hasBackgroundColor="false" hasLineColor="false" height="18.701171875" horizontalTextPosition="center" iconTextGap="4" modelName="custom" textColor="#000000" verticalTextPosition="bottom" visible="true" width="58.0" x="13.5" xml:space="preserve" y="18.1494140625"><![CDATA[«s.get(NAME)»]]><y:LabelModel><y:SmartNodeLabelModel distance="4.0"/></y:LabelModel><y:ModelParameter><y:SmartNodeLabelModelParameter labelRatioX="0.0" labelRatioY="0.0" nodeRatioX="0.0" nodeRatioY="0.0" offsetX="0.0" offsetY="0.0" upX="0.0" upY="-1.0"/></y:ModelParameter></y:NodeLabel>
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
			    «ENDFOR»
			    «FOR s : xor_gateways»
			    	<node id="«s.get(ID)»">
			    	  <data key="d5"/>
			    	  <data key="d6">
			    	    <y:GenericNode configuration="com.yworks.bpmn.Gateway.withShadow">
			    	      <y:Geometry height="45.0" width="45.0" x="571.0" y="127.5"/>
			    	      <y:Fill color="#FFFFFFE6" color2="#D4D4D4CC" transparent="false"/>
			    	      <y:BorderStyle color="#E38B00" type="line" width="1.0"/>
			    	      <y:NodeLabel alignment="center" autoSizePolicy="content" fontFamily="Dialog" fontSize="12" fontStyle="plain" hasBackgroundColor="false" hasLineColor="false" hasText="false" height="4.0" horizontalTextPosition="center" iconTextGap="4" modelName="custom" textColor="#000000" verticalTextPosition="bottom" visible="true" width="4.0" x="49.0" y="-8.0">
			    	        <y:LabelModel>
			    	          <y:SmartNodeLabelModel distance="4.0"/>
			    	        </y:LabelModel>
			    	        <y:ModelParameter>
			    	          <y:SmartNodeLabelModelParameter labelRatioX="-0.5" labelRatioY="0.5" nodeRatioX="0.5" nodeRatioY="-0.5" offsetX="4.0" offsetY="-4.0" upX="0.0" upY="-1.0"/>
			    	        </y:ModelParameter>
			    	      </y:NodeLabel>
			    	      <y:StyleProperties>
			    	        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.line.color" value="#000000"/>
			    	        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.fill2" value="#d4d4d4cc"/>
			    	        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.fill" value="#ffffffe6"/>
			    	        <y:Property class="com.yworks.yfiles.bpmn.view.BPMNTypeEnum" name="com.yworks.bpmn.type" value="GATEWAY_TYPE_DATA_BASED_EXCLUSIVE"/>
			    	      </y:StyleProperties>
			    	    </y:GenericNode>
			    	  </data>
			    	</node>
			    «ENDFOR»
			    «FOR s : or_gateways»
			    	<node id="«s.get(ID)»">
			    	  <data key="d5"/>
			    	  <data key="d6">
			    	    <y:GenericNode configuration="com.yworks.bpmn.Gateway.withShadow">
			    	      <y:Geometry height="45.0" width="45.0" x="571.5" y="209.5"/>
			    	      <y:Fill color="#FFFFFFE6" color2="#D4D4D4CC" transparent="false"/>
			    	      <y:BorderStyle color="#E38B00" type="line" width="1.0"/>
			    	      <y:NodeLabel alignment="center" autoSizePolicy="content" fontFamily="Dialog" fontSize="12" fontStyle="plain" hasBackgroundColor="false" hasLineColor="false" hasText="false" height="4.0" horizontalTextPosition="center" iconTextGap="4" modelName="custom" textColor="#000000" verticalTextPosition="bottom" visible="true" width="4.0" x="49.0" y="-8.0">
			    	        <y:LabelModel>
			    	          <y:SmartNodeLabelModel distance="4.0"/>
			    	        </y:LabelModel>
			    	        <y:ModelParameter>
			    	          <y:SmartNodeLabelModelParameter labelRatioX="-0.5" labelRatioY="0.5" nodeRatioX="0.5" nodeRatioY="-0.5" offsetX="4.0" offsetY="-4.0" upX="0.0" upY="-1.0"/>
			    	        </y:ModelParameter>
			    	      </y:NodeLabel>
			    	      <y:StyleProperties>
			    	        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.line.color" value="#000000"/>
			    	        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.fill2" value="#d4d4d4cc"/>
			    	        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.fill" value="#ffffffe6"/>
			    	        <y:Property class="com.yworks.yfiles.bpmn.view.BPMNTypeEnum" name="com.yworks.bpmn.type" value="GATEWAY_TYPE_INCLUSIVE"/>
			    	      </y:StyleProperties>
			    	    </y:GenericNode>
			    	  </data>
			    	</node>
			    «ENDFOR»
			    «FOR s : and_gateways»
			    	<node id="«s.get(ID)»">
			    	  <data key="d5"/>
			    	  <data key="d6">
			    	    <y:GenericNode configuration="com.yworks.bpmn.Gateway.withShadow">
			    	      <y:Geometry height="45.0" width="45.0" x="571.5" y="297.5"/>
			    	      <y:Fill color="#FFFFFFE6" color2="#D4D4D4CC" transparent="false"/>
			    	      <y:BorderStyle color="#E38B00" type="line" width="1.0"/>
			    	      <y:NodeLabel alignment="center" autoSizePolicy="content" fontFamily="Dialog" fontSize="12" fontStyle="plain" hasBackgroundColor="false" hasLineColor="false" hasText="false" height="4.0" horizontalTextPosition="center" iconTextGap="4" modelName="custom" textColor="#000000" verticalTextPosition="bottom" visible="true" width="4.0" x="49.0" y="-8.0">
			    	        <y:LabelModel>
			    	          <y:SmartNodeLabelModel distance="4.0"/>
			    	        </y:LabelModel>
			    	        <y:ModelParameter>
			    	          <y:SmartNodeLabelModelParameter labelRatioX="-0.5" labelRatioY="0.5" nodeRatioX="0.5" nodeRatioY="-0.5" offsetX="4.0" offsetY="-4.0" upX="0.0" upY="-1.0"/>
			    	        </y:ModelParameter>
			    	      </y:NodeLabel>
			    	      <y:StyleProperties>
			    	        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.line.color" value="#000000"/>
			    	        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.fill2" value="#d4d4d4cc"/>
			    	        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.fill" value="#ffffffe6"/>
			    	        <y:Property class="com.yworks.yfiles.bpmn.view.BPMNTypeEnum" name="com.yworks.bpmn.type" value="GATEWAY_TYPE_PARALLEL"/>
			    	      </y:StyleProperties>
			    	    </y:GenericNode>
			    	  </data>
			    	</node>
			    «ENDFOR»
			    «FOR s : end_events»
			    	<node id="«s.get(ID)»">
			    	  <data key="d5"/>
			    	  <data key="d6">
			    	    <y:GenericNode configuration="com.yworks.bpmn.Event.withShadow">
			    	      <y:Geometry height="30.0" width="30.0" x="884.0" y="223.0"/>
			    	      <y:Fill color="#FFFFFFE6" color2="#D4D4D4CC" transparent="false"/>
			    	      <y:BorderStyle color="#B11F1F" type="line" width="1.0"/>
			    	      <y:NodeLabel alignment="center" autoSizePolicy="content" fontFamily="Dialog" fontSize="12" fontStyle="plain" hasBackgroundColor="false" hasLineColor="false" hasText="false" height="4.0" horizontalTextPosition="center" iconTextGap="4" modelName="custom" textColor="#000000" verticalTextPosition="bottom" visible="true" width="4.0" x="13.0" y="34.0">
			    	        <y:LabelModel>
			    	          <y:SmartNodeLabelModel distance="4.0"/>
			    	        </y:LabelModel>
			    	        <y:ModelParameter>
			    	          <y:SmartNodeLabelModelParameter labelRatioX="0.0" labelRatioY="-0.5" nodeRatioX="0.0" nodeRatioY="0.5" offsetX="0.0" offsetY="4.0" upX="0.0" upY="-1.0"/>
			    	        </y:ModelParameter>
			    	      </y:NodeLabel>
			    	      <y:StyleProperties>
			    	        <y:Property class="com.yworks.yfiles.bpmn.view.EventCharEnum" name="com.yworks.bpmn.characteristic" value="EVENT_CHARACTERISTIC_END"/>
			    	        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.line.color" value="#000000"/>
			    	        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.fill2" value="#d4d4d4cc"/>
			    	        <y:Property class="java.awt.Color" name="com.yworks.bpmn.icon.fill" value="#ffffffe6"/>
			    	        <y:Property class="com.yworks.yfiles.bpmn.view.BPMNTypeEnum" name="com.yworks.bpmn.type" value="EVENT_TYPE_PLAIN"/>
			    	      </y:StyleProperties>
			    	    </y:GenericNode>
			    	  </data>
			    	</node>
			    «ENDFOR»
			    «FOR e : edges»
			    	<edge id="«e.get(ID)»" source="«e.get(SOURCE)»" target="«e.get(TARGET)»">
			    	  <data key="d9"/>
			    	  <data key="d10">
			    	    <y:PolyLineEdge>
			    	      <y:Path sx="0.0" sy="0.0" tx="0.0" ty="0.0"/>
			    	      <y:LineStyle color="#000000" type="line" width="1.0"/>
			    	      <y:Arrows source="none" target="standard"/>
			    	      <y:BendStyle smoothed="false"/>
			    	    </y:PolyLineEdge>
			    	  </data>
			    	</edge>
			    «ENDFOR»
			  </graph>
			  <data key="d7">
			    <y:Resources/>
			  </data>
			</graphml>
		'''

	}
}
