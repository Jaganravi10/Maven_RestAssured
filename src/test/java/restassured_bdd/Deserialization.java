package restassured_bdd;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class Deserialization {
	
	String json = "{\r\n"
			+ "  \"firstName\" : \"Jagan\",\r\n"
			+ "  \"lastName\" : \"Ravi\",\r\n"
			+ "  \"email\" : \"tester@java.com\",\r\n"
			+ "  \"skills\" : [ \"Java\", \"Selenium\", \"API\" ]\r\n"
			+ "}\r\n"
			+ "";
	
	public void usingObjectMapper () throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper ();
		
		Employee employee = mapper.readValue(json, Employee.class);
		
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getEmail());
		System.out.println(employee.getSkills());

	}
	
	public void usingJaywayJsonPath () {
		
		JacksonMappingProvider mappingProvider = new JacksonMappingProvider();
		
		Configuration configuration = Configuration
		.builder()
		.mappingProvider(mappingProvider)
		.build();
		
		Employee employee = JsonPath.using(configuration)
		.parse(json)
		.read("$", Employee.class);
		
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getEmail());
		System.out.println(employee.getSkills());

	}
	
	public void usingRestAssuredJsonPath () {
		
		io.restassured.path.json.JsonPath jsonPath = io.restassured.path.json.JsonPath.from(json);
		Employee employee = jsonPath.getObject("$", Employee.class);
		
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getEmail());
		System.out.println(employee.getSkills());		
		
	}
	
	public void usingRestAssuredAsFunction () {
		
		Map<String, Object> response = RestAssured
		.given()
		.baseUri("https://reqres.in")
		.when()
		.get("/api/users/2")
		.then()
		.extract()
		.body()
		.as(new TypeRef <Map<String, Object>>() {
		});
		
		System.out.println(response);
		System.out.println(response.get("email"));
	}
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		Deserialization deserialization = new Deserialization ();
		deserialization.usingRestAssuredAsFunction();
		
	}
}
