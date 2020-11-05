package TechProEnglish01.TechProEnglish01Api;
import org.junit.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class Pojo001  extends TestBaseDt{

	
	
	
		/*
		 POJO stands for Plain Old Java Object
		 POJO is a class created by using Json Data
		 Json Data ==> Pojo Class ==> Use the object in Automation
		
		 When you create a Pojo Class, it should have;
		    1)private variables
		    2)getter() and setter() methods for all variables
		    3)Construction with all parameters
		    4)Construction without parameters
		    5)toString()
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
			
			BookingDatesDt bookingDates = new BookingDatesDt("2020-09-16", "2020-09-18");
			BookingDt booking = new BookingDt("Ali", "Can", 111, true, bookingDates, "Wifi");
			
			Response response = given().
									contentType(ContentType.JSON).
									spec(spec02).
									body(booking).
								when().
									post();
			
			response.prettyPrint();
		
		
		
	}
}
