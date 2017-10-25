Feature: RegistrationFeature

  Background:
    Given I am on Main page

  Scenario: Check if search is opened
    When I click on Search icon
    Then Search input is opened

  Scenario Outline: Search for specific valid item
    When I click on Search icon
    And enter <value> in search box
    And I submit search
    Then search result is displayed
    Examples:
      | value  |
      | cap    |
      | tshirt |





