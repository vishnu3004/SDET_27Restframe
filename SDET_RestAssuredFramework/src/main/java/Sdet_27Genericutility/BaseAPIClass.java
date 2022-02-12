package Sdet_27Genericutility;

import static io.restassured.RestAssured.*;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIClass {

	public DataBaseUtility dLib = new DataBaseUtility();
	public JavaUtility jlib =  new JavaUtility();
	public RestAssuredUtility rLib = new RestAssuredUtility();
	
	@BeforeSuite
	public void bsconfig() throws Throwable 
	{
		 baseURI = "http://localhost";
			port = 8084;
			
			dLib.connectDb();
			System.out.println("------database connection established----");
	}
	@AfterSuite
	public void asconfig() throws Throwable
	{
		dLib.closeDb();
		System.out.println("--------database connection closed");
	}
}
