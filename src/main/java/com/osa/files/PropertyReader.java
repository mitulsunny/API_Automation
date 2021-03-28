package com.osa.files;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	
	public static void main(String[] args) {
		
		String value = readProperty("baseURI");
		System.out.println(value);
	}
	
	/**
	 * this method will read data from properties file 
	 * and return the data as a String value
	 * @param key
	 * @return String 
	 */
	public static String readProperty(String key) {
		Properties property = new Properties();
		try {
			FileInputStream fileInput = new FileInputStream(new File("src/test/resources/config.properties"));
			property.load(fileInput);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		String value = property.getProperty(key);
		return value;
		
	}

}
