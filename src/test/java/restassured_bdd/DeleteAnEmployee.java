package restassured_bdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteAnEmployee {
	
	@Test
	public void deleteAnEmployee () {
		
		RestAssured
		.given()
		.baseUri("https://reqres.in")
		.when()
		.delete("/api/users/2")
		.prettyPrint();
		
	}

}
