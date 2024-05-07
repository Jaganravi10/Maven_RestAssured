package restassured_bdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateAnEmployee {

	@Test
	public void createAnEmployee () {
		
		RestAssured
		.given()
		.baseUri("https://reqres.in")
		.header("Content-Type", "application/json")
		.body("{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"leader\"\r\n"
					+ "}")
		.when()
		.post("/api/users")
		.prettyPrint();
	}
	
}
