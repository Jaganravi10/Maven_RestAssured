package restassured_nonbdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllEmployees {

	@Test
	public void getAllEmployees() {
		
		RestAssured.baseURI = "https://reqres.in";
		
		RequestSpecification specification =  RestAssured.given();
		
		Response response = specification.request(Method.GET,"/api/users?page=2");
		
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		
	}
	
}
