package TechProEnglish01.TechProEnglish01Api;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class GetRequest01 {

	@Test
	public void getMethod01() {
		
		Response response = given().
							when().
								get("https://restful-booker.herokuapp.com/booking");
		// To see response body on the console use prettyPrint() method
		response.prettyPrint();
		
		// To see the status code on the console use getStatusCode() or statusCode()
		System.out.println("Status Code :"+ response.getStatusCode()); //200
		
		//To assert the status code type the following  
		//assert the format of response body, it should be in Json format
		response.
				then().
				assertThat().
				statusCode(200).
				contentType(ContentType.JSON);
		
		//assert the format of response body, it should be in Json format
		//response.then().assertThat().contentType();
		
		
	}
	
	@Test
	public void getMethod02() {
		Response response = given().
							when().
								get("https://restful-booker.herokuapp.com/booking/3");
		System.out.println("Status Code for method02:"+response.getStatusCode());
		response.prettyPrint();
		//Assert the status code
		//assert the format of response body, it should be in Json format
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
		//assert the format of response body, it should be in Json format
		response.then().assertThat().contentType("application/json");

		
	}
	
}
