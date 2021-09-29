package LiveProject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostMethodWithBodyandresponseasjson {
	
	public String accessToken;
	public String id;
	public String message;
	
	@Test(enabled=false)
	public void Signup()
	{
	String requestbody ="{\r\n" + 
			"	\"email\": \"Niharika10@gmail.com\",\r\n" + 
			"	\"password\": \"Niharika10@123\"\r\n" + 
			"}\r\n" + 
			"";
	RestAssured.baseURI = "https://ecommerceservice.herokuapp.com";
	Response response = given()
	.header("content-Type","application/json")
	//always you can put the body in the given
	.body(requestbody)
	//is all about providing the resource
	.when()
	.post("/user/signup")
	.then()
	.assertThat().statusCode(201).contentType(ContentType.JSON)
	.extract().response();
	String jsonResponse = response.asString();
	//it will convert my entire response body in to json format
	JsonPath responsebody = new JsonPath(jsonResponse);
	//so i am trying to pass the object in my print system which will fetch me the value
	System.out.println("messgae :" + responsebody.get("message"));
	//System.out.println(response.asString());
		
	}
	
	@Test(priority=0)
	public void Login()
	{
		String requestbody ="{\r\n" + 
				"	\"email\": \"Niharika10@gmail.com\",\r\n" + 
				"	\"password\": \"Niharika10@123\"\r\n" + 
				"}\r\n" + 
				"";
	RestAssured.baseURI = "https://ecommerceservice.herokuapp.com";
	Response response = given()
	.header("content-Type","application/json").log().all()
	//always you can put the body in the given
	.body(requestbody)
	//is all about providing the resource
	.when()
	.post("/user/login")
	.then().log().all()
	.assertThat().statusCode(200).contentType(ContentType.JSON)
	.extract().response();
	String jsonResponse = response.asString();
	//it will convert my entire response body in to json format
	JsonPath responsebody = new JsonPath(jsonResponse);
	//so i am trying to pass the object in my print system which will fetch me the value
	System.out.println("login :" + responsebody.get("accessToken"));
	//System.out.println(response.asString());
	accessToken = responsebody.get("accessToken");
		
	}
	
	@Test(priority=1)
	public void getallusers()
	{
//		String requestbody ="{\r\n" + 
//				"	\"email\": \"Niharika10@gmail.com\",\r\n" + 
//				"	\"password\": \"Niharika10@123\"\r\n" + 
//				"}\r\n" + 
//				"";
	RestAssured.baseURI = "https://ecommerceservice.herokuapp.com";
	Response response = given().log().all()
	.header("content-Type","application/json")
	.header("Authorization","bearer " + accessToken)
	//always you can put the body in the given
//	.body(requestbody)
	//is all about providing the resource
	.when()
	.get("/user")
	.then().log().all()
	.assertThat().statusCode(200).contentType(ContentType.JSON)
	.extract().response();
	String jsonResponse = response.asString();
	//it will convert my entire response body in to json format
	JsonPath responsebody = new JsonPath(jsonResponse);
	//so i am trying to pass the object in my print system which will fetch me the value
	System.out.println("usersid :" + responsebody.get("users[100]._id"));
	//System.out.println(response.asString());
	id = responsebody.get("users[100]._id");
		
	}
	
	@Test(priority=2)
	public void deleteuser()
	{
//		String requestbody ="{\r\n" + 
//				"	\"email\": \"Niharika10@gmail.com\",\r\n" + 
//				"	\"password\": \"Niharika10@123\"\r\n" + 
//				"}\r\n" + 
//				"";
	RestAssured.baseURI = "https://ecommerceservice.herokuapp.com";
	Response response = given().log().all()
	.header("content-Type","application/json")
	.header("Authorization","bearer " + accessToken)
	//always you can put the body in the given
//	.body(requestbody)
	//is all about providing the resource
	.when()
	.delete("/user/" + id)
	
	
	.then().log().all()
	.assertThat().statusCode(200).contentType(ContentType.JSON)
	.extract().response();
	String jsonResponse = response.asString();
	//it will convert my entire response body in to json format
	JsonPath responsebody = new JsonPath(jsonResponse);
	//so i am trying to pass the object in my print system which will fetch me the value
	System.out.println("message :" + responsebody.get("message"));
	//System.out.println(response.asString());
	message = responsebody.get("message");
		
	}
	
}
	


