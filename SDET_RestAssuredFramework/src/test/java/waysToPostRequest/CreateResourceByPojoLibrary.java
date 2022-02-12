package waysToPostRequest;

import org.testng.annotations.Test;

import POJOCLASS.PojoLIb;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResourceByPojoLibrary {
@Test

public void createbyPojo() {
	   PojoLIb  pojo = new PojoLIb("nadeesh","TYSS12345REStassured","completed",200);
     String file;
given()
		.body(pojo)
		.contentType(ContentType.JSON)

.when()
	.post("http://localhost:8084/addProject")
.then()
.assertThat().statusCode(201)
.contentType(ContentType.JSON)
.log().all();
}
}
