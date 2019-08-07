package com.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.config.Config;
import com.google.common.io.Files;

public class ScreenshotUtility extends Config
{
	public static String takeScreenShot(String fileName)
	{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("src/test/resources/ScreenShots/"+fileName+".PNG");
		
		try 
		{
			Files.copy(src, dest);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return dest.getAbsolutePath();
	}
	
}
