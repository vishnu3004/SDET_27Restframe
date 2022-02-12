package responsevalidation;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicValidation {
@Test
public class DynamicResponseValidation {
	@Test
	public void verify() {
		String expectedprojectName = "testyantra";
		Response response = when()
		   .get("http://localhost:8084/projects");
		List<String> projectname = response.jsonPath().get("projectName");
		boolean flag = false;
		for(String pname:projectname) {
			try {
				if (pname.equals(expectedprojectName)) {
					flag=true;
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		response.then()
		.assertThat()
		.contentType(ContentType.JSON).and().statusCode(200)
		.log().all();
		Assert.assertEquals(flag, true);

}
}
}
	
   

