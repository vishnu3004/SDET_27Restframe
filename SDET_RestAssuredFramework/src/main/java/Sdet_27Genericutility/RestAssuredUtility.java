package Sdet_27Genericutility;

import io.restassured.response.Response;

/**
 * This class contains generic methods to rest assured 
 * @author DELL
 *
 */
public class RestAssuredUtility {
	/**
	 *This method will return the json data for the json path specified
	 * @param resp
	 * @param jsonpath
	 * @return 
	 * @return
	 */

	public String getJSONData(Response resp,String jsonpath) { 
		
		 String jsonData = resp.jsonPath().get(jsonpath);
		 return jsonData;
	 }
}
