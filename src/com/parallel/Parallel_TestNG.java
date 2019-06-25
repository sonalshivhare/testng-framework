package com.parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Parallel_TestNG {
	 
@Test
public void getChorme() {
 
System.setProperty("webdriver.chrome.driver", "G:\\selenium workspace 1\\testngframework\\src\\com\\parallel\\chromedriver.exe");
System.out.println("Chrome Thread : " + Thread.currentThread().getId());
WebDriver driver = new ChromeDriver();
driver.get("https://www.stqatools.com");
driver.close();
  }
 
@Test
public void getFirefox() {
 
//System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
System.out.println("Firefox Thread : " + Thread.currentThread().getId());
WebDriver driver = new FirefoxDriver();
driver.get("https://www.stqatools.com");
driver.close();
  }
}
