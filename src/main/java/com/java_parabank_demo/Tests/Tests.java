package com.java_parabank_demo.Tests;

import com.java_parabank_demo.BrowserFactory.BrowserFactory;
import com.java_parabank_demo.Pages.Home_Page.ForgetLoginInfo;
import com.java_parabank_demo.Pages.Home_Page.LoginPage;
import com.java_parabank_demo.Pages.Home_Page.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.concurrent.TimeUnit;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class Tests {
    private static String typeOfTheBrowser = "Chrome";
    static WebDriver driver = BrowserFactory.getBrowser(typeOfTheBrowser);;
    private static String customerLoginUrl = "https://parabank.parasoft.com/parabank/index.htm";
    static LoginPage loginPage = new LoginPage(driver);
    static ForgetLoginInfo forgetLoginInfo = new ForgetLoginInfo(driver);
    static RegisterPage registerPage = new RegisterPage(driver);
    static String errorMessage;
    static String currentURL;
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    //@BeforeAll
//public static void OpenTheWebsite(){
//    driver = BrowserFactory.getBrowser(typeOfTheBrowser);
//    driver.manage().window().maximize();
//    loginPage = new LoginPage(driver);
//    registerPage = new RegisterPage(driver);
//    forgetLoginInfo = new ForgetLoginInfo(driver);
//}
//@AfterAll
//public static void closeBrowser(){
//    BrowserFactory.closeBrowser();
//}
    @Test
    @Order(1)
    public static void unsuccessfulRegistration(){
        driver.get(customerLoginUrl);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logo")));

        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

        String title = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Signing up is easy!",title);

        registerPage.unsuccessfulRegistration("Pesho","Petrov", "Bulgaria, Karlovo 12","Karlovo","Karlovo",
                "14454","0702545", "Pesho","Pesho1234","Pesho1234");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customer.ssn.errors\"]")));

        errorMessage = driver.findElement(By.xpath("//*[@id=\"customer.ssn.errors\"]")).getText();
        Assert.assertEquals("Social Security Number is required.", errorMessage);
    }
    @Test
    @Order(2)
    public static void successfulRegistration(){
        driver.get(customerLoginUrl);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"topPanel\"]/a[2]/img")));

        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

        String title = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Signing up is easy!",title);

         registerPage.registrationUser("Zori", "Stefanova","Bulgaria, Varna", "Varna",
                 "Varna","12555", "0888542554", "123", "Zori1234567", "test1234567", "test1234567");

         currentURL = driver.getCurrentUrl();
         Assert.assertEquals( "https://parabank.parasoft.com/parabank/register.htm", currentURL);
    }
    @Test
    @Order(3)
    public static void unsuccessfulForgetLoginInfo(){
        driver.get(customerLoginUrl);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"topPanel\"]/a[2]/img")));

        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[1]/a")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

        currentURL = driver.getCurrentUrl();
        Assert.assertNotEquals( "https://parabank.parasoft.com/parabank/register.htm", currentURL);

        forgetLoginInfo.incorrectForgetLogin("Zonitsa", "Bulgaria, Gabrovo 12","Gabrovo","Gabrovo","123","52525");

        errorMessage = driver.findElement(By.xpath("//*[@id=\"firstName.errors\"]")).getText();
        Assert.assertEquals("First name is required.",errorMessage);
    }

    @Test
    @Order(4)
    public static void forgetLoginInfoSuccess(){
        driver.get(customerLoginUrl);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"topPanel\"]/a[2]/img")));

        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[1]/a")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"lookupForm\"]/table/tbody/tr[8]/td[2]/input")));

        currentURL = driver.getCurrentUrl();
        Assert.assertNotEquals( "https://parabank.parasoft.com/parabank/lookup.htm", currentURL);

        forgetLoginInfo.forgetLogin("Zonitsa","Stefanova", "Bulgaria, Varna", "Varna","Varna","12555","123");

        currentURL = driver.getCurrentUrl();
        Assert.assertEquals("https://parabank.parasoft.com/parabank/lookup.htm",currentURL);
    }
    @Test
    @Order(5)
    public static void unsuccessfulLogin(){
        driver.get(customerLoginUrl);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logo")));

        loginPage.loginPage("Zori1234", "est1234");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error")));

        errorMessage = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p")).getText();//.error
        Assert.assertNotEquals("An internal error has occurred and has been logged.", errorMessage);
    }
    @Test
    @Order(6)
    public void notEnteredCredentialsForLogin(){
        driver.get(customerLoginUrl);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")));

        loginPage.forgetToEnterCredentials("Zori1234");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/p")));

        errorMessage = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p")).getText();
        Assert.assertEquals("Please enter a username and password.", errorMessage);

        currentURL = driver.getCurrentUrl();
        Assert.assertNotEquals("https://parabank.parasoft.com/parabank/overview.htm", currentURL);
    }
    @Test
    @Order(7)
    public void successLogin(){
        driver.get(customerLoginUrl);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")));

        loginPage.loginPage("Zori123456", "test123456");

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        currentURL = driver.getCurrentUrl();
        Assert.assertEquals("https://parabank.parasoft.com/parabank/register.htm", currentURL);
    }
}
