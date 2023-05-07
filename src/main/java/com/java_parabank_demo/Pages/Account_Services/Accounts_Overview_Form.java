package com.java_parabank_demo.Pages.Account_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Accounts_Overview_Form {
    WebDriver driver;

    // Add locators for page elements i.e. account num, account balance, available amount, total

    public Accounts_Overview_Form (WebDriver driver) {this.driver = driver;}
    By accountsOverviewButton = By.linkText("Accounts Overview");

    public void GoToTheAccountsOverviewForm(){
        driver.findElement(accountsOverviewButton).click();
        // Accounts Overview Form is displayed with all of the user's accounts and his Balance and Available Amount
    }
}
