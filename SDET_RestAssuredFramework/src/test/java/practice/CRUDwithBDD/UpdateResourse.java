package practice.CRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class UpdateResourse {
@Test
public void updateresourse() {
	 Random ran = new Random();
     int randomNumber = ran.nextInt(500);
    
     JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "vishnu1234");
		jobj.put("projectName","APTYss922"+ randomNumber);
		jobj.put("status","completed");
		jobj.put("teamSize",300);
		given()
				.body(jobj)
				.contentType(ContentType.JSON)
		
       .when()
 				.put("http://localhost:8084/projects/TY_PROJ_607")
 				
 	   .then()
 	   			.assertThat().contentType(ContentType.JSON)
 	   			.statusCode(200)
 	   			.log().all();
		

}
}
