package responsevalidation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POJOCLASS.PojoLIb;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class VerifyMultipleData {
@Test(dataProvider = "getData")
public void verifyMultipleData(String createdBy, String projectName, String staus, int teamSize) {
	   PojoLIb pojo = new PojoLIb( createdBy,  projectName,  staus,  teamSize);
	   
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
@DataProvider
 public Object [][] getData(){
	Object[][] objarray = new Object[2][4];	
	objarray[0][0] = "vishnu";
	objarray[0][1] = "TYSS23456";
    objarray[0][2] = "complted";
    objarray[0][3] = 200;
    
    objarray[1][0] = "nadeesh";
    objarray[1][1] = "TYSS23897";
    objarray[1][2] = "completed";
    objarray[1][3] = 300;
     return objarray;
}
	
}

