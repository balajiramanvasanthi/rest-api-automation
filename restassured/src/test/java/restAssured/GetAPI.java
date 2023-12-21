package restAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.equalTo;


public class GetAPI {

@Test
public void getRequestAPI()

{

RestAssured.baseURI="https://petstore.swagger.io/v2";

given().
	queryParam("status","available").

when().

	get("/pet/findByStatus").

then().
	assertThat().statusCode(200).and().
	body("category[0].name",equalTo("Test001"));
}

}




