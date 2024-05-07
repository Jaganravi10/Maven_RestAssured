package restassured_nonbdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteAnEmployee {
	
	@Test
	public void deleteAnEmployee() {
		
		RestAssured.baseURI = "https://reqres.in";
		
		RequestSpecification specification = RestAssured.given();
		
		Response response = specification.request(Method.DELETE, "/api/users/2");
		
		System.out.println(response.getStatusLine());
	}
	
}
