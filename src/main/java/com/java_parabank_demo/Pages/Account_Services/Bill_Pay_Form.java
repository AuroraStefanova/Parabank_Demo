package com.java_parabank_demo.Pages.Account_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Bill_Pay_Form {
    WebDriver driver;
    public Bill_Pay_Form (WebDriver driver) {this.driver = driver;}

    By billPayButton = By.linkText("Bill Pay");
    By payeeNameFieldLocator = By.name("payee.name");
    By addressFieldLocator = By.name("payee.address.street");
    By cityFieldLocator = By.name("payee.address.city");
    By stateFieldLocator = By.name("payee.address.state");
    By zipCodeFieldLocator = By.name("payee.address.zipCode");
    By phoneFieldLocator = By.name("payee.phoneNumber");
    By accountFieldLocator = By.name("payee.accountNumber");
    By verifyAccountFieldLocator = By.name("verifyAccount");
    By amountFieldLocator = By.name("amount");
    By fromAccountDropMenuLocator = By.name("fromAccountId");
    By sendPaymentSubmitButton = By.cssSelector("button[type='submit']");

    public void GoToTheAccountsOverviewForm(){
        driver.findElement(billPayButton).click();
        // Accounts Overview Form is displayed with all of the user's accounts and his Balance and Available Amount
    }

    public void EnterPayeeInformationAndClickSendPaymentButton(){
        driver.findElement(payeeNameFieldLocator).click();
        driver.findElement(payeeNameFieldLocator).sendKeys();

        driver.findElement(addressFieldLocator).click();
        driver.findElement(addressFieldLocator).sendKeys();

        driver.findElement(cityFieldLocator).click();
        driver.findElement(cityFieldLocator).sendKeys();

        driver.findElement(stateFieldLocator).click();
        driver.findElement(stateFieldLocator).sendKeys();

        driver.findElement(zipCodeFieldLocator).click();
        driver.findElement(zipCodeFieldLocator).sendKeys();

        driver.findElement(phoneFieldLocator).click();
        driver.findElement(phoneFieldLocator).sendKeys();

        driver.findElement(accountFieldLocator).click();
        driver.findElement(accountFieldLocator).sendKeys();

        driver.findElement(verifyAccountFieldLocator).click();
        driver.findElement(verifyAccountFieldLocator).sendKeys();

        driver.findElement(amountFieldLocator).click();
        driver.findElement(amountFieldLocator).sendKeys();

        driver.findElement(fromAccountDropMenuLocator).click();
        // TO DO!!!!

        driver.findElement(sendPaymentSubmitButton).click();
    }
}
