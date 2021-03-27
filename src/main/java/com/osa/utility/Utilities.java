package com.osa.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Utilities {
	
	public static void main(String[] args) {
		
		
		
	}
	
		public static Logger getLog(Class clazz) {
		Logger log=Logger.getLogger(clazz);
		PropertyConfigurator.configure("src/test/resources/log4j.properties");
		return log;
		}

}
