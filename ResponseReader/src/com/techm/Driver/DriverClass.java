package com.techm.Driver;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import com.tech.io.Freader;
import com.techm.xmlparser.xmlParser;

public class DriverClass {

	public static void main(String[] args) {
		
		Freader	 fr =new Freader();
		HashMap<String, String> hm =fr.attribReader();
		xmlParser xp= new xmlParser();
		try {
			xp.xmlreader(hm);
			
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}
	}

}
