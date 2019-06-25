package com.datdprov;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNg_parameter_dataprovider {
	WebDriver driver;
	WebElement	username;
	WebElement	password;
	WebElement	loginbutton;
	WebElement	errormsg;
@BeforeSuite
public void setup_browser(){
	driver=new FirefoxDriver();
	driver.get("file:///C:/Users/Lenovo/Desktop/Selenium%20Software/Offline%20Website/index.html");
	driver.manage().window().maximize();
}

@BeforeClass 
public void LocateAllElement(){
	username=driver.findElement(By.xpath("//input[@id='email']"));
	password=driver.findElement(By.xpath("//input[@id='password']"));
	loginbutton=driver.findElement(By.xpath("//button[contains(@type,'submit')]"));	
}
//@BeforeMethod
//public void ClearAlltextbox(){
//	username.clear();
//	password.clear();
//}
@Test(dataProvider="Logindata")
public void LoginPage(String tcId,String tcDescr,String user,String pass,String expResult) throws InterruptedException{
	System.out.println(tcId+" tcDescr>>  "+tcDescr+ "uname "+user +"passwd"+pass+"expResult"+expResult);
	username.sendKeys(user);
	password.sendKeys(pass);
	Thread.sleep(2000);
	loginbutton.click();
	if(!"validuser".equals(tcDescr)){
	     errormsg=driver.findElement(By.xpath(".//div[@id='email_error']"));
              String	actulmsg=errormsg.getText();     
           Assert.assertEquals(actulmsg, expResult);
	  }else{
		   String actualtitle=driver.getTitle();
		   Assert.assertEquals(actualtitle, expResult);
	}
	
}
@DataProvider(name="Logindata")
public static Object[][] Logindata(){
	return new Object[][]{
	new Object[]	{"TC01","blankUsername","   ","Please enter email & password."},
	new Object[]	{"TC02","invalidUser","krian12@gmail.com","123458","Please enter correct email & password"},
	new Object[]{"TC03","valideuser","kiran@gmail.com","123456","welcome to homepage"},
	};
	
}
}
