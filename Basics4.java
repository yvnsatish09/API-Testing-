import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import files.payload;
import io.restassured.RestAssured;

public class Basics4 {

	public static void main(String[] args) {
		
		//  19
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlace())
		        .when().post("maps/api/place/add/json")
		        .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		        .header("server","Apache/2.4.18 (Ubuntu)");

	}

}
