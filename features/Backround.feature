Feature: Add/Delete cart function
Description: The purpose of this feature is to test the Background keyword

#write common method in backround scenario

Background: When user Login
    Given Open TCC LoginPage
   	When Enter Credentials from datatable
    |oemtcc@wssqa.net	| P@ssword1 |
    Then Validate HomePage
    
  Scenario: search
    Given open inconsole search page
    When search Pending Orders
    Then Verify some order are found

  Scenario: delete
    Given open inconsole search page
    When search Valid orders
    Then Verify some order are found

    