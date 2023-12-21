package restAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

import utils.JsonFilepassing;

import java.io.IOException;

import io.restassured.module.jsv.JsonSchemaValidator;

public class SchemaValidationAPI extends JsonFilepassing {

private String filePath = "C:\\Users\\Balaji\\eclipse-workspace\\restassured\\src\\test\\resources\\post-json2.json";
	
@Test
public void SchemaValidation() throws IOException

{

RestAssured.baseURI="https://petstore.swagger.io/v2";

given().
	header("Content-Type","application/json").
	body(jsonFile(filePath)).
	
when().

	post("/pet").

then().
	assertThat().statusCode(200).and().
	body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json-schema.json"));
}

}




