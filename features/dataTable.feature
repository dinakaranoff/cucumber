Feature: Login Funtionality
  This feature is to test login with different username and password

@SanityTest
Scenario: Login with credentials
    Given Open TCC LoginPage
    When Enter Credentials from datatable
    |oemtcc@wssqa.net	| P@ssword1 |
    Then Validate HomePage
		#Then  Logout happens
		