package com.academy.techcenture.step_defs;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class SubscribeStepDefs {

    private WebDriver driver= Driver.getDriver();
    private HomePage homePage;

    @And("user enters {string} address in the subscribe email input box")
    public void userEntersAddressInTheSubscribeEmailInputBox(String email) {
        homePage = new HomePage(driver);
        homePage.verifyTitle();
        homePage.enterEmailInSubscribeInputBox(email);
    }

    @When("user clicks on the subscribe button")
    public void user_clicks_on_the_subscribe_button() {
        homePage.subscribe();
    }

    @Then("user should see a {string} success message")
    public void user_should_see_a_success_message(String message) {
        homePage.verifySubscribeSuccessMsg(message);
    }


}
