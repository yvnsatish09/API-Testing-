import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import files.ReUsableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class Test34 {

	
	@Test
	public void addBook() {

		RestAssured.baseURI="http://216.10.245.166";
		String response=given().header("Content-Type","application/json")
		.body(payload.addBooks("sati","4456")) // Controlling the passing the parameters dynamically in the test case
		//first one is characters ,2nd is numbers
		.when().post("/Library/Addbook.php")  
		.then().assertThat()
		.statusCode(200).extract().response().asString();
		JsonPath js=ReUsableMethods.rawToJson(response);
		String id=js.get("ID"); // To Retrieve the ID in json path
		System.out.println(id);
	}
	
}
