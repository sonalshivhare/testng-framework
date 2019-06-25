package com.frame;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class login_page {
	WebDriver driver;
	WebElement	username;
	WebElement	password;
	WebElement	loginbutton;
	
	
	@BeforeSuite
	@Parameters({"url"})
	public void Setup_Browser(String url){
		
	
			 driver=new FirefoxDriver();
	      	driver.get(url);
		    driver.manage().window().maximize();
	}
	
 	
	
	@Test
	@Parameters({"user","pass"})
	public void LoginTestcases(String user, String pass ) throws InterruptedException{
		username=driver.findElement(By.xpath("//input[@id='email']"));
		password=driver.findElement(By.xpath("//input[@id='password']"));
		loginbutton=driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
		username.clear();
		username.sendKeys(user);
		Thread.sleep(2000);
		password.clear();
		password.sendKeys(pass);
		Thread.sleep(2000);
		loginbutton.click();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
