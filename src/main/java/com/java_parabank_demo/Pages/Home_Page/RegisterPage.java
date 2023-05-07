package com.java_parabank_demo.Pages.Home_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;
    @FindBy(css = "#customer\\.firstName")
    WebElement firstName;
    @FindBy(css = "#customer\\.lastName")
    WebElement lastName;
    @FindBy(css = "#customer\\.address\\.street")
    WebElement address;
    @FindBy(css = "#customer\\.address\\.city")
    WebElement city;
    @FindBy(css = "#customer\\.address\\.state")
    WebElement state;
    @FindBy(css = "#customer\\.address\\.zipCode")
    WebElement zipCode;
    @FindBy(css = "#customer\\.phoneNumber")
    WebElement phone;
    @FindBy(css = "#customer\\.ssn")
    WebElement ssn;
    @FindBy(css = "#customer\\.username")
    WebElement userName;
    @FindBy(css = "#customer\\.password")
    WebElement password;
    @FindBy(css = "#repeatedPassword")
    WebElement confirm;
    @FindBy(xpath = "//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")
    WebElement registerButton;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    public void registrationUser(String firstName, String lastName, String address, String city, String state,
                                 String zipCode, String phone, String ssn, String userName, String password, String confirm){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.address.sendKeys(address);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zipCode.sendKeys(zipCode);
        this.phone.sendKeys(phone);
        this.ssn.sendKeys(ssn);
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.confirm.sendKeys(confirm);
        this.registerButton.click();

    }
    public void unsuccessfulRegistration(String firstName, String lastName,String address, String city, String state,
                                         String zipCode, String phone, String userName, String password, String confirm){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.address.sendKeys(address);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zipCode.sendKeys(zipCode);
        this.phone.sendKeys(phone);
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.confirm.sendKeys(confirm);
        this.registerButton.click();
    }

}
