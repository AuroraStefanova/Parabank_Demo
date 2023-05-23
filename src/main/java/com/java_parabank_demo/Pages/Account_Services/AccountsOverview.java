package com.java_parabank_demo.Pages.Account_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsOverview {
    WebDriver driver;
   // @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[2]/a")
   // WebElement accountOverviewLink;
    @FindBy(xpath = "//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]")////*[@id="accountTable"]/tbody/tr[1]/td[1]/a
    WebElement accountLink;
    By accountsOverviewButton = By.linkText("Accounts Overview");
    public By accountOverviewTitle = By.className("title");
    public By overviewAccountTitle = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1");

    public AccountsOverview(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void GoToTheAccountsOverviewForm(){
        driver.findElement(accountsOverviewButton).click();
    }
    public void accountOverview(){
        this.accountLink.click();
    }
}
