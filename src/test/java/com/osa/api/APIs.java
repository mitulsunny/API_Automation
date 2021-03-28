package com.osa.api;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIs {
	public static void main(String[] args) {
		Response get=GET("/customers/5fb708e8e4a69400176c4366");
		System.out.println(get.asString());
		System.out.println(get.jsonPath().getString("firstName"));
		System.out.println(get.jsonPath().getString("email"));
		}
		public static Response GET(String endpoint) {
			RestAssured.baseURI="https://osasapi.herokuapp.com";
			RequestSpecification request= RestAssured.given();
			Response res=request.get(endpoint);
			return res;
		}
}
