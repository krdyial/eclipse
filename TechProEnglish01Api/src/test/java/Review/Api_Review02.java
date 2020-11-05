package Review;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*; 

public class Api_Review02 {
	
	/*
	 1- How to get all Headers data
	 2- How to get a specific header
	 3- How to assert Headers one by one
	 */
	
	@Test
	public void get01() {
		Response response = given().when().get("https://restful-booker.herokuapp.com/booking/5");
		
		response.prettyPrint();   
		
		
		//1- How to get all Headers data
		
		response.getHeaders(); 
		System.out.println(response.getHeaders());
		 //Assert if headers contain "Expect-CT"
		System.out.println(response.getHeader("Expect-CT")); //null
		assertEquals(response.getHeader("Expect-CT"), null);
		
		
		// 2- How to get a specific header
		response.getHeader("Server");
		System.out.println(response.getHeader("Server"));
		
		//Assert that Via header value is "1.1 vegur"
		
		assertEquals(response.getHeader("Via"), "1.1 vegur");
		
		
		
	}

}
