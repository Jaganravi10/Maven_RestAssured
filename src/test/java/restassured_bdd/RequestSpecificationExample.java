package restassured_bdd;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationExample {
	
	RequestSpecification requestSpecification;
	
	@BeforeSuite
	public void setRequestSpecification() {
		
		requestSpecification=given()
		.baseUri("https://reqres.in")
		.basePath("/api/users/");
		
	}
	
	@Test
	public void getAnEmployee() {
		
		given()
		.spec(requestSpecification)
		.when()
		.get("/2")
		.prettyPrint();
		
	}
	
	@Test
	public void getAllEmployees() {
		
		given()
		.spec(requestSpecification)
		.when()
		.get()
		.prettyPrint();
		
	}

}
