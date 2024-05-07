package restassured_nonbdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateAnEmployee {
	
	@Test
	public void createAnEmployee () {
		
		RestAssured.baseURI = "https://reqres.in";
		
		RequestSpecification specification = RestAssured.given()
				.header("Content-Type", "application/json")
				.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}");
		
		Response response =	specification.request(Method.POST, "/api/users");
		
		System.out.println(response.asPrettyString());
		
	}
	
}
