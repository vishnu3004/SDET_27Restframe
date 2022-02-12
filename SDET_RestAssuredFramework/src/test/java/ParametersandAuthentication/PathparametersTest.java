package ParametersandAuthentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathparametersTest {
@Test

public void pathParameters() {
	
	String proId = "TY_PROJ_602";
	given()
			.pathParam("projectId", proId)
	.when()
			.delete("http://localhost:8084/projects/{projectId}")
	.then()
			.contentType(ContentType.JSON)
			.statusCode(204)
			.log().all();
	
}
}
