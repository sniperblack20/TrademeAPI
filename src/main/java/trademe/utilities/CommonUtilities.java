package trademe.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonUtilities {
		
	public String consumerKey;
	public String consumerSecret;
	public String accessToken;
	public String tokenSecret;
	
	public String getTokensFromPropertiesFile (String token) throws IOException {
		String strToken = null;
		try (InputStream input = CommonUtilities.class.getClassLoader().getResourceAsStream("tokens.properties")) {
			
			Properties prop = new Properties();
			prop.load(input);
			
			strToken = prop.getProperty(token);
			
		} catch (IOException ex) {
			ex.printStackTrace();
	    }	
		return strToken;
	}
}
