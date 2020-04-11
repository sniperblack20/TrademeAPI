package trademe.categories;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import trademe.utilities.CommonUtilities;

public class UsedCars {
		
	public Response getListOfUsedCarsManufacturers() {
		CommonUtilities cu = new CommonUtilities();
		Response resp = RestAssured.given().
	    when().
	    get(cu.SANDBOX_BASE_URL + "v1/Categories/UsedCars.json").
		then().
	    // check that the content type return from the API is JSON
        contentType(ContentType.JSON).  
        // extract the response
        extract().response();
		
		return resp;
	}
	
	public Response getListOfUsedCarsManufacturersWithListings() {
		CommonUtilities cu = new CommonUtilities();
		Response resp = RestAssured.given().
	    when().
	    get(cu.SANDBOX_BASE_URL + "v1/Categories/UsedCars.json?with_counts=true").
		then().
        contentType(ContentType.JSON).  
        extract().response();
		
		return resp;
	}
}
