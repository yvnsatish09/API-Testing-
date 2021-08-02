import files.payload;
import io.restassured.path.json.JsonPath;

public class Basic26 {

	public static void main(String[] args) {
		// 26. Retreving the json size and its elements using JsonPath
		
		// In Json path we need to pass the String argument
		JsonPath js=new JsonPath(payload.coursePrice());
		int count = js.getInt("courses.size()");// print the number of courses returned by API
		// size()-----This will give total count of size method in Json path 
		System.out.println(count);
		int totalCount = js.getInt("dashboard.purchaseAmount");// Print the Purchase count
		System.out.println(totalCount);
		// print the title of the first course
		String titleFirstCourse = js.get("courses[2].title"); // here courses is in Jsonpath, indexes represents the name of the courses
		System.out.println(titleFirstCourse);
		
		
		
		// 27........... Print All courses Titles and their respective Prices
		
		System.out.println("----------------------------Section 27---------------------------");
		for(int i=0;i<count;i++) {
			String courseTitles=js.get("courses["+i+"].title");
			System.out.println(js.get("courses["+i+"].price").toString());
			System.out.println(courseTitles);
			
		}
		
		
		
		// 28.Print the number of copies sold by "RPA Course"
		
		System.out.println("----------------------------Section 28---------------------------");
		for(int i=0;i<count;i++) {
			String courseTitless = js.get("courses["+i+"].title");
			if(courseTitless.equalsIgnoreCase("Appium")) {
				int copies = js.get("courses["+i+"].copies");
				System.out.println(" The copies are Particular course is "+ copies);
				break;
			}
		}
		

		
		
		
	}

}
