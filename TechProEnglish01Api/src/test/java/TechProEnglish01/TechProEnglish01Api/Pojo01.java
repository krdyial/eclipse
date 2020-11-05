package TechProEnglish01.TechProEnglish01Api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Pojo01 extends TestBaseDt{
	
	/*
	 POJO stands for Plain Old Java Object
	 POJO is a class created by using JSON Data
	 Json Data ==> Pojo Class ==> Object ==> Use the object in Automation
	 
	 When you create a Pojo Class, it should have;
	 1) Private variables
	 2) Getter and setter methods for all variables
	 3) Construction with all parameters
	 4) Construction without parameters
	 5) toString()
	 */
	
	
	
	/*                
    When 
      I send POST Request to https://restful-booker.herokuapp.com/booking ==> spec02
      with the request body 
           {
               "firstname": "Ali",
               "lastname": "Can",
               "totalprice": 111,
               "depositpaid": true,
               "bookingdates": {
                   "checkin": "2020-09-16",
                   "checkout": "2020-09-18"
               },
               "additionalneeds": "Wifi"
           }
    Then 
      Status code is 200
      Content Type is "application/json"
      Assert all response body details
      
    Note: Create Request Body by using POJO 
   */
	
	@Test
	public void post01() {
		//To create request body we will use POJO classes
		
		BookingDatesDt bookingDates = new BookingDatesDt("2020-09-16", "2020-09-18");
		BookingDt booking = new BookingDt("Ali","Can", 111, true, bookingDates, "Wifi");
		
		Response response = given().
							   contentType(ContentType.JSON).
							   spec(spec02).
							   body(booking).
							when().
							   post();
		
		response.prettyPrint();
		
		//ActualData is stored inside the JsonPath object
		
		JsonPath actualData = response.jsonPath();
		
		//Hard Assertion
		
		response.then().statusCode(200).contentType(ContentType.JSON);
		
		
		assertEquals(booking.getFirstname(), actualData.getString("booking.firstname"));
		assertEquals(booking.getLastname(), actualData.getString("booking.lastname"));
		assertEquals(booking.getTotalprice().toString(), actualData.getString("booking.totalprice"));
		assertEquals(booking.getDepositpaid(), actualData.getString("booking.depositpaid"));
		
		assertEquals(bookingDates.getCheckin(), actualData.getString("booking.bookingdates.checkin"));
		assertEquals(bookingDates.getCheckout(), actualData.getString("booking.bookingdates.checkout"));
		
		assertEquals(booking.getAdditionalneeds(), actualData.getString("booking.additionalneeds"));
		
		
		
		
		
		
		
	}

}
