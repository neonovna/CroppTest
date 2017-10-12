Feature: RegistrationFeature

  Background:
    Given I am on Registration form

  Scenario: Register new user with valid data
    When I enter valid data
      | FirstName   | TestFirstName |
      | LastName    | TestLastName  |
      | Email       | test@test1.com |
      | Telephone   | 222222222     |
      | Password    | testtest      |
      | PassConfirm | testtest      |
    And Select Gender
    And Accept Terms
    And Click on Register button
    Then Thanks Popup is displayed
    When click on Ok button
    Then I should see Account page










