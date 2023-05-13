Feature: Luma Login Feature

  Background: Login Background Steps
    Given user is on the home page
    When user clicks on sign in link

  Scenario: Successful login
    When user enters a valid username "kevin.lee@gmail.com"
    And user enters a valid password "Kevin123"
    And user clicks on the sign in button
    Then user should be logged in successfully

  Scenario: Invalid credentials
    When user enters a valid username "kevin.lee@gmail.com"
    And user enters an invalid password "KevinIncorrect"
    And user clicks on the sign in button
    Then user should see an error message