package TechProEnglish01.TechProEnglish01Api;
import static io.restassured.RestAssured.*;

import org.junit.Test;

import io.restassured.response.Response;

public class Delete01 extends TestBaseDt{

	/*
	 For Delete Request we need just Endpoint like Get Request, we do not need Request Body
	 
	 */
	
	@Test
	public void delete01 () {
		Response responseGet = given().spec(spec01).when().get("/170");
		responseGet.prettyPrint();
		
		// The data after deleting
		Response responseDel = given().spec(spec01).when().delete("/170");
		responseDel.prettyPrint();
		
		
	}
	
	
	
	
	
}
