package com.java_parabank_demo.Pages.Home_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[1]/input")
    WebElement userName;
    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[2]/input")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[3]/input")
    WebElement logIn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    public void loginPage(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.logIn.click();
    }
    public void forgetToEnterCredentials(String username){
        this.userName.sendKeys(username);
        this.logIn.click();
    }
}
