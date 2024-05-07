package restassured_bdd;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Employee1Data {

	public static void main(String[] args) throws JsonProcessingException {

		Employee employee1 = new Employee();
		
		employee1.setFirstName("Jagan");
		employee1.setLastName("Ravi");
		employee1.setEmail("tester@java.com");
		employee1.setSkills(Arrays.asList("Java","Selenium","API"));
		
		System.out.println(employee1.getFirstName());
		System.out.println(employee1.getLastName());
		System.out.println(employee1.getEmail());
		System.out.println(employee1.getSkills());
		
		ObjectMapper mapper = new ObjectMapper();
		
		String employeeJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee1);
		
		System.out.println(employeeJson);

	}

}
