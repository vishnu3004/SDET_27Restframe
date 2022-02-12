package practice.CRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject{
	@Test
	
	public void createproject() {
		//Step1:create test data
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "vishnu");
		jobj.put("projectName","APTY");
		jobj.put("status","created");
		jobj.put("teamSize",10);
		
		//Step2:provide request specification
		    RequestSpecification req = RestAssured.given();
		    req.contentType(ContentType.JSON);
		    req.body(jobj);
		    
		    //Step3:perform the action
		 Response resp = req.post("http://localhost:8084/addProject");
		    
		    //Step4:print console and verify
		    
		    System.out.println(resp.prettyPrint());
		    System.out.println(resp.prettyPeek());
		    System.out.println(resp.asString());
		    System.out.println(resp.getContentType());
		    System.out.println(resp.getStatusCode());		
	}
	
}
