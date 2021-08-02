import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Basics5 {

	public static void main(String[] args) {
		
		// lecture 20 ---------Extract the complete  "response" body  and store it to the string 
		// 
		 
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlace())
		        .when().post("maps/api/place/add/json")
		        .then().assertThat().statusCode(200).body("scope",equalTo("APP"))
		        .header("server","Apache/2.4.18 (Ubuntu)").extract().response().asString(); // asString we need to store in Response
		
		System.out.println(response);
		JsonPath js=new JsonPath(response);
		String placeId= js.getString("place_id");
		System.out.println("  We need to extract the only place -id is " + placeId);
		
		

	}

}
