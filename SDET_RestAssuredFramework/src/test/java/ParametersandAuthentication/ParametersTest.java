package ParametersandAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParametersTest {
	@Test
	public void param() {
	  given()
	  		.pathParam("username", "vishnu3004")
	  		.queryParam("sort", "created")
	  		.queryParam("per_page",100)
	  .when()
	  		.get("https://api.github.com/users/{username}/repos")
	  .then()
	  		.assertThat().statusCode(200)
	  		.log().all();
	  
	}
}
