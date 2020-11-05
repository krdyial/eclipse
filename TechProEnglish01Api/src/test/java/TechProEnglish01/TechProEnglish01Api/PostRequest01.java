package TechProEnglish01.TechProEnglish01Api;


import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;







public class PostRequest01 extends TestBaseDt {
	/*
	 For Post Request, you need;
	 1) Endpoint ==>Mendatory
	 2) Request Body ==> Mendatory
	 3) Authorization ==> It depends on the API
	 4) Headers ==> It depends on the API
	   */
	
	 /*
    When 
      I send POST Request to http://dummy.restapiexample.com/api/v1/create
    Then 
      Status code is 200
      Content Type is "application/json"
      "status" key has value "success"
      "message" key has value "Successfully! Record has been added."
      
    Note: Create Request Body in 3 different ways  
    */
	
	
	@Test
	public void post01() {
spec04.pathParam("create", "create");
		
		//1.way to create request body ==> Not Recommended
		String reqBody = "{\"name\":\"Suleyman\",\"salary\":\"4444\",\"age\":\"33\"}";
		
		Response response = given().spec(spec04).body(reqBody).when().post("/{create}");
		response.prettyPrint();
		
		response.
		      then().
		      assertThat().
		      statusCode(200).
		      contentType(ContentType.JSON).
		      body("status", Matchers.equalTo("success"),
		    	   "message", Matchers.equalTo("Successfully! Record has been added."));

	}
}
