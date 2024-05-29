package com.restAssured.RestAssuredDemo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUserList 
{
   public static void main(String[] args) {
	
	   RestAssured.baseURI="https://reqres.in/";
	   RequestSpecification req=RestAssured.given();
	   
	   Response res=req.get("api/users?page=1");
	   System.out.println(res.asString());
	   System.out.println(res.asPrettyString());
	   System.out.println(res.statusCode());
	   System.out.println(res.getStatusLine());
}
}
