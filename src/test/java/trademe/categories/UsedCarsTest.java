package trademe.categories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UsedCarsTest  {
	
	public static Response resp;
    public static String jsonAsString;
    
    static final String BASE_URL = "https://api.tmsandbox.co.nz/v1/Categories/UsedCars.json";
    static final String SANDBOX_BASE_URL = "https://api.tmsandbox.co.nz/";
	
	@Test
	public void returnsStatusCode200Test() throws IOException {
		// quick test for an API response
		resp = RestAssured.given().
	    when().
	    get(SANDBOX_BASE_URL + "v1/Categories/UsedCars.json");
		
		assertEquals("Response should be 200.", 200, resp.getStatusCode());
		System.out.println("Response: " + resp.getStatusCode());
	}
	
	@Test
	public void returnAllUsedCarsBrandsTest() throws IOException {
		// Exercise 1 
		// Return how many named brands of used cars are available in the TradeMe UsedCars category.
		
		resp = RestAssured.given().
	    when().
	    get(SANDBOX_BASE_URL + "v1/Categories/UsedCars.json").
	    then().
	    // check that the content type return from the API is JSON
        contentType(ContentType.JSON).  
        // extract the response
        extract().response(); 
		
		JsonPath jsonPathValidator = resp.jsonPath();
		//To print the list of Car brands from the response
        //System.out.println("Car Brands: " + jsonPathValidator.get("Subcategories.Name"));
        
		List < String > allCarNames = jsonPathValidator.getList("Subcategories.Name");
		
		// count the number of car brands returned
		System.out.println("Number of Car brands : " + allCarNames.size());
		
		assertTrue("The returned number of car brands should be greater than 0.", allCarNames.size() > 0);
		assertNotNull("The returned number of car brands should not be null.", allCarNames.size());
		
		// Bonus: Get the list of all car brands    
        for (String i: allCarNames) {
            System.out.println(i);
        }
	}
	
	@Test
	public void checkIfABrandExistsTest() {
		// Exercise 2a 
		// Check that the brand ‘Kia’ exists
		
		String brandToCheck = "Kia";
		
		resp = RestAssured.given().
	    when().
	    get(SANDBOX_BASE_URL + "v1/Categories/UsedCars.json").
	    then().
        contentType(ContentType.JSON). 
        extract().response(); 
		
		JsonPath jsonPathValidator = resp.jsonPath();
		
		List < String > allCarNames = jsonPathValidator.getList("Subcategories.Name");
		
		// Flag if the car is found in the list 
		boolean carFound = false;
		
		for(String str: allCarNames) {
		    if(str.trim().contains(brandToCheck)) {
		    	carFound = true;
		    	break;
		    } else {
		    	carFound = false;
		    }		    
		}
		assertTrue("Car brand " + brandToCheck + " should be in the list.", carFound == true);
	}
	
	@Test
	public void returnNumberOfListingsFromABrandTest() {
		// Exercise 2b
		// return the current number of Kia cars listed.
		
		String brandToCheck = "Kia";
		
		resp = RestAssured.given().
	    when().
	    get(SANDBOX_BASE_URL + "v1/Categories/UsedCars.json?with_counts=true").
	    then().
        contentType(ContentType.JSON). 
        extract().response(); 
		
		JsonPath jsonPathValidator = resp.jsonPath();
		
		List < String > allCarNames = jsonPathValidator.getList("Subcategories.Name");
		
		// count the number of car brands returned
		int brandCount = allCarNames.size();
		
		// check the position of the brand in the list
		int foundID = 0;
		
		// Flag if a brand exists
		boolean carFound = false;
		
		for (int i = 0; i < brandCount; i++) {
			  if (jsonPathValidator.getString("Subcategories[" + i + "].Name").equals(brandToCheck)) {
				  carFound = true;
				  foundID = i;
				  System.out.println("Index for brand " + brandToCheck + " is: " + foundID);
				  break;
			  } else {
				  foundID = -1;
				  carFound = false;
			  }
			}
		if (carFound == false) {
			System.out.println("Car " + brandToCheck + " not found in list.");
		} else {
			System.out.println("Found listings for brand " + brandToCheck + ": " + jsonPathValidator.getString("Subcategories[" + foundID + "].Count"));
			assertNotNull("The returned number of listings should not be null.", jsonPathValidator.getString("Subcategories[" + foundID + "].Count"));
			
		}
	}
	
	@Test
	public void checkThatABrandDoesNotExistTest() {
		// Exercise 3
		// Check that the brand ‘Hispano Suiza’ does not exist
		
		String brandToCheck = "Hispano Suiza";
		
		resp = RestAssured.given().
	    when().
	    get(SANDBOX_BASE_URL + "v1/Categories/UsedCars.json").
	    then().
        contentType(ContentType.JSON). 
        extract().response(); 
		
		JsonPath jsonPathValidator = resp.jsonPath();
		
		List < String > allCarNames = jsonPathValidator.getList("Subcategories.Name");
		
		// Flag if the car is found in the list
		boolean carFound = false;
		
		for(String str: allCarNames) {
		    if(str.trim().contains(brandToCheck)) {
		    	carFound = true;
		    	break;
		    } else {
		    	carFound = false;
		    }		    
		}
		assertTrue("Car brand " + brandToCheck + " should not be in the list.", carFound == false);
	}
}
