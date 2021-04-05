@searchTest
Feature: Test Search on Home Page

 @testCase_01
 Scenario Outline: Verify that search results display correct item count
    Given I navigate to Home page
    And I enter values "<item>" in search box
    When I select the item
	Then I verify the result value "<result>" for item "<item>"

    Examples: 
		|item  | result |
		| bag |     622 | 
		| boards |     867 |
  

 @testCase_02
 Scenario: Verify that an alert is displayed when a user attempts to search without entering anything in the search box
    Given I navigate to Home page
    When I click on search icon
    Then I verify that an alert is displayed
    
 @testCase_03
Scenario: Verify that recent search is cleared on clicking clear recent searches option
	Given I navigate to Home page 
	And I enter values "bag" in search box 
	When I select the item 
	Then I clear the recent search 
 

