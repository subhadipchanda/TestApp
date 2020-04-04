package com.edureka.TestApp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest 
{
    
    @Test
	void testHelloEdureka() throws IOException {
		
	    WebDriver driver;
	    
        String mygecko=System.getenv("HOME") + "/Downloads/geckodriver";
        
        System.setProperty("webdriver.gecko.driver",mygecko);
        
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://localhost:8080/helloedureka");
        
		
	    String text = "Hello from Edueka";
	    
	    int l = text.length();

	    String message = "Expected String " + text +  " not found";
	    
	    String bodyText = driver.findElement(By.tagName("body")).getText();

	    System.out.println("Body: " + bodyText.substring(0, l ) + ".");
        Assert.assertEquals(bodyText.substring(0, l),text, message);
        driver.quit();
	}


}
