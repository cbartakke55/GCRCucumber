package com.stepdefinitions;

import com.controller.Controller;
import com.operations.OperationsList;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login extends Controller
{
	@When("^user opens \"([^\"]*)\" browser$")
	public void user_opens_browser(String browserName)
	{
		forEveryStep("", "When User Opens"+browserName+" browser", OperationsList.openbrowser, new String[]{browserName});
	}

	@When("^user enters \"([^\"]*)\" url$")
	public void user_enters_url(String url)
	{
		forEveryStep("", "When user enters "+url+" as url", OperationsList.enterurl, new String[] {url});
	}

	@Then("^user will be on application login page$")
	public void user_will_be_on_application_login_page()
	{
		forEveryStep("loginPage", "user will be on application's login page", OperationsList.loginpage, new String[0]);
	}

	@When("^user enters \"([^\"]*)\" as a username$")
	public void user_enters_as_a_username(String username)
	{
		forEveryStep("userName", "When user enters "+username+" as a username", OperationsList.enterusername, new String[] {username});
	}

	@When("^user enters \"([^\"]*)\" as a password$")
	public void user_enters_as_a_password(String password)
	{
		forEveryStep("passWord", "When user enters "+password+" as a password", OperationsList.enterpassword, new String[] {password});
	}

	@When("^user clicks on submit button$")
	public void user_clicks_on_submit_button()
	{
		forEveryStep("submit", "user clicks on submit button", OperationsList.submit, new String[0]);
	}

	@Then("^user will be on apllication home page$")
	public void user_will_be_on_apllication_home_page()
	{
		forEveryStep("HomePage", "Then user will be on apllication home page", OperationsList.homepage, new String[0]);
	}

	@Then("^user clicks on logout link$")
	public void user_clicks_on_logout_link()
	{
		forEveryStep("Logout", "Then user clicks on logout link", OperationsList.logout, new String[0]);
	}
	
	@Then("^user should get \"([^\"]*)\" as an error message$")
	public void user_should_get_as_an_error_message(String errorMesg)
	{
		forEveryStep("ErrorMsg", "Then user should get "+errorMesg+" as an error message", OperationsList.errorMsg, new String[] {errorMesg});
	}
	
	@Then("^close the browser$")
	public void close_the_browser()
	{
		forEveryStep("", "Then close the browser", OperationsList.tearDown, new String[0]);
	}
}
