package waysToPostRequest;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResourceByHashMap {
@Test 
public void createResourseHash() {
	
	HashMap map = new HashMap();

	map.put("createdBy", "nadeesh");
	map.put("projectName", "TYSS0304");
	map.put("status", "completed");
	map.put("teamSize",300);
	
	given()
			.body(map)
			.contentType(ContentType.JSON)
	.when()
			.post("http://localhost:8084/addProject")
    .then()
           .assertThat().contentType(ContentType.JSON)
           .statusCode(201)
           .log().all();
	   
}
}
