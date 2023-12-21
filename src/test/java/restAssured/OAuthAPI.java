package restAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

import utils.JsonFilepassing;

import java.io.IOException;

import io.restassured.response.Response;

public class OAuthAPI extends JsonFilepassing {

private String APIKey="RWZ5VHWGtkW1zD6udMFKCPWZ1";
private String APISecretKey="tQBl64msPeKQ9W5SebmRO2GQi1BaHJYhyzZiIePVrKW1ZqP6H0";
private String AccessToken="72463342-tpTgS41PRLFuSvdwDgtjsHgZxYrL4QAfAcBqcvcYZ";
private String AccessTokenSecret="NfRJovFbLPNaQWnJDTVMLKYPSlgML0wDUCykn0jO6IiC7 ";

	
@Test
public void OAuthValidation() throws IOException

{

RestAssured.baseURI="https://api.twitter.com/1.1/statuses";

Response response = given().
	header("Content-Type","application/json").
	auth().oauth(APIKey, APISecretKey, AccessToken, AccessTokenSecret).
	queryParam("status", "tweets from restassured API framework").
	
when().

	post("/update.json").

then().
	assertThat().statusCode(200).and().
	extract().response();

System.out.println(response);

}

}




