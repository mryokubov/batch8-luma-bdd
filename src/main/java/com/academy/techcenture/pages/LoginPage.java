package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends HomePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "email")
    protected WebElement emailInput;

    @FindBy(how = How.ID, using = "pass")
    protected WebElement passwordInput;

    @FindBy(how = How.ID, using = "send2")
    protected WebElement signInBtn;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'The account sign-in was incorrect')]")
    protected WebElement signInError;

    public void verifyTitle(){
        wait.until(ExpectedConditions.titleIs("Customer Login"));
        Assert.assertTrue(driver.getTitle().equals("Customer Login"));
    }

    public void enterUserName(String username){
        emailInput.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickSignInBtn(){
        Assert.assertTrue("Sign in button is not enabled", signInBtn.isEnabled());
        signInBtn.click();
    }

    public void verifySignInError(String errorMsg){
        Assert.assertTrue("Sign in error was not displayed", signInError.isDisplayed());
        Assert.assertTrue("Error message is not correct", signInError.getText().trim().equals(errorMsg));
    }

}
