package TechProEnglish01.TechProEnglish01Api;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

public class GetRequest14 extends TestBaseDt {
	/*
	GSON is a converter
	GSON is used to convert Json Format Data to Java Objects ==>De- Serialization(We will use that)
	GSON is used to convert Java Objects to Json Data Format ==>Serialization
	*/
	
	@Test
	public void get01() {
		
		Response response = given().spec(spec01).when().get("/2");
		response.prettyPrint();
		
		//Let's convert Json Data to a HashMap
		HashMap<String, Object> hMap = response.as(HashMap.class);
		System.out.println(hMap);
		//print all keys from json data on the console
		System.out.println(hMap.keySet());
		
		//print all values from json data on the console
		System.out.println(hMap.values());
		//======HARD ASSERTIONS===========
		//Assert that "completed" is false
		
		assertEquals(false, hMap.get("completed"));
		
		//Assert that "title" is "quis ut nam facilis et officia qui"
		
		assertEquals("quis ut nam facilis et officia qui", hMap.get("title"));
		
		//Assert that userId is 1
		
		assertEquals(1, hMap.get("userId"));
		
		//===========SOFT ASSERTIONS============
		
		SoftAssert softAssert = new SoftAssert();
		//Assert that "completed" is false
		softAssert.assertEquals(false, hMap.get("completed") );
		softAssert.assertTrue(hMap.get("completed").equals(false));
		//Assert that "title" is "quis ut nam facilis et officia qui"
		
		softAssert.assertEquals("quis ut nam facilis et officia qui", hMap.get("title"));
		softAssert.assertTrue(hMap.get("title").equals("quis ut nam facilis et officia qui"));
		
		//Assert that userId is 1
		
		softAssert.assertTrue(hMap.get("userId").equals(1));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		softAssert.assertAll();
		
		
	}
	
}
