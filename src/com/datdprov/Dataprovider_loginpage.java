package com.datdprov;

import org.testng.annotations.DataProvider;

public class Dataprovider_loginpage {
@DataProvider(name="Logindata")
public static Object[][] Logindata(){
	return new Object[][]{
	new Object[]	{"TC01","blankUsername","   ","   ","Please enter email & password."},
	new Object[]	{"TC02","invalidUser","krian12@gmail.com","123458","Please enter correct email & password"},
	new Object[]{"TC03","valideuser","kiran@gmail.com","123456","welcome to homepage"},
	};
	
}
}
