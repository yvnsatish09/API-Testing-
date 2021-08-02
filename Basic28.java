import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class Basic28 {

	@Test
	public void sumofCourses() {
		int sum=0;
		
		JsonPath js=new JsonPath(payload.coursePrice());
		int count = js.get("courses.size()");
		for(int i=0;i<count;i++) {
			int price=js.get("courses["+i+"].price");
			int copies=js.get("courses["+i+"].price");
			int counts=price*copies;
			sum =sum+counts;
			
		}
		System.out.println(sum);
		int purchaseAmount=js.get("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
		
	}
}
