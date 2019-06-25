package com.data.listener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;




public class CaptureScreenshot {
public static String capture(String screenshotName) throws IOException{
	TakesScreenshot ts=(TakesScreenshot) DataprovideerEx.driver;
File	scr= ts.getScreenshotAs(OutputType.FILE);
String   dest=System.getProperty("user.dir")+"/ErrorScreenShot/"+ screenshotName +".png";
File destination=new File(dest);
FileUtils.copyFile(scr, destination);
	
	
	return  dest;
}
}
