Feature: Search functionality

Scenario: User searches for a valid product
Given User opens application
When User enters valid product "HP" into search field
And User clicks on Search button
Then User should get valid product displayed in search results

Scenario: User searches for an invalid product
Given User opens application
When User enters invalid product "Honda" into search field
And User clicks on Search button
Then User should get a message about no product matching

Scenario: User Searches without any product
Given User opens application
When User dont enter any product name into search bos field
And User clicks on Search button
Then User should get a message about no product matching