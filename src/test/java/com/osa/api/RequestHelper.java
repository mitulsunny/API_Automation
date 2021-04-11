package com.osa.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.osa.utility.Utilities;

import io.restassured.response.Response;

public class RequestHelper {
Response res=null;
public void getResponse(Response res) {
	this.res=res;
}
public HashMap<String,List<UsersValues>> verifyResponse(List<List<String>> data) {
	HashMap<String,List<UsersValues>> userInput=new HashMap<String,List<UsersValues>>();
	List<UsersValues> validation=new ArrayList<UsersValues>();
	List<UsersValues> body=new ArrayList<UsersValues>();
	System.out.println(data.size());
	for(int i=0; i<data.size(); i++) {
		if(data.get(0).get(i).toLowerCase().equals("val")) {
			validation.add(new UsersValues(data.get(1).get(i).toString(),data.get(2).get(i).toString()));
		}else if(data.get(0).get(i).toLowerCase().equals("bod")){
			body.add(new UsersValues(data.get(1).get(i).toString(),data.get(2).get(i).toString()));
		}
	}
	userInput.put("val", validation);
	userInput.put("bod", body);
//	Utilities.verifyStatu(Integer.parseInt(data.get(0).get(2)),res.getStatusCode());
//	Utilities.verifyStatu(data.get(1).get(2),res.jsonPath().get(data.get(1).get(1)).toString());
	return userInput;
 }

}
