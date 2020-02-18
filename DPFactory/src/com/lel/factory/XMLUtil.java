package com.lel.factory;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLUtil {
		public static  Object getBean() throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
			DocumentBuilderFactory builderFactory =DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document doc = builder.parse(new File("config.xml"));
			
			NodeList nl = doc.getElementsByTagName("classname");
			Node node = nl.item(0).getFirstChild();
			String value = node.getNodeValue();
			String packageName = XMLUtil.class.getPackage().getName();
			String name = packageName+"."+value;
			Class<?> c = Class.forName(name);
			Object instance = c.newInstance();
			return instance;
		} 
}
