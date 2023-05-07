package com.java_parabank_demo.Pages.Account_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Open_New_Account_Form {
    WebDriver driver;
    public Open_New_Account_Form (WebDriver driver) {this.driver = driver;}

    By openNewAccountButton = By.linkText("Open New Account");
    By accountTypeDropMenuLocator = By.id("type");
    By selectAccountDropMenuLocator = By.id("fromAccountId");
    By openNewAccountSubmitButton = By.cssSelector("button[type='submit']");
    By selectCheckingAccount = By.xpath("//*[@id='type']/option[1]");
    By selectSavingsAccount = By.xpath("//*[@id='type']/option[2]");
    By selectTheFirstAccount = By.xpath("//*[@id='fromAccountId']/option[1]");
    By selectTheSecondAccount = By.xpath("//*[@id='fromAccountId']/option[2]");

    public void GoToTheOpenNewAccountForm(){
        driver.findElement(openNewAccountButton).click();
        // Open New Account Form is displayed
    }

    public void OpenNewCheckingAccountAndDepositFromSecondAccount(){
        driver.findElement(accountTypeDropMenuLocator).click();
        driver.findElement(selectCheckingAccount).click();

        driver.findElement(selectAccountDropMenuLocator).click();
        driver.findElement(selectTheSecondAccount).click();

        driver.findElement(openNewAccountButton).click();
    }

    public void OpenNewSavingsAccountAndDepositFromFirstAccount(){
        driver.findElement(accountTypeDropMenuLocator).click();
        driver.findElement(selectSavingsAccount).click();

        driver.findElement(selectAccountDropMenuLocator).click();
        driver.findElement(selectTheFirstAccount).click();

        driver.findElement(openNewAccountSubmitButton).click();
    }

}
