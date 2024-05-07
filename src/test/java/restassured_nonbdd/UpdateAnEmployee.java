package restassured_nonbdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateAnEmployee {
	
	@Test
	public void updateAnEmployee () {
		
		RestAssured.baseURI = "https://reqres.in";
		
		RequestSpecification specification = RestAssured.given()
		.header("Content-Type", "application/json")
		.body("{ \"name\": \"morpheus\", \"job\": \"zion resident\", \"role\": \"tester\" }");
		
		Response response = specification.request(Method.PUT, "/api/users/2");
		
		System.out.println(response.asPrettyString());
		
	}

}
