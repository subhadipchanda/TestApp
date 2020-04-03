package com.edureka.TestApp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App 
{
    public static void main( String[] args ) throws Exception
    {

        System.setProperty("webdriver.gecko.driver","/home/edureka/Downloads/geckodriver"); 
      
        System.out.println("Hi, Welcome to Edureka's session on Selenium WebDriver by Prashant Beniwal"); 
      
        FirefoxOptions options = new FirefoxOptions();
        
        options.addArguments("--headless");
        
        WebDriver driver = new FirefoxDriver(options);
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        WebDriverWait mywait = new WebDriverWait(driver,10);
        
        driver.get("http://localhost:8080/helloedureka");
        
        System.out.println(driver.getPageSource());
        
        mywait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1")));
        
        Thread.sleep(5000);
        
        driver.quit();
        
        
        
    }
}
