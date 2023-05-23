package com.java_parabank_demo.Pages.Account_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateContactInfo {

    // Add page locators and methods
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"customer.firstName\"]")
    WebElement firstName;
    @FindBy(xpath = "//*[@id=\"customer.lastName\"]")
    WebElement lastName;
    @FindBy(xpath = "//*[@id=\"customer.address.street\"]")
    WebElement address;
    @FindBy(xpath = "//*[@id=\"customer.address.city\"]")
    WebElement city;
    @FindBy(xpath = "//*[@id=\"customer.address.state\"]")
    WebElement state;
    @FindBy(xpath = "//*[@id=\"customer.address.zipCode\"]")
    WebElement zipCode;
    @FindBy(xpath = "//*[@id=\"customer.phoneNumber\"]")
    WebElement phone;
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div/form/table/tbody/tr[8]/td[2]/input")
    WebElement updateProfileButton;
    public By updateProfileTitle = By.className("title");
    public By afterUpdateProfileTitle = By.xpath("//*[@id=\"rightPanel\"]/div/div/h1");
    public By title = By.className("title");
    public UpdateContactInfo(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    public void goToUpdateContactInfo(){
        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[6]/a")).click();
    }
    public void updateProfile(String firstName, String lastName, String address, String city, String state, String zipCode, String phone){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.address.sendKeys(address);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zipCode.sendKeys(zipCode);
        this.phone.sendKeys(phone);
        this.updateProfileButton.click();
    }
}
