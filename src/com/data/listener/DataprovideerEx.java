package com.data.listener;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners( com.data.listener.ListenerTest.class)
public class DataprovideerEx {

public static	WebDriver driver;
	WebElement user;
	WebElement pswd;
	WebElement logiinbtn;
	WebElement  error_msg;
	
	
	@BeforeSuite
	public void Setup_browser(){
		driver=new FirefoxDriver();
		Reporter.log("browser is opened now");
		driver.get("file:///C:/Users/Lenovo/Desktop/Selenium%20Software/Offline%20Website/index.html");
Reporter.log("websit is opened now");
	}

@BeforeMethod
public void locateAllWebElement(){
	 user=driver.findElement(By.xpath("//input[@id='email']"));   
		pswd=driver.findElement(By.xpath("//input[@id='password']"));
	    logiinbtn=driver.findElement(By.xpath("//button[@type='submit']"));
}


@Test(dataProvider="Login_data",dataProviderClass=DataprovideerEx.class,groups="smoke")
public void LoginTestcases(String tcid,String tcdesr,String username,String password,String expectedresult ) throws InterruptedException{

	  user.clear();
      user.sendKeys(username);
      Thread.sleep(2000);
      pswd.clear();
  	  pswd.sendKeys(password);
  	  Thread.sleep(2000);
  	  logiinbtn.click();
  	  
  	  if(!"validuser".equals(tcdesr)){
  	       error_msg=driver.findElement(By.xpath("//div[@id='email_error']"));
            String actual= error_msg.getText();
           Assert.assertEquals(actual, expectedresult);
}else{
String	actualTitle=driver.getTitle();
Assert.assertEquals(actualTitle, expectedresult);
}


}
@DataProvider(name="Login_data")
public static Object[][] Login_data(){
	return new Object[][] {
		new Object[]{"TCid","blankuser","  ","  ","Please enter email as kiran@gmail.com"},
		new Object[]{"TCid","invaliduser","kiran12@gmail.com","1234567","Please enter email as kiran@gmail.com"},
		new Object[]{"TCid","validuser","kiran@gmail.com","123456","AdminLTE 2 | Dashboard"},
		};
	}
@AfterSuite
public void Close_browser(){
	driver.close();
}
}

