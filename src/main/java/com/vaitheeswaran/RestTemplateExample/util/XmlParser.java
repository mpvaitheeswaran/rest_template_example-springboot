package com.vaitheeswaran.RestTemplateExample.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlParser {
	
	public Document createDocument(String xmlString) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(
            		xmlString)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
	
	List<Map<String,String>> toMapList(Document xmlDoc,String expression){
		List<Map<String, String>> listOfMaps = new ArrayList<Map<String,String>>();
		
		
		return listOfMaps;
	}
	
	public List<String> evaluateXPath(Document document, String xpathExpression) throws Exception 
	  {
	    // Create XPathFactory object
	    XPathFactory xpathFactory = XPathFactory.newInstance();
	     
	    // Create XPath object
	    XPath xpath = xpathFactory.newXPath();
	 
	    List<String> values = new ArrayList<String>();
	    try
	    {
	      // Create XPathExpression object
	      XPathExpression expr = xpath.compile(xpathExpression);
	       
	      // Evaluate expression result on XML document
	      NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
	      
	      
	      for (int i = 0; i < nodes.getLength(); i++) {
	    	  Node n = nodes.item(i);
	    	  if(n.getNodeType()==Node.ELEMENT_NODE) {
	    		  NodeList childs = n.getChildNodes();
	    		  Node child;
	    		  for(int childIdx=0; childIdx<childs.getLength();childIdx++) {
	    			  child = childs.item(childIdx);
	    			  System.out.println(child.getNodeName()+" : "+child.getTextContent());
	    			  values.add(child.getTextContent());
	    		  }
	    		  
	    	  }else {
	    		  values.add(nodes.item(i).getTextContent());
	    	  }
	    	  
	    	  
	        
	      }
	         
	    } catch (XPathExpressionException e) {
	      e.printStackTrace();
	    }
	    return values;
	  }
	public Map<String,String> evaluateXPathToMap(Document document, String xpathExpression) throws Exception 
	  {
	    // Create XPathFactory object
	    XPathFactory xpathFactory = XPathFactory.newInstance();
	     
	    // Create XPath object
	    XPath xpath = xpathFactory.newXPath();
	 
	    Map<String,String> values = new HashMap<String,String>();
	    try
	    {
	      // Create XPathExpression object
	      XPathExpression expr = xpath.compile(xpathExpression);
	       
	      // Evaluate expression result on XML document
	      NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
	      
	      
	      for (int i = 0; i < nodes.getLength(); i++) {
	    	  Node n = nodes.item(i);
	    	  if(n.getNodeType()==Node.ELEMENT_NODE) {
	    		  NamedNodeMap attrs = n.getAttributes();
	    		  //Loop all atributes from element.
	    		  for(int atrIdx=0;atrIdx<attrs.getLength();atrIdx++) {
	    			  values.put(attrs.item(atrIdx).getNodeName(),attrs.item(atrIdx).getTextContent());
	    		  }
	    		  NodeList childs = n.getChildNodes();
	    		  Node child;
	    		  for(int childIdx=0; childIdx<childs.getLength();childIdx++) {
	    			  child = childs.item(childIdx);
	    			  values.put(child.getNodeName(),child.getTextContent());
	    		  }
	    		  
	    	  }
	    	  
	        
	      }
	         
	    } catch (XPathExpressionException e) {
	      e.printStackTrace();
	    }
	    return values;
	  }
}
