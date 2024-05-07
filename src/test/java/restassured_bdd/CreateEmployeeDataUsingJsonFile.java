package restassured_bdd;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateEmployeeDataUsingJsonFile {
	
	@Test
	public void createAnEmployeeDataUsingJsonFile () {
		
		File jsonFile = new File ("EmployeeData.json");
		
		RestAssured
		.given()
		.baseUri("https://reqres.in/")
		.header("Content-Type", "application/json")
		.body(jsonFile)
		.when()
		.post("/api/users/2")
		.prettyPrint();
		
	}
	

}
