package restassured_bdd;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeAndDeserialize {
	
	ObjectMapper mapper = new ObjectMapper();
	String employeeJson;
	
	public void serialize() throws JsonProcessingException {
		
		Employee employee1 = new Employee();
		employee1.setFirstName("Jagan");
		employee1.setLastName("Ravi");
		employee1.setEmail("java@oracle.com");
		employee1.setSkills(Arrays.asList("Java", "Selenium", "API"));
		
		employeeJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee1);

		System.out.println(employeeJson);
	}

	public void deserialize() throws JsonMappingException, JsonProcessingException {
		
		String employeeJson = "{\r\n"
				+ "  \"firstName\" : \"Jagan\",\r\n"
				+ "  \"lastName\" : \"Ravi\",\r\n"
				+ "  \"email\" : \"java@oracle.com\",\r\n"
				+ "  \"skills\" : [ \"Java\", \"Selenium\", \"API\" ]\r\n"
				+ "}";
		
		Employee empObj = mapper.readValue(employeeJson, Employee.class);
		
		System.out.println(empObj.getFirstName());
		System.out.println(empObj.getLastName());
		System.out.println(empObj.getEmail());
		System.out.println(empObj.getSkills());
		
	}
	
	public static void main(String[] args) throws JsonProcessingException {

		SerializeAndDeserialize serializeAndDeserialize = new SerializeAndDeserialize();
		serializeAndDeserialize.deserialize();
	}

}
