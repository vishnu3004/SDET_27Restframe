package responsevalidation;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

import static io.restassured.RestAssured.*;

public class StaticValidation {
@Test
public void staticvalidation() {
	String expectedprojectName = "testyantra";
	        Response response = when()
	        .get("http://localhost:8084/projects");
	   String actualprojectName = response.jsonPath().get("[0].projectName");
	   response.then()
                     .assertThat()
                     .contentType(ContentType.JSON).and().statusCode(200)
                     .log().all();
	   Assert.assertEquals(expectedprojectName,actualprojectName );
	        
	
}
}
