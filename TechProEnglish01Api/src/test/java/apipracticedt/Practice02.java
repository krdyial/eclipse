package apipracticedt;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import TechProEnglish01.TechProEnglish01Api.TestBaseDt;
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
	*/
	
	@Test
	public void get01() {
		
		spec02.pathParam("id", 1);
		
		
		JSONObject expectedData= new JSONObject();
		expectedData.put("statuscode", 200);
		expectedData.put("firstname", "Susan");
		expectedData.put("lastname", "Brown");
		expectedData.put("totalprice", 522);
		expectedData.put("checkin", "2016-10-04");
		expectedData.put("checkout", "2019-12-24");
		
		
		
		Response response = given(). spec(spec02).when().get("/{id}");
		response.prettyPrint();
		
		response.then().
				 assertThat().
				 statusCode(expectedData.getInt("statuscode")).
				 body("firstname", equalTo(expectedData.getString("firstname")),
				 "lastname", equalTo(expectedData.getString("lastname")),
				 "totalprice", equalTo(expectedData.getInt("totalprice")),
				 "bookingdates.checkin", equalTo(expectedData.getString("checkin")),
				 "bookingdates.checkout", equalTo(expectedData.getString("checkout")));
		
		
		//Assertion by using assertEquals(), assertTrue(), assertFalse()
		// to get actual data from response body, you can use JsonPath
		JsonPath json = response.jsonPath();
		
		assertEquals(expectedData.getInt("statuscode"), response.getStatusCode());
		assertEquals(expectedData.getString("firstname"), json.getString("firstname"));
		assertEquals(expectedData.getString("lastname"), json.getString("lastname"));
		assertEquals(expectedData.getInt("totalprice"), json.getInt("totalprice"));
		assertEquals(expectedData.getString("checkin"), json.getString("bookingdates.checkin"));
		assertEquals(expectedData.getString("checkout"), json.getString("bookingdates.checkout"));
		
		
		// USe De-Serialization with GSON
		
		Map<String, Object> booking = response.as(HashMap.class);
		System.out.println(booking);
	
		assertEquals(expectedData.getInt("statuscode"), response.getStatusCode());
		assertEquals(expectedData.getString("firstname"), booking.get("firstname"));
		assertEquals(expectedData.getString("lastname"), booking.get("lastname"));
		assertEquals(expectedData.getInt("totalprice"), booking.get("totalprice"));
		assertTrue(booking.get("bookingdates").toString().contains(expectedData.getString("checkin")));
		assertTrue(booking.get("bookingdates").toString().contains(expectedData.getString("checkout")));
		
		
		//asString method is used to convert to response object to String
		// toString method is used to convert object objects to String
		
		
		//SoftAssertion
		
		//to get actual data from response body, you can use JsonPath
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(json.getString("firstname"), expectedData.getString("firstname"));
		softAssert.assertEquals(json.getString("lastname"), expectedData.getString("lastname"));
		softAssert.assertEquals(json.getInt("totalprice"), expectedData.getInt("totalprice"));
		softAssert.assertEquals(json.getString("bookingdates.checkin"), expectedData.getString("checkin"));
		softAssert.assertEquals(json.getString("bookingdates.checkout"), expectedData.getString("checkout"));
		softAssert.assertAll();
		
		
		
	}
	
	
	
	
}
