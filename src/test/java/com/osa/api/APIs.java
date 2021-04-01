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
	/**
	 * POST
	 * GET
	 * PATCH
	 * GET
	 * DELETE
	 * GET
	 * @param args
	 */
	public static void main(String[] args) {
		//Post call
//		HashMap<String,String> hm=new HashMap<String,String>();
//	    hm.put("firstName", "Habib");
//	    hm.put("lastName","Mahfuz");
//	    hm.put("phone","4545656567");
//	    hm.put("email", "masum@yahoo.com");
//	    Response post=POST("/customers",myPayload(hm));
//		System.out.println(post.getStatusCode());
//		System.out.println("Response: "+post.asString());
	Response get=GET("/customers/60664e7a673829001730d560");
	JSONObject getRe = new JSONObject(get.asString());
	AppContains.LOG.info("==========Before change===========");
	AppContains.LOG.info(getRe.toString(4));
	
	//Utilities.verifyStatuCode(200, get.getStatusCode());
		//Patch call
	HashMap<String,String> hm=new HashMap<String,String>();
	    hm.put("firstName", "Md");
	    hm.put("lastName","Habib");
	    hm.put("phone","4567678878");
	    hm.put("email", "habib@yahoo.com");
	    JSONObject payload=Utilities.getJsonObject(hm);
		System.out.println("==========During change===========");
	Response patch=PATCH("customers/60664e7a673829001730d560",payload);
	JSONObject patch1 = new JSONObject(patch.asString());
	System.out.println(patch1.toString(4));
	System.out.println("==========After change===========");
	Response get1=GET("/customers/60664e7a673829001730d560");
	JSONObject get11 = new JSONObject(get1.asString());
	System.out.println(get11.toString(4));
	
	//Delete call
//	Response delete=DELETE("/customers/6060c3a7e516d40017d03f72");
//	System.out.println(delete.getStatusCode());
//	System.out.println("Response: "+delete.asString());
	}
	public static String myPayload(HashMap<String,String> hm) {
		JSONObject obj = new JSONObject(hm);
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
				.body(payload)
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
	public static Response PATCH(String endpoint,JSONObject payload) {
		RestAssured.baseURI=AppContains.BASE_URI;
		RequestSpecification request = RestAssured.given();			
		Response res=request
				.contentType(ContentType.JSON)
				.body(payload.toString())
				.patch(endpoint);
		return res;
	}
	
}
