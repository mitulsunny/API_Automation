package com.osa.steps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.osa.api.APIs;
import com.osa.api.RequestHelper;
import com.osa.api.UsersValues;
import com.osa.api.Format;
import com.osa.base.AppContains;
import com.osa.utility.Utilities;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class Common {
	 String myValue="";
	public static void main(String[] args) {
		HashMap<String,String> h=new HashMap<String,String>();
		h.put("a", "AAA");
		h.put("b", "BBBBB");
		System.out.println(h.get("a"));
	}
	RequestHelper cv=new RequestHelper();
	@Given("^the authentication is completed here$")
	public void the_authentication_is_completed_here() throws Throwable {
			System.out.println("The authentication is done!!!");
	}
	@When("^I am sending \"([^\"]*)\" request to this endpoint \"([^\"]*)\"$")
	public void i_am_sending_request_to_this_endpoint(String requestType, String endpoint, DataTable data) throws Throwable {

		 AppContains.LOG.info("Sending a **"+requestType+"** request to "+endpoint);
		 Response res_get=APIs.executeRequest(requestType,endpoint, data);
		 Utilities.verifyStatu(res_get.getStatusCode(), Integer.parseInt(data.raw().get(0).get(2)));
		 cv.getResponse(res_get);
		 AppContains.LOG.info(Format.prettyPrint(res_get));
		 
		 
	}
	@Then("^Verifying the following values$")
	public void verifying_the_following_values(DataTable data) throws Throwable {
		HashMap<String,List<UsersValues>> hm=cv.verifyResponse(data);
		List<UsersValues> userValue=hm.get("val");
			for (UsersValues usersValues : userValue) {
				cv.verifyAPIRes(usersValues.getXpath(),usersValues.getExpectedValue());
			}
	}

}
