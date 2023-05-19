package com.java_parabank_demo.Pages.Account_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsOverview {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[2]/a")
    WebElement accountOverviewLink;
    @FindBy(xpath = "//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]")////*[@id="accountTable"]/tbody/tr[1]/td[1]/a
    WebElement accountLink;

   // @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input")
   // WebElement goButtonFromAccountActivity;


//TODO Add locators for page elements i.e. account num, account balance, available amount, total

    public AccountsOverview(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    By accountsOverviewButton = By.linkText("Accounts Overview");

    public void GoToTheAccountsOverviewForm(){
        driver.findElement(accountsOverviewButton).click();
    }
    public void accountOverview(){
        this.accountLink.click();
    }
    //TODO  add one transaction click on the account click on the GO button
}
