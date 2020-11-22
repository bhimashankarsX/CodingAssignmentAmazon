package com.cts.genericUtils;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.common.base.CaseFormat;

import org.w3c.dom.Node;

public class XMLReader {
	
	/**************************************************************************
	 * 		Initialization for XMLReader
	 * 
	 * ************************************************************************/
	
	
	/**************************************************************************
	 * 		Initialization for READER arguments
	 * 
	 * ************************************************************************/
	
	public static enum readerCases {
		DESIRED_CAPABILITIES,
		TEST_DATA;
	}
	
	/**************************************************************************
	 * 		Reader method to read XML.
	 * 
	 * ************************************************************************/
	
	public static Element reader (readerCases resource) throws SAXException, IOException, ParserConfigurationException {
		File dcXMLFile = new File("./Resources/Data/AmazonData.xml");
		DocumentBuilderFactory xmlParser = DocumentBuilderFactory.newInstance();
		DocumentBuilder xmlBuilder = xmlParser.newDocumentBuilder();
		Document dcXML = xmlBuilder.parse(dcXMLFile);
		
		Element rootElement = dcXML.getDocumentElement();
		
		System.out.println("Root element :" + dcXML.getDocumentElement().getNodeName());
		
		NodeList listDC = rootElement.getElementsByTagName("DesiredCapabilities");
		NodeList listTD = rootElement.getElementsByTagName("TestData");
		
		Element returnElement = null;
		
		switch(resource) {
		case DESIRED_CAPABILITIES:
			Node nodeDC = listDC.item(0);
			System.out.println("\nCurrent Element :" + nodeDC.getNodeName());
			Element elementDC = (Element) nodeDC;
			returnElement = elementDC;
			break;
		
		case TEST_DATA:
			Node nodeTD = listTD.item(0);
			System.out.println("\nCurrent Element :" + nodeTD.getNodeName());
			Element elementTD = (Element) nodeTD;
			returnElement = elementTD;
			break;
		}
		return returnElement;
		
	}
	

	
	
	public static String readFromXML(Element element, String stringToFind) throws DOMException, SAXException, IOException, ParserConfigurationException {
		String dataFromXML;
		dataFromXML = element.getElementsByTagName(stringToFind).item(0).getTextContent();
		return dataFromXML;
	}
	
}
	
