#Author: CHINU
#CreationDate: 05/08/2019
@Login
Feature: Login Feature

Background: User should be on application login page
When user opens "Chrome" browser 
When user enters "http://www.gcrit.com/build3/admin/login.php" url
Then user will be on application login page 
 
@SmokeTest
Scenario: Verify login functionality ussing valid username and password
When user enters "admin" as a username
When user enters "admin@123" as a password
When user clicks on submit button
Then user will be on apllication home page
And user clicks on logout link
Then user will be on application login page
Then close the browser


@EndToEnd
Scenario Outline: Verify login funcationality by passing invalid details
When user enters "<username>" as a username
When user enters "<password>" as a password
When user clicks on submit button
Then user should get " Error: Invalid administrator login attempt." as an error message
Then close the browser

Examples: 
| username | password |
| admin | Admin@123 |
| Admin | admin@123 |
| Admin | Admin@123 |