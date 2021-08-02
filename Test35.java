import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.ReUsableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class Test35 {
	@Test(dataProvider="BooksData")
	public void addBook(String isbn,String aisle) {
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().header("Content-Type","application/json")
		.body(payload.addBooks(isbn,aisle)) // Controlling the passing the parameters dynamically in the test case
		//first one is characters ,2nd is numbers
		.when().post("/Library/Addbook.php")  
		.then().assertThat()
		.statusCode(200).extract().response().asString();
		JsonPath js=ReUsableMethods.rawToJson(response);
		String id=js.get("ID"); // To Retrieve the ID in json path
		System.out.println(id);
	}
	
	@DataProvider(name="BooksData")
	public Object[][] getData() {
		
		return new Object[][] {{"abc","123"},{"def","456"},{"doll","899"}};
	}

}
