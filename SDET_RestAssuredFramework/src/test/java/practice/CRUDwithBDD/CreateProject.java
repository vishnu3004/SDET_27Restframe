package practice.CRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProject {
@Test

public void createproject() {
	   //creation of random numbers
	
	      Random ran = new Random();
	      int randomNumber = ran.nextInt(500);
	     
	      JSONObject jobj = new JSONObject();
			jobj.put("createdBy", "vishnu");
			jobj.put("projectName","APTYss"+ randomNumber);
			jobj.put("status","created");
			jobj.put("teamSize",200);
			//configure base URI
			baseURI = "http://localhost";
			port = 8084;
			given()
					.body(jobj)
					.contentType(ContentType.JSON)
					
			.when()
			 		.post("/addProject")
			.then()
					.assertThat().statusCode(201)
					.contentType(ContentType.JSON)
					.log().all();
}
}