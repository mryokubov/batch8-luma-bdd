package com.academy.techcenture.step_defs;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.CreateAccountPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.MyAccountPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class RegisterStepDefs {

    private WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private CreateAccountPage createAccountPage;
    private MyAccountPage myAccountPage;

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        driver.get(ConfigReader.getProperty("url"));
        homePage = new HomePage(driver);
        homePage.verifyTitle();
    }
    @When("user clicks on create account link on top right")
    public void user_clicks_on_create_account_link_on_top_right() {
        homePage.clickCreateAccountLink();
    }

    @Then("user should be navigated to create account page")
    public void user_should_be_navigated_to_create_account_page() {
        createAccountPage = new CreateAccountPage(driver);
        createAccountPage.verifyTitle();
    }

    @Then("user enters {string} in the firstname input")
    public void user_enters_in_the_firstname_input(String firstName) {
        createAccountPage.enterFirstName(firstName);
    }
    @Then("user enters {string} in the lastname input")
    public void user_enters_in_the_lastname_input(String lastName) {
        createAccountPage.enterLastName(lastName);
    }

    @And("user checks {string} checkbox")
    public void userChecksCheckbox(String checkBox) {
        createAccountPage.checkNewsLetterBox(checkBox);
    }
    @Then("user enters {string} in the email input")
    public void user_enters_in_the_email_input(String email) {
        createAccountPage.enterEmailAddress(email);
    }
    @Then("user enters {string} in the password input")
    public void user_enters_in_the_password_input(String password) {
        createAccountPage.enterPassword(password);
    }
    @Then("user enters {string} in the confirm_password input")
    public void user_enters_in_the_confirm_password_input(String password) {
        createAccountPage.enterConfirmPassword(password);
    }
    @When("user clicks on the create account button")
    public void user_clicks_on_the_create_account_button() {
        createAccountPage.createAccount();
    }
    @Then("user should be registered successful and be navigated to my account page")
    public void user_should_be_registered_successful_and_be_navigated_to_my_account_page() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.verifyTitle();
        myAccountPage.verifyMyAccountHeader();
    }

}
