package com.edureka.TestApp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest 
{
    
	
    @Test
    void testHelloEdureka() throws Exception  {
		
	WebDriver driver;
	    
	FirefoxOptions options = new FirefoxOptions();
        
        options.addArguments("--headless");
	    
        String mygecko=System.getenv("HOME") + "/Downloads/geckodriver";

	System.out.println("Opening http://localhost:8080/helloedureka");

	System.out.println(mygecko);

        System.setProperty("webdriver.gecko.driver",mygecko);
        
        driver = new FirefoxDriver(options);
        
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	System.out.println("Opening http://localhost:8080/helloedureka");

	// You will need to change localhost to IP in case of AWS

        driver.get("http://localhost:8080/helloedureka");
        
        Thread.sleep(5000);
        
	    String text = "Hello from Edureka";
	    
	    int l = text.length();

	    String message = "Expected String " + text +  " not found";
	    
	    String bodyText = driver.findElement(By.tagName("body")).getText();

	    //System.out.println("Body: " + bodyText.substring(0, l ) + ".");
        
	    Assert.assertEquals(bodyText.substring(0, l),text, message);
        
	    WebElement mytext = driver.findElement(By.xpath("/html/body/h3"));
	    
	    System.out.println(mytext.getText());
	    
        driver.quit();
	}


}
