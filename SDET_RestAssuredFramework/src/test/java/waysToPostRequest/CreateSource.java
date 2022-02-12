package waysToPostRequest;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateSource {
   @Test
   public void create() {
	   Random ran = new Random();
	   int randomNumber = ran.nextInt(500);
	   
	   JSONObject jobj = new  JSONObject();
	   jobj.put("createdBy", "vishnu3004");
	   jobj.put("projectName","TYSSKTG"+randomNumber);
	   jobj.put("status","completed");
	   jobj.put("teamsize",25);
	   
	   given()
			.body(jobj)
			.contentType(ContentType.JSON)
       .when()
			.post("http://localhost:8084/addProject")
       .then()
              .assertThat().contentType(ContentType.JSON)
              .statusCode(201)
              .log().all();
	   
	 
   }
}
