package BasicRestassuredethods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;



public class getMethodinrestassured {
	
	//BaseURL
	public static String baseuri = "https://jsonplaceholder.typicode.com";
	
	//uri contains//base url//resource//parameter

	public static void main(String[] args) {
		
		System.out.println("started");
		
		//i have to call my baseuri
		RestAssured.baseURI = baseuri;
		
		//given ///when //then 
		//given is my pre-codinition//when is my codition//then is my post-condition
		//given can take parameter , header
		//when resource, body
		//then response ,status code, validation 
		
		given()
		.header("content-Type","application/json");
		//is all about providing the resource
		when()
		.get("/posts")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).and().
		body("userId[0]", equalTo(1)).
		body("title[0]",equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
		
		System.out.println("Ended");
		

	}

}
