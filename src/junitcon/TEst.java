package junitcon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import framework.code.Framework_Config;

public class TEst {
	
public static void main(String[] args) {
	InputStream is;
	try {
		is = new FileInputStream(new File(".\\src\\junitcon\\config.xml"));
		Configuration fc = new Configuration(is);
		ConfigBean bean = fc.getConfiguration();
		System.out.println(bean.getClassname());
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
