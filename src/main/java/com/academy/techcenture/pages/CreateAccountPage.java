package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends HomePage{

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstname")
    protected WebElement firstNameInput;

    @FindBy(id = "lastname")
    protected WebElement lastNameInput;

    @FindBy(id = "is_subscribed")
    protected WebElement signUpForNewsLettersCheckBox;

    @FindBy(id = "email_address")
    protected WebElement emailAddressInput;

    @FindBy(id = "password")
    protected WebElement passwordInput;

    @FindBy(id = "password-confirmation")
    protected WebElement cofirmPasswordInput;

    @FindBy(xpath = "//button[@title='Create an Account']")
    protected WebElement createAccountBtn;


    public void enterFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }

    public void checkNewsLetterBox(String checkBox){
        if (checkBox.equals("yes")){
            if (!signUpForNewsLettersCheckBox.isSelected()){
                signUpForNewsLettersCheckBox.click();
            }
        }
        else if(checkBox.equals("no")){
            if (signUpForNewsLettersCheckBox.isSelected()){
                signUpForNewsLettersCheckBox.click();
            }
        }
    }

    public void enterEmailAddress(String email) {
        emailAddressInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        cofirmPasswordInput.sendKeys(password);
    }

    public void createAccount() {
        Assert.assertTrue(createAccountBtn.isEnabled());
        createAccountBtn.click();
    }
}
