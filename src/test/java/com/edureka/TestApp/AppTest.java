package com.edureka.TestApp;

import java.io.FileInputStream;
import java.util.Properties;
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
	    
	    Properties prop = new Properties();
	    FileInputStream f = new FileInputStream("./data.properties");
	    prop.load(f);
	    String myIP = prop.getProperty("public_ip");
	    String myPort = prop.getProperty("tomcat_port");
	    String myAppName = prop.getProperty("app_name");
	    String myURL = "http://" + myIP + ":" + myPort + "/" + myAppName;
	    
	    FirefoxOptions options = new FirefoxOptions();
        
        options.addArguments("--headless");
	    
        String mygecko=System.getenv("HOME") + "/Downloads/geckodriver";

	    //System.out.println("Opening http://34.72.56.228:9090/helloedureka");

	    //System.out.println(mygecko);

        System.setProperty("webdriver.gecko.driver",mygecko);
        
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        
        driver = new FirefoxDriver(options);
        
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	    System.out.println("Opening " + myURL);

	    // You will need to change localhost to IP in case of AWS

        driver.get(myURL);
        
        Thread.sleep(5000);
        
	    String text = "Hello from Edureka";
	    int l = text.length();
        //String message = "Expected String " + text +  " not found";
        String bodyText = driver.findElement(By.tagName("body")).getText();
        
	    Assert.assertEquals(bodyText.substring(0, l),text);
        
	    WebElement mytext = driver.findElement(By.xpath("/html/body/h3"));
	    
	    System.out.println(mytext.getText());
	    
        String mycolor = driver.findElement(By.tagName("body")).getAttribute("bgcolor");
	    
        //String col_message = "Expected bgcolor to be Aqua but found " + mycolor;
	    
	    Assert.assertEquals(mycolor, "Aqua");
        
        driver.quit();
	}


}
