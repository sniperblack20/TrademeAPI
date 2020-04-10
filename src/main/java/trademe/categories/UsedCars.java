package trademe.categories;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import trademe.utilities.CommonUtilities;

// This class is not yet needed for the exercise, but I'll leave it here for the next features
// and future optimizations

public class UsedCars {

	public String consumerKey;
	public String consumerSecret;
	public String accessToken;
	public String tokenSecret;
	
	public void setTokens() throws IOException {
		CommonUtilities comutils = new CommonUtilities();
		
		consumerKey = comutils.getTokensFromPropertiesFile("consumerKey");
		consumerSecret = comutils.getTokensFromPropertiesFile("consumerSecret");
		accessToken = comutils.getTokensFromPropertiesFile("accessToken");
		tokenSecret = comutils.getTokensFromPropertiesFile("tokenSecret");
	}
	
	public Response getListOfUsedCarsManufacturers() throws IOException {
		setTokens();
		
		Response resp = RestAssured.given().
		auth().
		  oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
	    when().
	    get("https://api.tmsandbox.co.nz/v1/Categories/UsedCars.json");
		
		return resp;
	}
}
