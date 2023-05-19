@smoke
Feature: Luma Subscribe Functionality

  Scenario Outline: Subscribe with email
    Given user is on the home page
    And user enters "<email>" address in the subscribe email input box
    When user clicks on the subscribe button
    Then user should see a "Thank you for your subscription." success message

    Examples:
    |email                       |
    | pl.bob50440330@yahoo.com    |
    | pl.bob500551@yahoo.com    |