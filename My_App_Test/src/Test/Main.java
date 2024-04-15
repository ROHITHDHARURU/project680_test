package Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {
    public static void main(String[] args) {
    	loadDriver();
    }
    public static WebDriver loadDriver() {
    	
        Properties properties = new Properties();
        FileInputStream input = null;
        WebDriver driver = null;

        try {
            // Load properties file
            input = new FileInputStream("src/Test/config.properties");
            properties.load(input);

            // Get EdgeDriver path from properties
            String edgeDriverPath = properties.getProperty("edgedriver.path");

            // Set the system property
            System.setProperty("webdriver.edge.driver", edgeDriverPath);

            // Initialize EdgeDriver
            driver = new EdgeDriver();

            // Open a webpage
            //replace the localhost url with the domain url, once the application is deployed.
            driver.get("http://localhost:3000/predicate");

            // Print page title
            System.out.println("Page title is: " + driver.getTitle());
            return driver;
            
            
        } catch (IOException e) {
            e.printStackTrace();
        } 
		return null;
		
    }
}
