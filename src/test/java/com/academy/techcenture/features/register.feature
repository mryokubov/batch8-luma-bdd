@regression
Feature: Luma User Registration Feature

  Scenario Outline: Create a new account on Luma website
    Given user is on the homepage
    When user clicks on create account link on top right
    Then user should be navigated to create account page
    And user enters "<first_name>" in the firstname input
    And user enters "<last_name>" in the lastname input
    And user checks "<news_letter>" checkbox
    And user enters "<email>" in the email input
    And user enters "<password>" in the password input
    And user enters "<confirm_password>" in the confirm_password input
    When user clicks on the create account button
    Then user should be registered successful and be navigated to my account page

    Examples:
    |first_name | last_name |news_letter   | email                 | password     | confirm_password  |
    |Bob        | Peterson  |    yes       |bob.f34dfq45@yahoo.com   | Bob.pete123! | Bob.pete123!      |
#    |Bob        | Peterson  |    yes       |bob.abcd130@yahoo.com   | Bob.pete123! | Bob.pete123!      |
#    |Bob        | Peterson  |    yes       |bob.abcd140@yahoo.com   | Bob.pete123! | Bob.pete123!      |

#    @smoke
    Examples:
    |first_name | last_name |news_letter   | email                 | password     | confirm_password  |
    |Bob        | Peterson  |    yes       |bob.abcddsfdaf@yahoo.com   | Bob.pete123! | Bob.pete123!      |
