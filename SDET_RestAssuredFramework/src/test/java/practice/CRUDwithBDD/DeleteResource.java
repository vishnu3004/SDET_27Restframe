package practice.CRUDwithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteResource {
@Test

public void delete() {
	when()
			.delete("http://localhost:8084/projects/TY_PROJ_607")
			
    .then()
    		.assertThat().statusCode(204)
    		.log().all();
          
}
}
