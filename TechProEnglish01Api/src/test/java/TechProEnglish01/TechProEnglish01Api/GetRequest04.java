package TechProEnglish01.TechProEnglish01Api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class GetRequest04 {

	/*
	 1- How to get all Headers data
	 2- How to get a specific header
	 3- How to assert Headers one by one
	 */
	
	@Test
	public void get01() {
		
		Response response = given().when().get("https://restful-booker.herokuapp.com/booking");
		response.prettyPrint();
		
		//How to get all Headers data
		System.out.println(response.getHeaders());
		
		//assert if headers contain "Expect-CT"
		
		System.out.println(response.getHeader("Expect-CT"));
		
		
		
		
		//How to get a specific header
		System.out.println(response.getHeader("Server"));
		assertEquals(response.getHeader("Expect-CT"),null);	
		
		//Assert that Via header has the value "1.1 vegur"
		
		assertEquals(response.getHeader("Via"), "1.1 vegur");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}

