package com.frame;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Parameterization {
	 
	  @Parameters({ "browser" })
	 
	  @Test
	  public void testCaseOne(String browser) {
	 
	  System.out.println("browser passed as :- " + browser);
	  }
	 
	  @Parameters({ "user", "pass" })
	 
	  @Test
	  public void testCaseTwo(String user, String pass) {
	 
	  System.out.println("Parameter for UserName:- " + user);
	  System.out.println("Parameter for Password:- " + pass);
	  }
	}
