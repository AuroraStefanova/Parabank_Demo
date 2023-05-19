package com.java_parabank_demo.Pages.Account_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestLoan {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"amount\"]")// id #amount
    WebElement loanAmount;
    @FindBy(xpath = "//*[@id=\"downPayment\"]")// id #downPayment
    WebElement downPayment;
    @FindBy(xpath = "//*[@id=\"fromAccountId\"]")//id #fromAccountId
    WebElement fromAccount;
    @FindBy(css = ".button[value=\"Apply Now\"]")
    WebElement applyNowButton;
    @FindBy(xpath = "//*[@id='fromAccountId']/option[1]")
    WebElement fromAccountDropMenuFirstAccount;
    @FindBy(xpath = "//*[@id='fromAccountId']/option[2]")
    WebElement fromAccountDropMenuSecondAccount;
    public RequestLoan(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    public void GoToTheRequestLoanForm(){
        driver.findElement(By.linkText("Request Loan")).click();
    }
    public void EnterCredentialsAndApplyForLoanFromFirstAccount(String loanAmount, String downPayment){
        this.loanAmount.sendKeys(loanAmount);
        this.downPayment.sendKeys(downPayment);
        this.fromAccountDropMenuFirstAccount.click();//
        this.applyNowButton.click();
    }
    public void EnterCredentialsAndApplyForLoanFromSecondAccount(String loanAmount, String downPayment){
        this.loanAmount.sendKeys(loanAmount);
        this.downPayment.sendKeys(downPayment);
        this.fromAccountDropMenuSecondAccount.click();
        this.applyNowButton.click();
    }
}
