
import org.testng.Assert;
import org.testng.annotations.Test;


import files.ReUsableMethods;
import files.payload;

import static io.restassured.RestAssured.given;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Test33 {
	
	@Test
	public void addBook() {
		
		RestAssured.baseURI="http://216.10.245.166";
		
		String response=given().header("Content-Type","application/json")
		.body(payload.addBook()).when().post("/Library/Addbook.php")   // In aisle = add some characters in the middle
		.then().assertThat()
		.statusCode(200).extract().response().asString();
		
		JsonPath js=ReUsableMethods.rawToJson(response);
		String id=js.get("ID"); // To Retrieve the ID in json path
		System.out.println(id);
	}
	
	

}
