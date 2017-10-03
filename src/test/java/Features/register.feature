Feature: RegistrationFeature

#  Scenario: Open register form
#    Given I am on main page
#    Then click on profile icon
#    And click on Register button
#    Then I can see register form

    Background:
    Given I am on Registration form

    Scenario: Register new user with valid data
        Then Select Gender
        And Enter valid First Name
        And Enter valid Last Name
        And Enter valid Email
        And Enter  valid phone number
        And Enter valid password
        And Enter password confirmation
        And Accept Terms
        And click on Register button




