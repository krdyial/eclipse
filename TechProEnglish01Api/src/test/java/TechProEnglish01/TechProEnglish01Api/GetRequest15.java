package TechProEnglish01.TechProEnglish01Api;

import org.junit.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetRequest15 extends TestBaseDt {
	
	//GSON 
	
	
	@Test
	public void get01() {
		
		Response response = given().spec(spec02).when().get();
		
		response.prettyPrint();
		
		List<Map<String, Integer>> listOfMaps =  response.as(ArrayList.class);
		System.out.println(listOfMaps);

		
	}

}

