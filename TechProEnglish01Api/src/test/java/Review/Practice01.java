package Review;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import TechProEnglish01.TechProEnglish01Api.TestBaseDt;

public class Practice01 extends TestBaseDt {
    /*
     * When I send a GET request to REST API URL
     * https://restful-booker.herokuapp.com/booking/1001 Then HTTP Status Code
     * should be 404 And response body contains "Not Found"
     * And response body does not contain "JavaApi"
     *And header "Server" should be "Cowboy" And header
     * "Content-Type" should be "text/plain; charset=utf-8"
     * And header "Via" should be "1.1 vegur"
     * Note: For Base URL use spec02 Note: Use Map for expected
     * values Note: Use Hard Assertion and Soft Assertion

     */
 @Test
 public void get01() {
	spec02.pathParam("id", 1001);
	
	
	//Create a Map
	Map <String, String> expectedData = new HashMap<>();
	expectedData.put("trueBody", "Not Found");
    expectedData.put("wrongBody", "JavaApi");
    expectedData.put("Server", "Cowboy");
    expectedData.put("Content-Type", "text/plain; charset=utf-8");
    expectedData.put("Via", "1.1 vegur" );
    
    //Send Request to API
    
    Response response = given().spec(spec02).when().get("/{id}");
    response.prettyPrint();
    
    //Start Assertion
    
    response.then().
    		 assertThat().
    		 statusCode(404).
    		 headers("Server", expectedData.get("Server"),
    				 "Content-Type", expectedData.get("Content-Type"));
    
    
	
	
	
	 
	 
	 
 }

	
}
