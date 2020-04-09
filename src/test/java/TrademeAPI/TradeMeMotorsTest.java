package trademeAPI;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TradeMeMotorsTest {

	@Test
	public void returnUsedCarsBrandsTest() {
		
		Response resp = RestAssured.given().
		auth().
		  oauth("E5E348BAFBCC959EB2A93A7A99C33E51", "13C1F036D3BACEB4FDD42033739FE518", "2D28DE7399149D16216E674A733DD181", "0D6E8CD2987F4A63398B208FBACA4F8A").
	    when().
	    get("https://api.tmsandbox.co.nz/v1/Categories/UsedCars.json");
	    
		assertEquals(200, resp.getStatusCode());
		System.out.println(resp.getStatusCode());
//		final OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.twitter.com/1.1/account/verify_credentials.json");
//		service.signRequest(accessToken, request); // the access token from step 4
//		final Response response = service.execute(request);
//		System.out.println(response.getBody());
	}
}
