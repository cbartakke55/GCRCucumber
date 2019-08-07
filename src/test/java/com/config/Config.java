package com.config;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Config 
{
	public static WebDriver driver;
	public static WebDriverWait wait;
	static FileInputStream fin;
	static Properties properties;
	public static Actions actions;
	
	public static String getXPath(String objectLogicalName)
	{
		try 
		{
			fin = new FileInputStream("src/test/resources/or.properties");
			
			properties = new Properties();
			
			properties.load(fin);
			
		} 
		catch (Exception e) 
		{
			System.out.println("EXeption occured : \n "+e);
		}
		
		return properties.getProperty(objectLogicalName);

		
	}
	
}
