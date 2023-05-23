package com.java_parabank_demo.Pages.Account_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPayPage {
    WebDriver driver;
   //@FindBy(linkText = "Bill Pay")
   //WebElement billPayLink;
    @FindBy(name = "payee.name")
    WebElement payeeName;
    @FindBy(name = "payee.address.street")
    WebElement address;
    @FindBy(name = "payee.address.city")
    WebElement city;
    @FindBy(name = "payee.address.state")
    WebElement state;
    @FindBy(name = "payee.address.zipCode")
    WebElement zipCode;
    @FindBy(name = "payee.phoneNumber")
    WebElement phone;
    @FindBy(name = "payee.accountNumber")
    WebElement account;
    @FindBy(name = "verifyAccount")
    WebElement verifyAccount;
    @FindBy(name = "amount")
    WebElement amount;
    @FindBy(name = "fromAccountId")
    WebElement fromAccountId;
    @FindBy(css = ".button[type='submit']")
    WebElement sendPaymentButton;
    public By bilPayTitle = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1");
    public By bilPayComplete = By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/h1");
    public By billPaymentServiceTitle = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1");
    public By afterPaymentTitle = By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/h1");
    public BillPayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    public void GoToTheAccountsOverviewForm(){
        driver.findElement(By.linkText("Bill Pay")).click();
    }
    public void EnterPayeeInformationAndClickSendPaymentButton(String payeeName, String address, String city, String state, String zipcode, String phone, String account, String verifyAccount, String amount){
       this.payeeName.sendKeys(payeeName);
       this.address.sendKeys(address);
       this.city.sendKeys(city);
       this.state.sendKeys(state);
       this.zipCode.sendKeys(zipcode);
       this.phone.sendKeys(phone);
       this.account.sendKeys(account);
       this.verifyAccount.sendKeys(verifyAccount);
       this.amount.sendKeys(amount);
       this.sendPaymentButton.click();
    }
}
