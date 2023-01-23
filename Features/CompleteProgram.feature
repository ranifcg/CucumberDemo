#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@completeprogram
Feature: Search the hotel in Adactin app
  I want to test Search functionality in Adactin app

  Scenario Outline: Itenary displayed upon succesful booking
     	Given user is on the login page
    	When user enters "<username>", "<password>"
    	And user clicks on login button    
    	And login is succesful
    	And search Page is displayed
    	And user selects "<location>","<rooms>","<checkin date>","<checkout date>","<adults>"
    	And user clicks on Search button
    	And search results are displayed
    	And user clicks hotel
    	And enter details is displayed
    	And user enters details "<firstname>","<lastname>","<baddress>","<ccnumber>","<cctype>","<expmonth>","<expyear>","<cvv>"
    	And user clicks on Submit button
    	And booking confirmation displayed
    	And user clicks on MyItenary button
    	Then itenary displayed
    Examples: 
      | username  | password | location  |	rooms  | checkin date  | checkout date| adults | firstname | lastname | baddress | ccnumber | cctype | expmonth | expyear | cvv |
      | raniselen | adactin | Sydney | 1 | 13/01/2023  | 15/01/2023| 2 | Rani | Nair | Jayanagar | 1234567812345678 | VISA | 4 | 6| 768|
