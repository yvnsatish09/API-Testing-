import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class Basics3 {

	public static void main(String[] args) {
		
		// given-- validate all input details
		//when---submit the API--- resource,httpMethod
		
		
		// Validate the scope is equal to APP or Not
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ " ")
		        .when().post("maps/api/place/add/json")
		        .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		        .header("server","Apache/2.4.18 (Ubuntu)");
		       


	}

}
