package com.testNG;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataProviderTest {
	RequestSpecification req;
	Response res;
	JsonPath data;
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[3][2];
		
		data[0][0] = "deepa";
		data[0][1] = "Consultant";
		
		data[1][0] = "Kunal";
		data[1][1] = "Consultant";
		
		data[2][0] = "Suraj";
		data[2][1] = "Sr.Engg";
		
		return data;
	}
	
	@BeforeTest
	public void init()
	{
		 RestAssured.baseURI="https://reqres.in/";
	}
  
  @Test(dataProvider="getData")
  public void addData(String name,String job)
  {
	  req=RestAssured.given();
	  JSONObject obj= new JSONObject();
	  obj.put("name", name);
	  obj.put("job", job);

	  req.header("Content-Type", "application/json");
	 res= req.body(obj.toJSONString()).post("api/users");
	 System.out.println(obj);
	 data= res.jsonPath();
	  String jobdata= data.getString("job");
	  System.out.println(jobdata);
	  Assert.assertEquals(jobdata, job);
  }
  
  @AfterTest
  public void deallocateMem()
  {
	  req = null;
	  res = null;
	  data= null;
  }
}
