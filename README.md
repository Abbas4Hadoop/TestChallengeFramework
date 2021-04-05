# TestChallengeFramework
Code repository for automation scripts to run Bunnings test challenge
selenium-cucumber-java
This repository contains a selenium-cucumber-java project and libraries that contains automation script for top 3 test cases for search bar on Bunnings website. Total time taken to complete the task is 1 hr and 30 min( 40 min for framework set up and 50 min for scripting test cases

**Installation (pre-requisites)**
1.	JDK 1.8+ (make sure Java class path is set)
2.	Maven 
3.	Eclipse
4.	Eclipse Plugins for Maven and Cucumber
5.	Browser driver (compatible browser driver)

**Framework set up**

Fork / Clone repository from https://github.com/Abbas4Hadoop/TestChallengeFramework or download zip
Tests are written in the Cucumber framework using the Gherkin Syntax. More about Gherkin & Cucumber can be found at https://cucumber.io/docs/reference 

Feature path: .\\src\\main\\java\\feature

Step Definitions: .\\src\\main\\java\\stepsDefinitions

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
	
	
**The Page Object Design Pattern**

Within the web app's UI there are areas that the tests interact with. Instead of writing page objects within the step definitions file, I have placed them in “HomePage.java” file where one can manage all these web elements and methods together. Steps class interacts with page class to perform an action. This reduces the amount of duplicated code and means that if the UI changes, the fix need only be applied in one place.
I have also attached the execution video here https://github.com/Abbas4Hadoop/TestChallengeFramework/blob/main/ExecutionVideo.mp4

