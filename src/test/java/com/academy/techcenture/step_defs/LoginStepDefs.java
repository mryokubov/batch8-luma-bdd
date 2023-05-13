package com.academy.techcenture.step_defs;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs {

    private HomePage homePage;
    private LoginPage loginPage;
    private WebDriver driver;

    @Given("user is on the home page")
    public void user_is_on_the_login_page() {
        driver.get("https://magento.softwaretestingboard.com/");
        Assert.assertTrue(driver.getTitle().equals("Home Page"));

    }
    @When("user clicks on sign in link")
    public void userClicksOnSignInLink() {
        homePage.clickSignInLink();
        String loginPageTitle = driver.getTitle();
        Assert.assertEquals("Login Page title is not correct","Customer Login", loginPageTitle);
    }
    @When("user enters a valid username {string}")
    public void user_enters_a_valid_username(String username) {
        loginPage.enterUserName(username);
    }

    @When("user enters a valid password {string}")
    public void user_enters_a_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("user clicks on the sign in button")
    public void user_clicks_on_the_sign_in_button() {
        loginPage.clickSignInBtn();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        homePage.verifyLoggedInMsg();
    }

    @When("user enters an invalid password {string}")
    public void user_enters_an_invalid_password(String invalidPass) {
        loginPage.enterPassword(invalidPass);
    }

    @Then("user should see an error message")
    public void user_should_see_an_error_message() {
        loginPage.verifySignInError();
    }

    @Before
    public void setUp(){
        driver = Driver.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

}
