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

Feature: Tag feature Testing

@SanityTest
Scenario: Open LoginPage for Sanity
    Given Open LoginPage
   

@SanityTest @RegressionTest
Scenario: Login with valid data 
    Given Open LoginPage
    When Enter userName "oemtcc@wssqa.net"  password "P@ssword1"
		
	
@RegressionTest
Scenario: Validate HomePage for Regresion Test
    Given Open LoginPage
    When Enter userName "oemtcc@wssqa.net"  password "P@ssword1"
    Then Validate HomePage
		

@End2End
Scenario: End to End Testing
    Given Open LoginPage
    When Enter userName "oemtcc@wssqa.net"  password "P@ssword1"
    Then Validate HomePage
    And  Logout happens
    Then Come back to LoginPage