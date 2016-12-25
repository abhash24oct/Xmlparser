package com.techm.xmlparser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xmlParser {
							
	public void xmlreader(HashMap<String, String> hm) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		
		DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document doc=builder.parse("test.xml");	
		doc.normalize();
		NodeList sfiList = doc.getElementsByTagName("sfiRequest");
		
		Node sfi =sfiList.item(0);
		if(sfi.getNodeType() == Node.ELEMENT_NODE){
			Element sfiRequest = (Element) sfi;
			
			System.out.println("Reqestid is "+sfiRequest.getElementsByTagName("requestId").item(0).getTextContent());
			sfiRequest.getElementsByTagName("requestId").item(0).setTextContent(hm.get("Requestid"));
			
			System.out.println("username is "+sfiRequest.getElementsByTagName("userName").item(0).getTextContent());
			
			NodeList orderList =sfiRequest.getElementsByTagName("constrOrder");
			Node order =orderList.item(0);

			  
			if(order.getNodeType()==Node.ELEMENT_NODE){
				Element orderElement=(Element) order;
				
				if(orderElement.getElementsByTagName("serviceId").item(0).getNodeType()==Node.ELEMENT_NODE){
				Element service =(Element) orderElement.getElementsByTagName("serviceId").item(0);
				
				System.out.println("Dim object type " +service.getElementsByTagName("dimObjectType").item(0).getTextContent());
				service.getElementsByTagName("dimObjectType").item(0).setTextContent(hm.get("dimObjectType"));
				
				System.out.println("Dim object id " +service.getElementsByTagName("dimObjectId").item(0).getTextContent());
				service.getElementsByTagName("dimObjectId").item(0).setTextContent(hm.get("dimObjectId"));
				}
				
				if(orderElement.getElementsByTagName("createTelephoneNumberBlock").item(0).getNodeType()==Node.ELEMENT_NODE){
					Element createTelephoneNoBlock = (Element)orderElement;
					
					System.out.println("order Name "+createTelephoneNoBlock.getElementsByTagName("orderName").item(0).getTextContent());
					orderElement.getElementsByTagName("orderName").item(0).setTextContent(hm.get("orderName"));
					
					System.out.println("planned comp date "+createTelephoneNoBlock.getElementsByTagName("plannedCompDate").item(0).getTextContent());
					orderElement.getElementsByTagName("plannedCompDate").item(0).setTextContent(hm.get("plannedCompDate"));
					
					System.out.println("number Low  "+createTelephoneNoBlock.getElementsByTagName("numberLow").item(0).getTextContent());
					orderElement.getElementsByTagName("numberLow").item(0).setTextContent(hm.get("numberLow"));
					
					System.out.println("numberHigh "+createTelephoneNoBlock.getElementsByTagName("numberHigh").item(0).getTextContent());
					orderElement.getElementsByTagName("numberHigh").item(0).setTextContent(hm.get("numberHigh"));
				}
				
				}
				
			}
			
		
	
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("test2.xml"));
		transformer.transform(source, result);
}
}
	

