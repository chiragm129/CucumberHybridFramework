Feature: Login functionality

//data driven scenario : scenario will be written only once but it will wxecute multiple times
Scenario Outline: Login With valid credentials
Given User has navigated to login page
When User enters valid email address <username>
And User has entered valid password <password>
And User clicks on login button
Then User should get successfully logged in
Examples:
|username 			      | password  |
|chirag123@gmail.com  | Chirag@123|
|chirag2@gmail.com    | Chirag@123|
|chirag3@gmail.com    | Chirag@123|

Scenario: Login with invalid credentials
Given User has navigated to login page
When User enters invalid email into email field
And User enters invalid password "1234434" into password field
And User clicks on login button
Then User should get proper warning message about credentials mis match


Scenario: Login with valid email and invalid passowrd
Given User has navigated to login page
When User enters valid email address "chirag124@gmail.com"
And User enters invalid password "3114441"
And User clicks on login button
Then User should get proper warning message about credentials mis match

Scenario: Login with invalid email and valid passowrd
Given User has navigated to login page
When User enters invalid email into email field
And User enters invalid password "Chirag@123" into password field
And User clicks on login button
Then User should get proper warning message about credentials mis match



Scenario: Login without providing any credentials
Given User has navigated to login page
When User dont enters email address into email field
And User dont enters password into password field
And User clicks on login button
Then User should get proper warning message about credentials mis match

