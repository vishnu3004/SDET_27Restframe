package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTest {
@Test

public void bearertoken() {
	given()
			.auth().oauth2("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")
   .when()
   			.get("https://github.com/settings/tokens")
   	.then()
   			.assertThat().statusCode(200)
   			.log().all();
}
}
