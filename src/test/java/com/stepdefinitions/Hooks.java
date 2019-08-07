package com.stepdefinitions;

import org.apache.log4j.Logger;

import com.utils.ExtentReportsutil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks 
{
	static int scenarioCount;
	static Logger logger = Logger.getLogger(Hooks.class);
	public static int stepCount;
	public static int usernameCount;
	public static int passwordCount;
	public static int errorMsgCount;
	
	@Before
	public static void beforeScenario(Scenario scenario)
	{
		scenarioCount++;
		usernameCount++;
		passwordCount++;
		errorMsgCount++;
		
		ExtentReportsutil.testSuiteStart("src/test/resources/Reports/tetsReport.html", "CHINU");
		
		logger.info("Scnario "+scenarioCount+" : "+scenario.getName());
		ExtentReportsutil.testCaseStart("Scnario "+scenarioCount+" : "+scenario.getName(), "");
	}
	
	@After
	public static void afterScenario(Scenario scenario)
	{
		ExtentReportsutil.testCaseEnd();
		
		ExtentReportsutil.testSuitEnd();
		
		stepCount = 0;
		
	}
}
