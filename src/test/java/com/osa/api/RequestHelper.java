package com.osa.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.osa.utility.Utilities;

import cucumber.api.DataTable;
import cucumber.api.java.it.Data;
import groovy.json.internal.Exceptions;
import io.restassured.response.Response;

public class RequestHelper {
static Response res=null;
public void getResponse(Response resp) {
	res=resp;
}

public HashMap<String,List<UsersValues>> verifyResponse(DataTable dataTable) {

	List<List<String>>data= dataTable.raw();
	HashMap<String,List<UsersValues>> userInput=new HashMap<String,List<UsersValues>>();
	List<UsersValues> validation=new ArrayList<UsersValues>();
	List<UsersValues> body=new ArrayList<UsersValues>();
	for(int i=0; i<data.size(); i++) {
		if(data.get(i).get(0).toLowerCase().equals("val")) {
			validation.add(new UsersValues(data.get(i).get(1).toString(),data.get(i).get(2).toString()));
		}else if(data.get(0).get(i).toLowerCase().equals("bod")){
			body.add(new UsersValues(data.get(i).get(1).toString(),data.get(i).get(2).toString()));
		}
	}
	userInput.put("val", validation);
	userInput.put("bod", body);
	return userInput;
 }
public  void verifyAPIRes(String xpath,String expectedValue) {
	String actualValue=res.getBody().jsonPath().getString(xpath);
	Utilities.verifyStatu(expectedValue, actualValue);
}

/**
 * This method will take dataTable and return hashMap with key and value
 * @param dataTable
 * @return
 */
public static HashMap<String,String> manageVariable(DataTable dataTable) {
	List<List<String>>data= dataTable.raw();
	HashMap<String,String> hm=new HashMap<String,String>();
	for(int i=0; i<data.size(); i++) {
		if(data.get(i).get(0).toLowerCase().equals("var")) {
			try {
			hm.put(data.get(i).get(2).toString(),data.get(i).get(1).toString());
			}catch(Exception e) {
				hm.put(data.get(i).get(2).toString(),null);	
			}
		}
	}
	return hm;
}
public static String getValueFromResponse(String xpath) {
String value="";
try {
 value=res.getBody().jsonPath().getString(xpath).toString();
}catch(Exception e){
	
}

 return value;
}
}
