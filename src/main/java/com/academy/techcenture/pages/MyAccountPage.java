package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }


    @FindBy(how = How.CLASS_NAME, using = "page-title")
    protected WebElement myAccountHeader;


    public void verifyMyAccountHeader(){
        Assert.assertTrue(myAccountHeader.isDisplayed());
    }


    public void verifyTitle() {
        Assert.assertTrue("Titles do not match", driver.getTitle().equals("My Account"));
    }
}
