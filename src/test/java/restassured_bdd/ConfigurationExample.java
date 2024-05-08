package restassured_bdd;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

public class ConfigurationExample {
	
	
	public static void main(String[] args) {
		
		String json = "{\r\\n\"\r\n"
				+ "					+ \"    \"name\": \"morpheus\",\r\\n\"\r\n"
				+ "					+ \"    \"job\": \"leader\"\r\n\"\r\n"
				+ "					+ \"}";
		
		Configuration configuration = Configuration.defaultConfiguration();
		
		JsonPath
		.using(configuration)
		.parse(json)
		.read("$.[0].name");
		
	}

}
