Feature: Registration functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to Registration Page
When User enters the details into below field
|firstName  |  Deepak              |
|lastName   |  Mali                |
|telephone  |  1241424414          |
|password    |  Deepak@123         |

And User selects Privacy Plicy
And User clicks on continue button
Then User account should get created successfully

Scenario: User creates an account with all fields
Given User navigates to Registration Page
When User enters the details into below field
|firstName  |  Deepak              |
|lastName   |  Mali                |
|telephone  |  1241424414          |
|password    |  Deepak@123         |
And User selects yes for News Selecter
And User selects Privacy Plicy
And User clicks on continue button
Then User account should get created successfully

Scenario: User creates an duplicate account 
Given User navigates to Registration Page
When User enters the details into below field with duplicate email
|firstName  |  Deepak              |
|lastName   |  Mali                |
|email      |  deepak123@gmail.com |
|telephone  |  1241424414          |
|password    |  Deepak@123         |
And User selects yes for News Selecter
And User selects Privacy Plicy
And User clicks on continue button
Then User account should get proper warning about duplicate email

Scenario: User creates an account without filling any detail
Given User navigates to Registration Page
When User dont enter any details into field
And User clicks on continue button
Then User account should get proper warning for every mandatory field



