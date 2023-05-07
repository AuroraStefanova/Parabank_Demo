package com.java_parabank_demo.Pages.Home_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetLoginInfo {
    WebDriver driver;
    @FindBy(css = "#firstName")
    WebElement firstName;
    @FindBy(css = "#lastName")
    WebElement lastName;
    @FindBy(css = "#address\\.street")
    WebElement address;
    @FindBy(css = "#address\\.city")
    WebElement city;
    @FindBy(css = "#address\\.state")
    WebElement state;
    @FindBy(css = "#address\\.zipCode")
    WebElement zipCode;
    @FindBy(css = "#ssn")
    WebElement ssn;
    @FindBy(xpath = "//*[@id=\"lookupForm\"]/table/tbody/tr[8]/td[2]/input")
    WebElement findMyLoginInfo;

    public ForgetLoginInfo(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    public void forgetLogin(String firstName, String lastName, String address, String city, String state, String zipCode, String ssn){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.address.sendKeys(address);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zipCode.sendKeys(zipCode);
        this.ssn.sendKeys(ssn);
        this.findMyLoginInfo.click();
    }
    public void incorrectForgetLogin(String lastName, String address, String city, String state, String zipCode, String ssn){
        this.lastName.sendKeys(lastName);
        this.address.sendKeys(address);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zipCode.sendKeys(zipCode);
        this.ssn.sendKeys(ssn);
        this.findMyLoginInfo.click();
    }
}
