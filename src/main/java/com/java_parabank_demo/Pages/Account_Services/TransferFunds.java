package com.java_parabank_demo.Pages.Account_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFunds {
    WebDriver driver;
    @FindBy(css = "#amount")
    WebElement amount;
    @FindBy(css = "[type=\"submit\"]")
    WebElement transferButton;
    @FindBy(xpath = "//*[@id=\"fromAccountId\"]/option[1]")
    WebElement fromAccountOne;
    @FindBy(xpath = "//*[@id=\"fromAccountId\"]/option[2]")
    WebElement fromAccountTwo;
    @FindBy(xpath = "//*[@id=\"toAccountId\"]/option[1]")
    WebElement toAccountOne;
    @FindBy(xpath = "//*[@id=\"toAccountId\"]/option[2]")
    WebElement toAccountTwo;
    public By transferFundsTitle = By.className("title");
    public TransferFunds(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    public void OpenTransferFunds(){
        driver.findElement(By.linkText("Transfer Funds")).click();
    }
    public void transferFromFirstAccountToSecondAccount(String amount){
        this.amount.sendKeys(amount);
        this.fromAccountOne.click();
        this.toAccountTwo.click();
        this.transferButton.click();
    }
    public void transferFromSecondAccountToFirstAccount(String amount){
        this.amount.sendKeys(amount);
        this.fromAccountTwo.click();
        this.toAccountOne.click();
        this.transferButton.click();
    }
}
