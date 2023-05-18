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

public class MyAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
    }


    @FindBy(how = How.CLASS_NAME, using = "page-title")
    protected WebElement myAccountHeader;


    public void verifyMyAccountHeader(){
        Assert.assertTrue(myAccountHeader.isDisplayed());
    }


    public void verifyTitle() {
        wait.until(ExpectedConditions.titleIs("My Account"));
        Assert.assertTrue("Titles do not match", driver.getTitle().equals("My Account"));
    }
}
