package restAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import utils.JsonFilepassing;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;


public class PostRequestAPI extends JsonFilepassing {

private String filePath = "C:\\Users\\Balaji\\eclipse-workspace\\restassured\\src\\test\\resources\\post-json.json";
	
@Test
public void getRequestAPI() throws IOException

{

RestAssured.baseURI="https://petstore.swagger.io/v2";

given().
	header("Content-Type","application/json").
	body(jsonFile(filePath)).
	
when().

	post("/pet").

then().
	assertThat().statusCode(200).and().
	body("category.name",equalTo("Test002"));
}

}




