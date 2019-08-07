package com.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/Features"},
		glue = {"com.stepdefinitions"},
		monochrome = true,
		dryRun = false,
		strict = true
		
		)
public class TestRunner {

}
