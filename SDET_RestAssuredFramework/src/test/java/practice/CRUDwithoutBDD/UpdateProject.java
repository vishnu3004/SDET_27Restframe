package practice.CRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
@Test
public void updateProject(){
	//Step1:create test data
			JSONObject jobj = new JSONObject();
			jobj.put("createdBy", "sahi");
			jobj.put("projectName","Amazon");
			jobj.put("status","completed");
			jobj.put("teamSize",20);
			
			//Step2:provide request specification
			    RequestSpecification req = RestAssured.given();
			    req.contentType(ContentType.JSON);
			    req.body(jobj);
			    
			    //Step3:perform the action
			 Response resp = req.put("http://localhost:8084/projects/TY_PROJ_603");
			    
			    //Step4: verify only
			 ValidatableResponse validate = resp.then();
			 validate.assertThat().statusCode(200);
			 validate.log().all();
	    
			 	
}
}
