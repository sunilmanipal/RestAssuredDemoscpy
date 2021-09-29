package BasicRestassuredethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetMethodwithparameter {

	public static void main(String[] args) {

		
		System.out.println("started");
		
		//i have to call my baseuri
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		//given ///when //then 
		//given is my pre-codinition//when is my codition//then is my post-condition
		//given can take parameter , header
		//when resource, body
		//then response ,status code, validation 
		
		given().param("postId", "2")
		.header("content-Type","application/json")
		//is all about providing the resource
		.when()
		.get("/comments")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).and().
		body("id[0]", equalTo(6)).
		body("name[0]",equalTo("et fugit eligendi deleniti quidem qui sint nihil autem"));
		
		System.out.println("Ended");
		

	}

}
