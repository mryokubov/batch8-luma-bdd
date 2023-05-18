Feature: Luma Login Feature

  Background: Login Background Steps
    Given user is on the home page
    When user clicks on sign in link

  @regression
  Scenario: Successful login
    When user enters a valid username "kevin.lee@gmail.com"
    And user enters a valid password "Kevin123"
    And user clicks on the sign in button
    Then user should be logged in successfully

  @regression
  Scenario: Invalid credentials
    When user enters a valid username "kevin.lee@gmail.com"
    And user enters an invalid password "KevinIncorrect"
    And user clicks on the sign in button
    Then user should see an error message "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."