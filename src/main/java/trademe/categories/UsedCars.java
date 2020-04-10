package trademe.categories;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

// This class is not yet needed for the exercise, but I'll leave it here for the next features
// and future optimizations

public class UsedCars {
		
	public Response getListOfUsedCarsManufacturers() throws IOException {
		
		Response resp = RestAssured.given().
	    when().
	    get("https://api.tmsandbox.co.nz/v1/Categories/UsedCars.json");
		
		return resp;
	}
}
