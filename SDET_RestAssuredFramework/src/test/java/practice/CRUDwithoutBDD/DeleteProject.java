package practice.CRUDwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
	@Test
	public void deleteProject() {
		
	    int expstatus = 204; 
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_603");
		
		
		System.out.println(resp.prettyPrint());
		int accstatus = resp.getStatusCode();
		Assert.assertEquals(expstatus, accstatus);
}
}
