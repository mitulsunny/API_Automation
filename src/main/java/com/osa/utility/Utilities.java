package com.osa.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;

import com.osa.base.AppContains;

public class Utilities {

public static void verifyStatuCode(int expected, int actual) {
	AppContains.LOG.info("Expected value is: "+expected);
	AppContains.LOG.info("Acutal value is: "+actual);
	Assert.assertEquals(actual, expected);
	AppContains.LOG.info("The actual and expected value is matched. ");
}
public static Logger getLog(Class clazz) {
	Logger log=Logger.getLogger(clazz);
	PropertyConfigurator.configure("src/test/resources/log4j.properties");
	return log;
}

}
