package waysToPostRequest;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreatingDataByusingJsonFILE {
@Test
public void createJsonFile() {
	File file = new File("./createdata.json");
	 
	   given()
			.body(file)
			.contentType(ContentType.JSON)
    .when()
			.post("http://localhost:8084/addProject")
    .then()
           .assertThat().contentType(ContentType.JSON)
           .statusCode(201)
           .log().all();
	   
}
}
