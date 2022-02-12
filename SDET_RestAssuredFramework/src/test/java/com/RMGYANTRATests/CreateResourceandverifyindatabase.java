package com.RMGYANTRATests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import POJOCLASS.PojoLIb;
import Sdet_27Genericutility.BaseAPIClass;
import Sdet_27Genericutility.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;



public class CreateResourceandverifyindatabase extends BaseAPIClass {
@Test
public void createresourceverifyinDb() throws Throwable  {
           
	 //step:1 create test data
	   PojoLIb plib = new  PojoLIb("vishnu","IDEA"+jlib.getRandomNumber(),"completed",400);
	                   
	 //step:2 execute a post request
	Response resp =   given()
	   			.body(plib)
	   			.contentType(ContentType.JSON)
	   
	  .when()
	  			.post(EndPoints.CreateProject);
	   
	//Step3: capture the projectId from response

			String expData = rLib.getJSONData(resp, "projectId");
			Reporter.log(expData +" data in response body", true);

			//Step4: Verify data in DB
			String query= "select * from project;";
			String actData= dLib.executequeryAndgetData(query, 1, expData);
			Reporter.log(actData+" data in database", true);

			Assert.assertEquals(expData, actData);
			Reporter.log("Data verification successful", true);
}
}
