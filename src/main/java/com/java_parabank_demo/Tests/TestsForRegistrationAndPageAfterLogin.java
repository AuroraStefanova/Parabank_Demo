package com.java_parabank_demo.Tests;
import com.java_parabank_demo.BrowserFactory.BrowserFactory;
import com.java_parabank_demo.Pages.Account_Services.*;
import com.java_parabank_demo.Pages.Home_Page.RegisterPage;
import com.java_parabank_demo.helpers.RandomGenerator;
import org.openqa.selenium.By;
import com.java_parabank_demo.helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestsForRegistrationAndPageAfterLogin {
    private static String typeOfTheBrowser = "Chrome";
    static WebDriver driver = BrowserFactory.getBrowser(typeOfTheBrowser);;
    private static String customerLoginUrl = "https://parabank.parasoft.com/parabank/index.htm";
    static String message;
    static String currentURL;
    static RegisterPage registerPage = new RegisterPage(driver);
    static BillPayPage billPayPage = new BillPayPage(driver);
    static AccountsOverview accountsOverview = new AccountsOverview(driver);
    static OpenNewAccount openNewAccount = new OpenNewAccount(driver);
    static RequestLoan requestLoan = new RequestLoan(driver);
    static TransferFunds transferFunds = new TransferFunds(driver);
    static UpdateContactInfo updateContactInfo = new UpdateContactInfo(driver);
    static Waits customWait = new Waits();
    static RandomGenerator randomGenerator = new RandomGenerator();

    @Test(priority = 1)
    public static void successfulRegistration(){
        driver.get(customerLoginUrl);

        customWait.customWait(driver,Duration.ofSeconds(10),"visibilityOfElementLocated", registerPage.parabankLogo);

        registerPage.clickRegistrationLink();

        customWait.customWait(driver,Duration.ofSeconds(5),"visibilityOfElementLocated", registerPage.title);

        //String title = driver.findElement(By.className("title")).getText();
        String title = driver.findElement(registerPage.titleRegister).getText();//
        Assert.assertEquals("Signing up is easy!",title);

        registerPage.registrationUser("Zori", "Stefanova","Bulgaria, Varna", "Varna",
                "Varna","12555", "0888542554", "123", randomGenerator.GetRandom(), "test123", "test123");

       message = driver.findElement(registerPage.elementAfterRegister).getText();
       Assert.assertEquals( "Your account was created successfully. You are now logged in.", message);
    }
    @Test(priority = 2)
    public static void updateContactInfo(){
        updateContactInfo.goToUpdateContactInfo();

        customWait.customWait(driver,Duration.ofSeconds(5), "visibilityOfElementLocated",updateContactInfo.updateProfileTitle);

        message = driver.findElement(updateContactInfo.title).getText();
        Assert.assertEquals("Update Profile", message);

        updateContactInfo.updateProfile(randomGenerator.GetRandom(), randomGenerator.GetRandom(),"Bulgaria, Gabrovo", "Gabrovo","Gabrovo", "145558","054884");

        customWait.customWait(driver,Duration.ofSeconds(5), "visibilityOfElementLocated",updateContactInfo.updateProfileTitle);

        message = driver.findElement(updateContactInfo.afterUpdateProfileTitle).getText();
        Assert.assertEquals("Update Profile", message);
    }
    @Test(priority = 3)
    public static void billPayCorrectly(){
        billPayPage.GoToTheAccountsOverviewForm();

        customWait.customWait(driver,Duration.ofSeconds(5),"visibilityOfElementLocated",billPayPage.bilPayTitle);

        message = driver.findElement(billPayPage.billPaymentServiceTitle).getText();
        Assert.assertEquals("Bill Payment Service", message);

        billPayPage.EnterPayeeInformationAndClickSendPaymentButton("Gosho", "Vidin","Vidin", "Vidin", "141", "02545", "15120","15120", "500");

        customWait.customWait(driver,Duration.ofSeconds(5),"visibilityOfElementLocated",billPayPage.bilPayComplete);

        message = driver.findElement(billPayPage.afterPaymentTitle).getText();
        Assert.assertNotEquals("Bill Payment Service", message);
    }
    @Test(priority = 4)
    public static void requestLoanFromFirstAccount(){
        requestLoan.GoToTheRequestLoanForm();

        customWait.customWait(driver,Duration.ofSeconds(5),"visibilityOfElementLocated",requestLoan.applyForLoanTitle);

        message = driver.findElement(requestLoan.applyForLoanTitle).getText();
        Assert.assertEquals("Apply for a Loan", message);

        requestLoan.EnterCredentialsAndApplyForLoanFromFirstAccount("500", "1000");

        customWait.customWait(driver,Duration.ofSeconds(5),"visibilityOfElementLocated",requestLoan.loanProvider);

        message = driver.findElement(requestLoan.applyForLoanTitle).getText();
        Assert.assertEquals("Loan Request Processed", message);
    }
    @Test(priority = 5)
    public static void requestLoanFromSecondAccount(){
        requestLoan.GoToTheRequestLoanForm();

        customWait.customWait(driver,Duration.ofSeconds(5),"visibilityOfElementLocated",requestLoan.applyForLoanTitle);

        message = driver.findElement(requestLoan.applyForLoanTitle).getText();
        Assert.assertEquals("Apply for a Loan", message);

        requestLoan.EnterCredentialsAndApplyForLoanFromSecondAccount("200", "100");

        message = driver.findElement(requestLoan.applyForLoanTitle).getText();
        Assert.assertNotEquals("Loan Request Processed", message);
    }
    @Test(priority = 6)
    public static void transferFundsFromFirstToSecondAccount(){
        transferFunds.OpenTransferFunds();

        customWait.customWait(driver,Duration.ofSeconds(5),"visibilityOfElementLocated",transferFunds.transferFundsTitle);

        message = driver.findElement(transferFunds.transferFundsTitle).getText();
        Assert.assertEquals("Transfer Funds", message);

       driver.navigate().to(driver.getCurrentUrl());

        transferFunds.transferFromFirstAccountToSecondAccount("200");

        customWait.customWait(driver,Duration.ofSeconds(5),"visibilityOfElementLocated",transferFunds.transferFundsTitle);

        message = driver.findElement(transferFunds.transferFundsTitle).getText();
        Assert.assertEquals("Transfer Complete!", message);
    }
    @Test(priority = 7)
    public static void transferFundsFromSecondToFirstAccount(){
        transferFunds.OpenTransferFunds();

        customWait.customWait(driver,Duration.ofSeconds(5),"visibilityOfElementLocated",transferFunds.transferFundsTitle);

        message = driver.findElement(transferFunds.transferFundsTitle).getText();
        Assert.assertEquals("Transfer Funds", message);

        driver.navigate().to(driver.getCurrentUrl());

        transferFunds.transferFromSecondAccountToFirstAccount("300");

        message = driver.findElement(transferFunds.transferFundsTitle).getText();
        Assert.assertEquals("Transfer Complete!", message);
    }
    @Test(priority = 8)
    public static void openNewSavingAccount(){
        openNewAccount.GoToTheOpenNewAccountForm();

        message = driver.findElement(openNewAccount.openAccountFirstTitle).getText();
        Assert.assertEquals("Open New Account", message);

        openNewAccount.OpenNewSavingsAccountAndDepositFromFirstAccount();

        customWait.customWait(driver,Duration.ofSeconds(5),"visibilityOfElementLocated",openNewAccount.openNewAccountTitle);

        message = driver.findElement(openNewAccount.congratulationsForNewOpenAccount).getText();
        Assert.assertNotEquals("Congratulations, your account is now open.", message);
    }
    @Test(priority = 9)//
    public static void openNewCheckingAccount(){
        openNewAccount.GoToTheOpenNewAccountForm();

        customWait.customWait(driver,Duration.ofSeconds(5),"visibilityOfElementLocated",openNewAccount.openAccountFirstTitle);

        message = driver.findElement(openNewAccount.openAccountFirstTitle).getText();
        Assert.assertEquals("Open New Account", message);

        openNewAccount.OpenNewCheckingAccountAndDepositFromFirstAccount();

        customWait.customWait(driver,Duration.ofSeconds(5),"visibilityOfElementLocated",openNewAccount.openNewAccountTitle);

        message = driver.findElement(openNewAccount.congratulationsForNewOpenAccount).getText();
        Assert.assertNotEquals("Congratulations, your account is now open.", message);
    }
    @Test(priority = 10)
    public static void accountOverview(){
        accountsOverview.GoToTheAccountsOverviewForm();

        customWait.customWait(driver,Duration.ofSeconds(5),"visibilityOfElementLocated",accountsOverview.accountOverviewTitle);

        message = driver.findElement(accountsOverview.accountOverviewTitle).getText();
        Assert.assertEquals("Accounts Overview", message);

        accountsOverview.accountOverview();

        customWait.customWait(driver,Duration.ofSeconds(5),"visibilityOfElementLocated",accountsOverview.overviewAccountTitle);

        message = driver.findElement(accountsOverview.overviewAccountTitle).getText();
        Assert.assertNotEquals("Account Activity", message);
        driver.close();
    }
}
