package com.operations;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.Config;
import com.controller.Controller;
import com.stepdefinitions.Hooks;
import com.utils.ExtentReportsutil;
import com.utils.ScreenshotUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Operations extends Config
{
	public static Logger logger = Logger.getLogger(Operations.class);
	
	public static WebElement getRuntimeObject(String xPath)
	{
		wait = new WebDriverWait(driver, 20);
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		WebElement elt=null;
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			elt = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
		} 
		catch (Exception e) 
		{
			logger.info("Unable to locate element with xPath : "+xPath);
			ExtentReportsutil.stepDetails("FAIL", Controller.stepname, "Unable to locate element with xPath : "+xPath, "");
			e.printStackTrace();
		}
		
		return elt;
	}
	
	public static void openbrowser(String[] list, String xPath)
	{
		String browserName = list[0];
		// cross browser testing 
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info(browserName+" browser launched..!!");
			ExtentReportsutil.stepDetails("PASS", Controller.stepname, "Expected Result : "+browserName+" browser should be launched. <br/> Actual Result : "+browserName+" browser launched.", ScreenshotUtility.takeScreenShot("openBrowser"));
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info(browserName+" browser launched..!!");
			ExtentReportsutil.stepDetails("PASS", Controller.stepname, "Expected Result : "+browserName+" browser should be launched. <br/> Actual Result : "+browserName+" browser launched.", ScreenshotUtility.takeScreenShot("openBrowser"));
		}
		else if(browserName.equalsIgnoreCase("Internet Explorer"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			logger.info(browserName+" browser launched..!!");
			ExtentReportsutil.stepDetails("PASS", Controller.stepname, "Expected Result : "+browserName+" browser should be launched. <br/> Actual Result : "+browserName+" browser launched.", ScreenshotUtility.takeScreenShot("openBrowser"));
		}
		else
		{
			logger.error(browserName+" browser not launched..!!");
			ExtentReportsutil.stepDetails("FAIL", Controller.stepname, "Expected Result : "+browserName+" browser should be launched. <br/> Actual Result : "+browserName+" browser not launched.", ScreenshotUtility.takeScreenShot("openBrowser"));
		}
	}

	public static void enterurl(String[] list, String xPath)
	{
		String url = list[0];
		driver.get(url);
	}

	public static void loginpage(String[] list, String xPath)
	{
		WebElement login = getRuntimeObject(xPath);
		if(login.isDisplayed())
		{
			logger.info("Login Page Verified..!!");
			ExtentReportsutil.stepDetails("PASS", Controller.stepname, "Expected Result: User should be on application's login page <br/> Actual Result: Login Page Verified..!!!", ScreenshotUtility.takeScreenShot("LoginPage"));
		}
		else
		{
			logger.error("Login Page Not Verified..!!");
			ExtentReportsutil.stepDetails("FAIL", Controller.stepname, "Expected Result: User should be on application's login page <br/> Actual Result: Login Page Not Verified..!!!", ScreenshotUtility.takeScreenShot("LoginPage"));
		}
	}

	public static void enterusername(String[] list, String xPath) throws Exception
	{
		WebElement userName = getRuntimeObject(xPath);
		
		userName.clear();
		Thread.sleep(1000);
		
		userName.sendKeys(list[0]);
		
		if(userName.getAttribute("value").equalsIgnoreCase(list[0]))
		{
			logger.info("UserName "+list[0]+" entered successfully..!!");
			ExtentReportsutil.stepDetails("PASS", Controller.stepname, "Expected Result: User should enter "+list[0]+" as a username <br/> Actual Result : UserName "+list[0]+" entered successfully..!!", ScreenshotUtility.takeScreenShot("UserName "+Hooks.usernameCount));
		}
		else
		{
			logger.error("Failed to enter UserName "+list[0]);
			ExtentReportsutil.stepDetails("PASS", Controller.stepname, "Expected Result: User should enter "+list[0]+" as a username <br/> Actual Result : Failed to enter UserName : "+list[0], ScreenshotUtility.takeScreenShot("UserName "+Hooks.usernameCount));
		}
	}

	public static void enterpassword(String[] list, String xPath) throws Exception
	{
		WebElement passWord = getRuntimeObject(xPath);
		
		passWord.clear();
		Thread.sleep(1000);
		
		passWord.sendKeys(list[0]);
		
		if(passWord.getAttribute("value").equalsIgnoreCase(list[0]))
		{
			logger.info("Password "+list[0]+" entered successfully..!!");
			ExtentReportsutil.stepDetails("PASS", Controller.stepname, "Expected Result: User should enter "+list[0]+" as a password <br/> Actual Result : password "+list[0]+" entered successfully..!!", ScreenshotUtility.takeScreenShot("UserName "+Hooks.usernameCount));
		}
		else
		{
			logger.error("Password to enter UserName "+list[0]);
			ExtentReportsutil.stepDetails("PASS", Controller.stepname, "Expected Result: User should enter "+list[0]+" as a password <br/> Actual Result : Failed to enter password : "+list[0], ScreenshotUtility.takeScreenShot("UserName "+Hooks.usernameCount));
		}
	}

	public static void submit(String[] list, String xPath)
	{
		WebElement submit = getRuntimeObject(xPath);
		
		actions = new Actions(driver);
		actions.moveToElement(submit);
		
		String screenshot = ScreenshotUtility.takeScreenShot("Submit");
		
		submit.click();
		
		logger.info("Clicked On Submit Button..!!");
		ExtentReportsutil.stepDetails("PASS", Controller.stepname, "Expected Result : User should Click on submit button <br/> Actual Result : Clicked On Submit Button..!!", screenshot);
	}

	public static void homepage(String[] list, String xPath) throws Exception
	{
		WebElement homePage = getRuntimeObject(xPath);
		
		Thread.sleep(1000);
		
		if(homePage.getText().contains("Logged in as: admin"))
		{
			logger.info("HomePage Verified..!!");
			ExtentReportsutil.stepDetails("PASS", Controller.stepname, "Expected Result : User should be on apllication's home page <br/> Actual Result: HomePage Verified..!!", ScreenshotUtility.takeScreenShot("HomPage"));
		}
		else
		{
			logger.error("HomePage Not Verified..!!");
			ExtentReportsutil.stepDetails("PASS", Controller.stepname, "Expected Result : User should be on apllication's home page <br/> Actual Result: HomePage Not Verified..!!", ScreenshotUtility.takeScreenShot("HomPage"));
		}
	}

	public static void logout(String[] list, String xPath)
	{
		WebElement logout = getRuntimeObject(xPath);
		
		String screenshot = ScreenshotUtility.takeScreenShot("Logout");
		
		logout.click();
		
		logger.info("Clicked On Logout Link..!!");
		ExtentReportsutil.stepDetails("PASS", Controller.stepname, "Expected Result : User should Click on Logout Link <br/> Actual Result : Clicked On Logout Link..!!", screenshot);
	}
	
	public static void errorMsg(String[] list, String xPath)
	{
		WebElement error = getRuntimeObject(xPath);
		
		if(error.getText().equalsIgnoreCase(list[0]))
		{
			logger.info("Error Message Displayed : "+error.getText());
			ExtentReportsutil.stepDetails("PASS", Controller.stepname, "Expected Result : The error message "+list[0]+" should be displayed <br/> Actual Result : Error Message "+error.getText()+" is displayed..!!", ScreenshotUtility.takeScreenShot("ErrorMsg"+Hooks.errorMsgCount));
		}
		else
		{
			logger.info("Error Message not Displayed : "+list[0]);
			ExtentReportsutil.stepDetails("PASS", Controller.stepname, "Expected Result : The error message "+list[0]+" should be displayed <br/> Actual Result : Error Message "+list[0]+" not displayed..!!", ScreenshotUtility.takeScreenShot("ErrorMsg"+Hooks.errorMsgCount));
		}
	}
	
	public static void tearDown(String[] list, String xPath) throws Exception
	{
		Thread.sleep(3000);
		
		driver.close();
		
		logger.info("Browser Closed..!!");
		
		ExtentReportsutil.stepDetails("PASS", Controller.stepname, "Browser Closed..!!", "");
		
	}
}
