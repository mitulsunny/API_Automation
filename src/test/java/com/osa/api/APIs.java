package com.osa.api;

import com.osa.base.AppContains;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIs {
	public static void main(String[] args) {
	Response get=GET("/customers/5fb708e8e4a69400176c4366");
	AppContains.LOG.info("getting customer info by id!");
	System.out.println(get.asString());
	//System.out.println(get.jsonPath().getString("firstName"));
	//System.out.println(get.jsonPath().getString("email"));
	}
	public static Response GET(String endpoint) {
		//RestAssured.baseURI="https://osasapi.herokuapp.com";
		RestAssured.baseURI=AppContains.BASE_URI;
		RequestSpecification request= RestAssured.given();
		Response res=request.get(endpoint);
		return res;
	}
}
