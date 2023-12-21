package restAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

import io.restassured.path.json.JsonPath;

import utils.JsonFilepassing;

import io.restassured.response.Response;

public class JWTAPI extends JsonFilepassing {


	
@Test
public void jwtValidation()

{

	Response response =
   
			given()
			
			.headers("username", "abc", "password", "123").
			
            when()
            
                .post("/oauth/token").
                
            then().
            
            assertThat().statusCode(200).and().
        	extract().response();

            
	String resp = response.asString();
    JsonPath jsonPath = new JsonPath(resp);
    String accessToken = jsonPath.getString("access_token");
    
//In the subsequent request we case pass the same accessToken in header

given()
        .header("Authorization", "Bearer "+accessToken)
        .contentType(ContentType.JSON)
        .accept(ContentType.JSON);

}

}




