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
Feature: Login Funtionality
  This feature is to test login with different username and password

  Scenario Outline: Login with multi credentials
    Given Open TCC LoginPage
    When Enter userName "<userName>"  password "<password>"
    Then Validate HomePage
		And  Logout happens
		Then Come back to LoginPage
 
  Examples:  
      |userName 															| password  |
      |oemtcc@wssqa.net												| P@ssword1 |
      |tcc20160922-125733_us@mailinator.com 	| P@ssword1 |

  