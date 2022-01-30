Feature: Free CRM Login Feature

Scenario Outline: Free CRM Login Test Scenario

Given user is already on Login Page
When title of login page is Free CRM
Then user enters "<username>" and "<password>"
Then user clicks on login button
Then user is on home page
Then user moves to new contact page
Then user enters contact details "<firstname>" and "<lastname>"
Then Close the browser


Examples:
	| username           | password  |firstname | lastname |
	| tasatan@gmail.com  | Fatma3112 |Daniel    | Jill		 |
		