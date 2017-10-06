Feature: LoginFeature

  Background:
    Given I am on Login form

  Scenario: Login with valid username and password
    And I enter registered credentials
      | 0temporarymail0@gmail.com | kokoko |
    And click on login button
    Then I should see Account page
    When hover over profile icon
    And click on Logout button
    Then I should see logout page
    When five second pass
    Then I should see the main page


  Scenario Outline: Login with invalid username and password
    And I enter invalid <Username> or <Password>
    And click on login button
    When Modal error is displayed
    Then click on Ok button
    And I should see the login form again
    Examples:
      | Username                  | Password |
      | unregistered@gmail.com    | kokokoko |
      | 0temporarymail0@gmail.com | kokololo |
      | 0temporarymai@gmail.com   | kokoko   |


  @ignore
  Scenario: Login with blank username and password
    When click on login button
    Then username and password fields are highlighted
    And username and password fields contain error message




