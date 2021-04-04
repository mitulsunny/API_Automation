package com.osa.utility;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.osa.base.AppContains;

public class Utilities {
	
	/**
	* This method will take HashMap as parameter
	* we know HashMap has key and value, these key and value will be converted as 
	* JSON object key and value, then return as a JSONObject. 
	* @param hm
	* @return
	*/
	public static JSONObject getJsonObject(HashMap<String, String> hm) {
		JSONObject object=new JSONObject(hm);
		return object;
	}
	
	/**
	 * We know sometime we need to add JSON array in json object
	 * This method will convert add any json object we pass in the array
	 * and generate a new JSON array. 
	 */
	static JSONArray array=new JSONArray();
	public static void add(JSONObject obj) {
		array.put(obj);
	}
	
	/**
	 * This method will return the build array that we have generated by using add(JSONObject) method 
	 * @return
	 */
	public static JSONArray getArray() {
		return array;
	}
	/**
	 * thie method will take expected int values and compare them and 
	 * assert then provide the report. 
	 * @param expected
	 * @param actual
	 */
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
