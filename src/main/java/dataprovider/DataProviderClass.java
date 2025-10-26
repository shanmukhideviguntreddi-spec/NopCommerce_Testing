package dataprovider;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.BeforeSuite;
/*
Author: 
Create on: 
Purpose:To provide data for test cases
*/

public class DataProviderClass {
	public static Properties prop;
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String DOMAINS = "gmail.com,yahoo.com,hotmail.com,outlook.com";
    public static String randomEmail = null;

	@BeforeSuite
	public void initializeProperties() throws Exception// Initializing configuration properties file
	{
		prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/config/config.properties"));
	}
	public static String generateRandomEmail() {
        Random random = new Random();
        StringBuilder email = new StringBuilder();

        // Generate random local part
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                email.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
            } else {
                email.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
            }
        }

        // Append domain
        String[] domainArray = DOMAINS.split(",");
        String domain = domainArray[random.nextInt(domainArray.length)];
        email.append("@").append(domain);
        randomEmail = email.toString();
        return email.toString();
    }
}
