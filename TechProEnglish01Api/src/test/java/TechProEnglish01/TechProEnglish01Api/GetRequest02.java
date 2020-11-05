package TechProEnglish01.TechProEnglish01Api;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequest02 {
	/*
	 when() I send a GET request to https://restful-booker.herokuapp.com/booking 
	 and I accept type "application/json" ==> Means API accepting data just in Json Format
	 then status code should be 200 
	 and content type should be "application/json" ==> Response body must be in Json format
	 
	 
	 */
	@Test
	public void getMethod01() {
		Response response= given().
					accept(ContentType.JSON).
				when().
					get("https://restful-booker.herokuapp.com/booking");
		
		response.then().
				 assertThat().
				 statusCode(200).
				 contentType(ContentType.JSON);
		
		
		/*
		 when() I send a GET request to https://restful-booker.herokuapp.com/booking/5
		 then status code should be 200 
		 and content type should be "application/json" ==> Response body must be in Json format
		 */
		
	}
	@Test
	public void getMethod02() {
		Response response = given().
							when().
								get("https://restful-booker.herokuapp.com/booking/5");
		
		response.then().
				 assertThat().
				 statusCode(200).
				 contentType(ContentType.JSON);
	}
		/*
		 when() I send a GET request to https://restful-booker.herokuapp.com/booking/1001
		 then status code should be 404
		 and Response Body contains "Not Found"
		 and Responce body does not contain "Suleyman"
		 
		 */
	
		@Test
		
		public void getMethod03() {
			
			Response response = given().
								when().
								get("https://restful-booker.herokuapp.com/booking/1001");
			response.prettyPrint();
			
			response.then().assertThat().statusCode(404);
			
			assertTrue(response.asString().contains("Not Found"));
			assertFalse(response.asString().contains("Suleyman"));
			
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
