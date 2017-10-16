Feature: RegistrationFeature

  Background:
    Given I am on Main page

  Scenario: Check if search is opened
    When I click on Search icon
    Then Search input is opened

  Scenario Outline: Search for specific item
    When I click on Search icon
    And enter <value> in search box
    And I submit search
    And search result with <value> is displayed
    Examples:
      | value  |
      | cap    |
      | tshirt |




