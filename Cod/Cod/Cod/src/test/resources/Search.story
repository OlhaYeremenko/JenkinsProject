Narrative:
In order to use application functionality
As a user
I want to verify search window

Scenario: 1.1.1 Verify that enter correct value in search field will give search results
Given I am on search page
When Enter the value in Search field whether
And click on search button
Then verify the search results

Scenario: 1.1.2 Verify that enter incorrect value in search field will not give any results
Given I am on search page
When Enter the value in Search field ---
And click on search button
Then verify the message
Scenario: 1.1.3 As a user I want to click on the first link in results
Given I am on search page 
When Enter the value in Search field gismeteo
And click on search button
And verify the search automation results
Then click on the first link
Then verify the click results

