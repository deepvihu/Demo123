package com.restAssured.RestAssuredDemo;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUser_post {

	public static void main(String[] args) {
		  RestAssured.baseURI="https://reqres.in/";
		  RequestSpecification req=RestAssured.given();
		   
		  JSONObject obj= new JSONObject();
		  obj.put("name", "Vihaan");
		  obj.put("job", "manager");
		  
		  req.body(obj.toJSONString());
		 Response res=req.post("api/users");
		 System.out.println(res.asPrettyString());
		 System.out.println(res.statusLine());
		 
		  
		   
	}

}
