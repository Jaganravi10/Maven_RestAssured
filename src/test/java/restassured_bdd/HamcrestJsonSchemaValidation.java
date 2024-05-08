package restassured_bdd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class HamcrestJsonSchemaValidation {
	
	@Test
	public void validateJsonSchema () throws IOException {
		
		File inputJson = new File ("src/test/resources/Input.json");
		
		String jsonContent = FileUtils.readFileToString(inputJson, "UTF-8");
		
		File jsonSchema = new File ("src/test/resources/Schema.Json");
		
		MatcherAssert.assertThat(jsonContent, JsonSchemaValidator.matchesJsonSchema(jsonSchema));
		

	}

}
