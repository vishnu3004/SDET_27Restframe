package responsevalidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
public class VerifyResponseTime {
@Test
 public void responsetime() {
	
	when()
			.get("http://localhost:8084/projects")
	.then()
    		.assertThat().time(Matchers.lessThan(500L),TimeUnit.MILLISECONDS)
    		.log().all();
    		}
}
