package restassured_bdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Serialization {
	
	@Test
	public void serialization () {
		
		Map<String, Object> jsonBody = new HashMap<String, Object>();
		
		Set<String> skills = new LinkedHashSet<String>();
		skills.add("Java");
		skills.add("Selenium");
		skills.add("API");
		
		jsonBody.put("firstName", "Jagan");
		jsonBody.put("lastName", "Ravi");
		jsonBody.put("email", "tester@java.com");
		jsonBody.put("skills", skills);
		
		System.out.println(jsonBody);
		
		RestAssured.given()
		.baseUri("https://reqres.in")
		.header("Content-Type", "application/json")
		.body(jsonBody)
		.log()
		.all()
		.when()
		.post("/api/users/2")
		.then()
		.log()
		.all();
		
	}
	
	

}
