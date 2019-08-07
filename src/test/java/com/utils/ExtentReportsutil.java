package com.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class ExtentReportsutil 
{
	public static ExtentReports reports;
	public static ExtentTest logger;
	
	public static void testSuiteStart(String filePath, String userName)
	{
		reports = new ExtentReports(filePath,false,NetworkMode.OFFLINE);
		
		reports
				.addSystemInfo("User",userName)
				.addSystemInfo("Operating System","Windows 10")
				.addSystemInfo("Environment","QA");
	}
	
	public static void testCaseStart(String testName, String description)
	{
		logger = reports.startTest(testName, description);
	}
	
	public static void stepDetails(String status, String stepName,String stepDetails, String objectImagePath)
	{
		String stepdetails = stepDetails+"<br/>"+logger.addScreenCapture(objectImagePath);
		
		if(status.equalsIgnoreCase("pass"))
		{
			logger.log(LogStatus.PASS, stepName, stepdetails);
		}
		else if(status.equalsIgnoreCase("fail"))
		{
			logger.log(LogStatus.FAIL, stepName, stepdetails);
		}
		else if(status.equalsIgnoreCase("fatal"))
		{
			logger.log(LogStatus.FATAL, stepName, stepdetails);
		}
		else if(status.equalsIgnoreCase("info"))
		{
			logger.log(LogStatus.INFO, stepName, stepdetails);
		}
		else
		{
			logger.log(LogStatus.SKIP, stepName, stepdetails);
		}
	}
	
	public static void testCaseEnd()
	{
		reports.endTest(logger);
	}
	public static void testSuitEnd()
	{
		reports.flush();
		reports.close();
	}
}
