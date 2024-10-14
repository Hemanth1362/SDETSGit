Feature: Login Page automation of saucedemo App


Scenario Outline: Check login is successful with valid creds
Given User is on login
When User enters valid "<username>" and "<password>"
And Clicks on Login Button
Then User is navigated to Home Page
And Close the browser

Examples:
| username | password |
| standard_user | secret_sauce |
