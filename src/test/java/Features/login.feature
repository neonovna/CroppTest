Feature: LoginFeature

  Scenario: Login with valid username and password
    Given I am on Login form
    And I enter the following for login
    And click on login button
    Then I should see the main page


  Scenario: Login with unregistred username and password
    Given  I am on Login form
    And I enter unregistered email address and any password
    And click on login button
    When Modal error is displayed
    Then click on Ok button
    And I should see the login form again


  Scenario: Login with blank username and password
    Given I am on Login form
    When click on login button
    Then username and password fields are highlighted
    And username and password fields contain error message



