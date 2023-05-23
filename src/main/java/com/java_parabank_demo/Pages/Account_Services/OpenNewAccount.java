package com.java_parabank_demo.Pages.Account_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenNewAccount {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"type\"]/option[1]")
    WebElement selectCheckingAccount;
    @FindBy(xpath = "//*[@id=\"type\"]/option[2]")
    WebElement selectSavingsAccount;
    @FindBy(xpath = "//*[@id=\"fromAccountId\"]/option[1]")
    WebElement selectTheFirstAccount;
    @FindBy(css = ".button[value=\"Open New Account\"]")
    WebElement openNewAccountButton;
    public By openNewAccountTitle = By.xpath("//*[@id=\"rightPanel\"]/div/div/h1");
    public By openAccountFirstTitle = By.className("title");
    public By congratulationsForNewOpenAccount = By.xpath("//*[@id=\"rightPanel\"]/div/div/h1");
    public OpenNewAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    public void GoToTheOpenNewAccountForm(){

        driver.findElement(By.linkText("Open New Account")).click();
    }
    public void OpenNewCheckingAccountAndDepositFromFirstAccount(){
        this.selectCheckingAccount.click();
        this.selectTheFirstAccount.click();
        this.openNewAccountButton.click();
    }
    public void OpenNewSavingsAccountAndDepositFromFirstAccount(){
        this.selectSavingsAccount.click();
        this.selectTheFirstAccount.click();
        this.openNewAccountButton.click();
    }
}
