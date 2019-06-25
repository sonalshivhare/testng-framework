package com.asserttestng;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class Soft_Hard_Assert {
	 
	  String class_Name = "Soft_Hard_Assert";
	 
	  Assertion hardAssert = new Assertion();
	 
	  SoftAssert softAssert = new SoftAssert();
	 
	  @Test
	  public void hardAssertMethod() {
	 
	  hardAssert.assertTrue(true == true);
	 
	  hardAssert.assertEquals("Soft_Hard_Assert", "Soft_Hard_Assert");
	 
	  hardAssert.assertEquals(class_Name, "Soft_Hard_Assert");
	 
	  System.out.println("hardAssertMethod Successfully passed!");
	  }
	 
	  @Test
	  public void softAssertionMethod() {
	 
	  softAssert.assertTrue(true == true);
	 
	  softAssert.assertEquals("Soft_Hard_Assert", "Soft_Hard_Assert");
	 
	  softAssert.assertEquals(class_Name, "Soft_Hard_Assert");
	 
	  System.out.println("softAssertionMethod Successfully passed!");
	 
	  softAssert.assertAll();
	  }
	}
