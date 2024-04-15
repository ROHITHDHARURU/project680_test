package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class TestCases extends Main {
	LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    String timestamp = now.format(formatter);
    String email = "test_" + timestamp + "@gmail.com";
    String fullName="test";
    String password="Password@123";

    

    
    //@Test(priority=1)
    public void testSignUpPage() {
        try {
            // Load the driver
            WebDriver driver = Main.loadDriver();
        	
            driver.manage().window().maximize();

            // Navigate to the signup page
            driver.get("http://localhost:3000/predicate");
            

            
            WebElement signupButton = driver.findElement(By.id("signup_button"));
            signupButton.click();

            // Fill the signup form
            WebElement fullNameField = driver.findElement(By.name("fullName"));
            WebElement emailField = driver.findElement(By.name("email"));
            WebElement passwordField = driver.findElement(By.name("password"));
            fullNameField.sendKeys(fullName);
            emailField.sendKeys(email);
            String password = "Password@123";
            passwordField.sendKeys(password);

            // Submit the form
            WebElement signUpButton = driver.findElement(By.name("submit"));
            signUpButton.click();

            // Wait for success message
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            WebElement successMessage = driver.findElement(By.id("success_alert"));
            String message = successMessage.getText();

            // Assert the success message
            Assert.assertEquals(message, "Signup successful! Redirecting to SignIn page...",
                    "Failed to Signup.");
            System.out.println("Assertion passed. Test passed!");
            System.out.println("Signup test successful for email: " + email);

            // Quit the driver
            driver.quit();
        } catch (Exception e) {
            System.out.println("Error in TestCases class");
            e.printStackTrace();
        }
    }
    
    //@Test(priority=2)
    public void testLoginPage() {
    	// Load the driver
        WebDriver driver = Main.loadDriver();
        driver.manage().window().maximize();
        // Navigate to the signin page
        driver.get("http://localhost:3000/predicate");
    	WebElement signinButton = driver.findElement(By.id("signin_button"));
    	signinButton.click();
    	driver.findElement(By.id("email")).sendKeys(email);
    	driver.findElement(By.id("password")).sendKeys(password);
    	driver.findElement(By.id("submit")).click();
    	 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    	String message=driver.findElement(By.name("id_fullName")).getText(); 
    	Assert.assertEquals(message,"Welcome - "+fullName,"Failed to SignIn.");
        System.out.println("Assertion passed. Test passed!");
        driver.quit();
           		
    }
    


//negative test case
@Test(priority=3)
public void testLoginWithUnsignedCredentials()
{
	
}
}
