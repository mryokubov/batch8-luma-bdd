package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
    }

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Sign In")
    protected WebElement signInLink;

    @FindBy(how = How.CLASS_NAME, using = "logged-in")
    protected WebElement signInWelcomeMsg;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Create an Account")
    protected WebElement createAccountLink;

    @FindBy(how = How.ID, using = "newsletter")
    protected WebElement subscribeInputBox;

    @FindBy(xpath = "//button[@title='Subscribe']")
    protected WebElement subscribeBtn;

    @FindBy(xpath = "//div[@data-ui-id='message-success']/div")
    protected WebElement subscribeSuccessMsg;

    public void verifyTitle(){
        wait.until(ExpectedConditions.titleIs("Home Page"));
        Assert.assertTrue(driver.getTitle().equals("Home Page"));
    }


    public void clickSignInLink(){
        signInLink.click();
    }

    public void verifyLoggedInMsg(){
        Assert.assertTrue(signInWelcomeMsg.isDisplayed());
    }

    public void clickCreateAccountLink(){
        Assert.assertTrue("Create account link is not displayed", createAccountLink.isDisplayed());
        createAccountLink.click();
    }

    public void enterEmailInSubscribeInputBox(String email){
        subscribeInputBox.sendKeys(email);
    }

    public void subscribe(){
        Assert.assertTrue("Subscribe btn is not enabled", subscribeBtn.isEnabled());
        subscribeBtn.click();
    }

    public void verifySubscribeSuccessMsg(String message){
        wait.until(ExpectedConditions.visibilityOf(subscribeSuccessMsg));
        String subscribeMsg = subscribeSuccessMsg.getText().trim();
        Assert.assertEquals("Messages do not match", message, subscribeMsg);
    }
}
