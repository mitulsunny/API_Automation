package com.osa.api;

import java.util.HashMap;
import java.util.Map.Entry;

import org.json.JSONObject;

import com.osa.base.AppContains;
import com.osa.files.FileManager;
import com.osa.utility.Utilities;

import cucumber.api.DataTable;
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
	
		
		HashMap<String,String> hm=new HashMap<String,String>();
	    hm.put("firstName", "Md");
	    hm.put("lastName","Karim");
	    hm.put("phone","4444444444");
	    hm.put("email", "karim@yahoo.com");
	    String payload=Utilities.getJsonObject(hm).toString();
	  
		HashMap<String,String> hm1=new HashMap<String,String>();
	    hm1.put("firstName", "Rahim");
	    hm1.put("lastName","Miha");
	    hm1.put("phone","5555555555");
	    hm1.put("email", "rahim@gmail.com");
	    String payload_patch=Utilities.getJsonObject(hm1).toString();
	    
	    
//	    //POST
//	    AppContains.LOG.info("This is the POST call Payload "+Format.prettyPrint(payload));
//	    Response res_post=executeRequest("post","/customers",payload);
//	    AppContains.LOG.info("This is post response "+Format.prettyPrint(res_post));
//	    
//	    //GET
//	    String get_url="/customers/"+res_post.jsonPath().getString("userId");
//	    AppContains.LOG.info("This is get call URL "+get_url);
//	    //Response res_get=executeRequest("Get",get_url);
//	    AppContains.LOG.info("This is get call Response "+Format.prettyPrint(res_get));
//	    
//	    //PATCH
//	    String patch_url="/customers/"+res_get.jsonPath().getString("userId");
//	    AppContains.LOG.info("This is the Patch call Payload "+Format.prettyPrint(payload_patch));
//	    AppContains.LOG.info("This is the Patch call URL "+patch_url);
//	    Response res_patch=executeRequest("patch",patch_url,payload_patch);
//	    AppContains.LOG.info("This is Patch call response "+Format.prettyPrint(res_patch));
//	    
//	    //DELETE
//	    AppContains.LOG.info("This is DELETE call URL "+res_patch); 
//		//Response res_delete=executeRequest("delete",patch_url);
//		AppContains.LOG.info("This is DELETE call response "+Format.prettyPrint(res_delete));
		}
	public static Response executeRequest(String request, String url, DataTable data) {
		
		Response res=null; 
		String req=request.toLowerCase();
		if(req.equals("get")) {
			res=GET(url);
		}else if(req.equals("post")) {
		String payload=FileManager.readExcelFile(data.raw().get(1).get(1), data.raw().get(1).get(2));
			res=POST(url,payload);
		}else if(req.equals("patch")) {
		String payload=FileManager.readExcelFile(data.raw().get(1).get(1), data.raw().get(1).get(2));
			res=PATCH(url,payload);
		}else if(req.equals("delete")) {
			res=DELETE(url);
		}
		//return new JSONObject(res.asString()).toString(4);
		return res;
	}
	public static Response executeRequest(String request, String url, String payload) {
		Response res=null; 
		String req=request.toLowerCase();
		if(req.equals("get")) {
			res=GET(url);
		}else if(req.equals("post")) {
			res=POST(url,payload);
		}else if(req.equals("patch")) {
			res=PATCH(url,payload);
		}else if(req.equals("delete")) {
			res=DELETE(url);
		}
		//return new JSONObject(res.asString()).toString(4);
		return res;
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
	public static Response PATCH(String endpoint,String payload) {
		RestAssured.baseURI=AppContains.BASE_URI;
		RequestSpecification request = RestAssured.given();			
		Response res=request
				.contentType(ContentType.JSON)
				.body(payload)
				.patch(endpoint);
		return res;
	}
	
}
