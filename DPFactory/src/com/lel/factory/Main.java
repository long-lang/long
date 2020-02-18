package com.lel.factory;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {
   public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ParserConfigurationException, SAXException, IOException {
	Factory  foctory = (Factory)XMLUtil.getBean();
	Role role = foctory.createRole();
	role.createHero();
}
}
