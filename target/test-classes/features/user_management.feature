Feature: User Management

  Scenario: Create new user and verify in records table
    Given I open OrangeHRM login page
    When I login with valid admin credentials
    And I navigate to Admin User Management
    And I create a new user
    Then I should see the user in Records Found table
