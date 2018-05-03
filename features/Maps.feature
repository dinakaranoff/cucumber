Feature: Login Funtionality with different credential
  This feature is to test login with different username and password

@RegressionTest
Scenario: Login with multi credentials
    Given Open TCC LoginPage
    When Enter Credentials with header using Maps
    |userName					|password		|
    |oemtcc@wssqa.net	| P@ssword1 |
    |tcc20160922-125733_us@mailinator.com 	| P@ssword1 |
        
    Then Validate HomePage
		And  Logout happens
		

