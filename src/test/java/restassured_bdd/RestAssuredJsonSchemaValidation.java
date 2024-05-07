package restassured_bdd;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class RestAssuredJsonSchemaValidation {
	
	@Test(enabled = false)
	public void validationUsingJsonSchemaInClassPath() {
		
		File inputJson = new File ("src/test/resources/Input.json");
		
		RestAssured
		.given()
		.baseUri("https://reqres.in/")
		.header("Content-Type", "application/json")
		.body(inputJson)
		.when()
		.post("/api/users/2")
		.then()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schema.json"));
		
	}

	@Test
	public void vaidationUsingMatchesJsonSchema() {
		
		File inputJson = new File("src/test/resources/Input.json");
		File inputSchema = new File("src/test/resources/Schema.json");
		
		RestAssured
		.given()
		.baseUri("https://reqres.in/")
		.header("Content-Type", "application/json")
		.body(inputJson)
		.when()
		.post("/api/users/2")
		.then()
		.body(JsonSchemaValidator.matchesJsonSchema(inputSchema));
		
	}
}
