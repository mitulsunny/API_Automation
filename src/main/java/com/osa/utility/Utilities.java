package com.osa.utility;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.osa.base.AppContains;

public class Utilities {
	
	public static void main(String[] args) {
		HashMap<String,String> dayPhone = new HashMap<String,String>();
		dayPhone.put("phoneNumber", "1111111111");
		dayPhone.put("phoneType", "Day");
		
		HashMap<String,String> nightPhone = new HashMap<String,String>();
		nightPhone.put("phoneNumber", "888888888");
		nightPhone.put("phoneType", "Night");
		add(getJsonObject(dayPhone));
		add(getJsonObject(nightPhone));
	
		JSONObject students = new JSONObject();
		students.put("firstName", "Md");
		students.put("lastName", "Uddin");
		students.put("middleInitial", "S");
		students.put("phones",getArray());
		System.out.println(students.toString(4));
	}
public static JSONObject getJsonObject(HashMap<String, String> hm) {
	JSONObject object=new JSONObject(hm);
	return object;
}
static JSONArray array=new JSONArray();
public static void add(JSONObject obj) {
	array.put(obj);
}

public static JSONArray getArray() {
	return array;
}
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
