package Review;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import TechProEnglish01.TechProEnglish01Api.TestBaseDt;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Practice02 extends TestBaseDt {
	/*
	When 
	I send a GET request to REST API URL 
	https://restful-booker.herokuapp.com/booking/1   
	Then 
	HTTP Status Code should be 200
	And Response format should be "application/JSON"
	And first name should be "Sally"
	And lastname should be "Smith"
	And totalprice should be 705
	And checkin date should be "2015-02-16"
	And checkout date should be "2017-06-20"
	Note: For Base URL use spec02
	Note: For actual data use JsonPath
	Note: For expected data use Map
	Note: Use Hard Assertion and Soft Assertion
	{
    "firstname": "Susan",
    "lastname": "Wilson",
    "totalprice": 497,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-11-12",
        "checkout": "2019-12-02"
    },
    "additionalneeds": "Breakfast"
}
	*/
	
	@Test
	public void get01() {
		spec02.pathParam("id", 1);
		
		// Create a Map object
		
		Map <String, Object> expectedData= new HashMap<>();
		
		expectedData.put("firstname", "Jim");
		expectedData.put("lastname", "Ericsson");
		expectedData.put("totalprice", 253);
		expectedData.put("dopasitpaid", true);
		expectedData.put("checkin", "2017-03-17");
		expectedData.put("checkout", "2017-07-06");
		//expectedData.put("additionalneeds", "breakfast");
		
		
		// Response 
		
		Response response= given().spec(spec02).when().get("/{id}");
		response.prettyPrint();
		
		//Hard Assertion
		JsonPath json= response.jsonPath();
		
		response.then().
				 assertThat().
				 statusCode(200).
				 contentType(ContentType.JSON);
				// body(json.getString("firstname"), equalTo(expectedData.get("firstname")),
					//  json.getString("lastname"), equalTo(expectedData.get("lastname")));
		
		//HardAssertion2
		
		assertEquals(expectedData.get("checkin"), json.getString("bookingdates.checkin"));
		//SoftAssertion
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(json.getString("booking.checkout"), expectedData.get("checkout"));
		
		
		
		
		
		
		
		softAssert.assertAll();
	}
}
