package com.restAssured.RestAssuredDemo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETUserListTest1 {
	RequestSpecification req;
	Response res;
	JsonPath data;
	
	@BeforeTest
	public void init()
	{
		 RestAssured.baseURI="https://reqres.in/";
	}
	
  @Test(priority=-1)
  public void getData() {
	  req=RestAssured.given();
	  res=req.get("api/users?page=2");
	  System.out.println(res.asString());
	 // Assert.assertEquals(res.getStatusCode(), 201);
	  data= res.jsonPath();
	  String email= data.getString("data[0].email");
	  System.out.println(email);
	  Assert.assertEquals(email, "michael.lawson@reqres.in");
  }
  
  @Test(priority=0)
  public void addData()
  {
	  req=RestAssured.given();
	  JSONObject obj= new JSONObject();
	  obj.put("name", "Vihaan");
	  obj.put("job", "manager");
	  req.header("Content-Type", "application/json");
	 res= req.body(obj.toJSONString()).post("api/users");
	 System.out.println(obj);
	 data= res.jsonPath();
	  String job= data.getString("job");
	  System.out.println(job);
	  Assert.assertEquals(job, "manager");
  }
  
  @AfterTest
  public void deallocateMem()
  {
	  req = null;
	  res = null;
	  data= null;
  }
}
