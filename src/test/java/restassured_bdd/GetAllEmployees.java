package restassured_bdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetAllEmployees {
	
	@Test
	public void getAllEmployees () {
		
		RestAssured
		.given()
		.baseUri("https://reqres.in")
		.when()
		.get("/api/users?page=2")
		.prettyPrint();
		
	}

}
