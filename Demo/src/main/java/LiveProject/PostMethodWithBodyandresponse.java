package LiveProject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostMethodWithBodyandresponse {
	
	@Test
	public void Signup()
	{
	
	RestAssured.baseURI = "https://ecommerceservice.herokuapp.com";
	Response response = given()
	.header("content-Type","application/json")
	//always you can put the body in the given
	.body("{\r\n" + 
			"	\"email\": \"Usha00@gmail.com\",\r\n" + 
			"	\"password\": \"Usha00@123\"\r\n" + 
			"}\r\n" + 
			"")
	//is all about providing the resource
	.when()
	.post("/user/signup")
	.then()
	.assertThat().statusCode(201).contentType(ContentType.JSON)
	.extract().response();
	System.out.println(response.asString());
	
	
	}
}
	


