package restassured_bdd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class ReadingAJsonDocument {

	public static void parseEverytime() throws IOException {

		File jsonFile = new File("src/test/resources/BookStore.json");

		List<Object> priceList = JsonPath.read(jsonFile, "$.Books");

		for (Object price : priceList) {
			System.out.println(price);

		}

	}

	public static void parseOneTime() throws IOException {

		InputStream jsonFile = new FileInputStream("src/test/resources/BookStore.json");

		Object parsedJsonDocument = Configuration.defaultConfiguration().jsonProvider().parse(jsonFile.readAllBytes());

		List<Object> categoryList = JsonPath.read(parsedJsonDocument, "$.Books");

		for (Object category : categoryList) {
			System.out.println(category);

		}

	}

	public static void fluentAPI() throws IOException {

		File jsonFile = new File("src/test/resources/BookStore.json");
		
		DocumentContext context = JsonPath.parse(jsonFile);
		List<Object> categoryList = context.read("$.Magazines");
		
		for (Object category : categoryList) {
			System.out.println(category);

		}
		
	}

	public static void main(String[] args) throws IOException {

		fluentAPI();

	}

}
