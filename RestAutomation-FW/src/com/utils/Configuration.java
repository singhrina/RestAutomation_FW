package com.utils;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Configuration {

	public static String URI;
	public static String TWITTERURI;
	public static String TOKEN;
	public static String TOKEN_SECRET;
	public static String COMSUMER_KEY;
	public static String CONSUMER_SECRET;

	public void loadProperties() {
		Properties prop = new Properties();

		try {
			FileReader reader = new FileReader(
					new File(String.format("%s/src/com/resources/config.properties", System.getProperty("user.dir"))));
			prop.load(reader);
			URI = prop.getProperty("uri");
			TWITTERURI = prop.getProperty("twitter_uri");
			// if(prop.getProperty("isSecure") == "true")
			{
				TOKEN = prop.getProperty("token");
				TOKEN_SECRET = prop.getProperty("tokensecret");
				COMSUMER_KEY = prop.getProperty("consumerkey");
				CONSUMER_SECRET = prop.getProperty("consumersecret");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
