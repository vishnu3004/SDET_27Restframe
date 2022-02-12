package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Oauthauthentication {
@Test
public void oauth() {
	Response response = given()
			.formParams("client_id", "SDET_27")
			.formParams("client_secret","66e50ca85db911844d7a8906655ce0c4")
			.formParams("grant_type","client_credentials")
			.formParams("redirect_uri","https://example.com")
	.when()
			.post("http://coop.apps.symfonycasts.com/token");
	String token = response.jsonPath().get("access_token");
	
	given()
			.auth().oauth2(token)
			.pathParam("USER_ID", "2777")
	.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
	.then()
	       .assertThat().statusCode(200)
	       .log().all();
			
}
}

