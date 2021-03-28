package com.osa.api;

import java.util.HashMap;
import java.util.Map.Entry;

import org.json.JSONObject;

import com.osa.base.AppContains;
import com.osa.utility.Utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIs {
	public static void main(String[] args) {
		//Get call
//	Response get=GET("/customers/5fb708e8e4a69400176c4366");
//	Utilities.verifyStatuCode(200, get.getStatusCode());
		//Post call
//	HashMap<String,String> hm=new HashMap<String,String>();
//    hm.put("firstName", "Habib");
//    hm.put("lastName","Mahfuz");
//    hm.put("phone","4545656567");
//    hm.put("email", "masum@yahoo.com");
//    Response post=POST("/customers",myPayload(hm));
//	System.out.println(post.getStatusCode());
//	System.out.println("Response: "+post.asString());
		//Delete call
	Response delete=DELETE("/customers/6060c3a7e516d40017d03f72");
	System.out.println(delete.getStatusCode());
	System.out.println("Response: "+delete.asString());
		//Patch call
	}
	public static String myPayload(HashMap<String,String> hm) {
		JSONObject obj = new JSONObject();
//	     obj.put("firstName", "Md");
//	      obj.put("lastName","Masum");
//	      obj.put("phone","4545656567");
//	      obj.put("email", "masum@yahoo.com");
			for(Entry<String, String> e:hm.entrySet()) {
				obj.put(e.getKey(), e.getValue());
			}
	      return obj.toString();
	}
	
	public static Response GET(String endpoint) {
		RestAssured.baseURI=AppContains.BASE_URI;
		RequestSpecification request= RestAssured.given();
		Response res=request.get(endpoint);
		return res;
	}
	
	public static Response POST(String endpoint,String payload) {
		RestAssured.baseURI=AppContains.BASE_URI;
		RequestSpecification request = RestAssured.given();
		Response res=request
				.contentType(ContentType.JSON)
				.body(payload)//playload
				.post(endpoint);
		return res;
	}
	public static Response DELETE(String endpoint) {
		RestAssured.baseURI=AppContains.BASE_URI;
		RequestSpecification request = RestAssured.given();
		Response res=request
				.contentType(ContentType.JSON)
				.delete(endpoint);
		return res;
	}
}
