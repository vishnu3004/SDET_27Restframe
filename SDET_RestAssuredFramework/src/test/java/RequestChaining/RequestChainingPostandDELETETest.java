package RequestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class RequestChainingPostandDELETETest {
@Test

public void postanddEL() {
	 Random ran = new Random();
     int randomNumber = ran.nextInt(500);
    
     JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "vishnu");
		jobj.put("projectName","TYSS_"+ randomNumber);
		jobj.put("status","created");
		jobj.put("teamSize",200);
		
		given()
				.body(jobj)
				.contentType(ContentType.JSON)
				
		.when()
		 		.post("http://localhost:8084/addProject")
		.then()
				.assertThat().statusCode(201)
				.contentType(ContentType.JSON)
				.log().all();
		
		Response resp = when()
			 	.get("http://localhost:8084/projects");
	 String prId = resp.jsonPath().get("[0].projectId");
	 System.out.println(prId);
	 given()
		.pathParam("projectId", prId)
		.when()
		.delete("http://localhost:8084/projects/{projectId}")
		.then()
		.assertThat().statusCode(204)
		.log().all();
  		     			
	
}
}
