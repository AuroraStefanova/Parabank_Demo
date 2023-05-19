package com.java_parabank_demo.Tests;
import com.java_parabank_demo.BrowserFactory.BrowserFactory;
import com.java_parabank_demo.Pages.Account_Services.*;
import com.java_parabank_demo.Pages.Home_Page.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.UUID;
public class TestsForRegistrationAndPageAfterLogin {
    private static String typeOfTheBrowser = "Chrome";
    static WebDriver driver = BrowserFactory.getBrowser(typeOfTheBrowser);;
    private static String customerLoginUrl = "https://parabank.parasoft.com/parabank/index.htm";
    static String message;
    static String currentURL;
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    static RegisterPage registerPage = new RegisterPage(driver);
    static BillPayPage billPayPage = new BillPayPage(driver);
    static AccountsOverview accountsOverview = new AccountsOverview(driver);
    static OpenNewAccount openNewAccount = new OpenNewAccount(driver);
    static RequestLoan requestLoan = new RequestLoan(driver);
    static TransferFunds transferFunds = new TransferFunds(driver);
    static UpdateContactInfo updateContactInfo = new UpdateContactInfo(driver);
    public static String GetRandom() {
        String random = UUID.randomUUID().toString().replace("-", "");
        return random.substring(0, 6);
    }
    @Test(priority = 1)
    public static void successfulRegistration(){
        driver.get(customerLoginUrl);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"topPanel\"]/a[2]/img")));

        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

        String title = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Signing up is easy!",title);

        registerPage.registrationUser("Zori", "Stefanova","Bulgaria, Varna", "Varna",
                "Varna","12555", "0888542554", "123", GetRandom(), "test123", "test123");

       message = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p")).getText();
       Assert.assertEquals( "Your account was created successfully. You are now logged in.", message);
    }
    @Test(priority = 2)
    public static void updateContactInfo(){
        updateContactInfo.goToUpdateContactInfo();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

        message = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Update Profile", message);

        updateContactInfo.updateProfile(GetRandom(), GetRandom(),"Bulgaria, Gabrovo", "Gabrovo","Gabrovo", "145558","054884");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

        message = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1")).getText();
        Assert.assertEquals("Update Profile", message);
    }
    @Test(priority = 3)
    public static void billPayCorrectly(){
        billPayPage.GoToTheAccountsOverviewForm();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1")));

        message = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1")).getText();
        Assert.assertEquals("Bill Payment Service", message);

        billPayPage.EnterPayeeInformationAndClickSendPaymentButton("Gosho", "Vidin","Vidin", "Vidin", "141", "02545", "15120","15120", "500");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/h1")));

        message = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/h1")).getText();
        Assert.assertNotEquals("Bill Payment Service", message);
    }
    @Test(priority = 4)
    public static void requestLoanFromFirstAccount(){
        requestLoan.GoToTheRequestLoanForm();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1")));

        message = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1")).getText();
        Assert.assertEquals("Apply for a Loan", message);

        requestLoan.EnterCredentialsAndApplyForLoanFromFirstAccount("500", "1000");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loanProviderName"))); //xpat //*[@id="loanProviderName"]

        message = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1")).getText();
        Assert.assertEquals("Loan Request Processed", message);
    }
    @Test(priority = 5)
    public static void requestLoanFromSecondAccount(){
        requestLoan.GoToTheRequestLoanForm();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1")));

        message = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1")).getText();
        Assert.assertEquals("Apply for a Loan", message);

        requestLoan.EnterCredentialsAndApplyForLoanFromSecondAccount("200", "100");

        message = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1")).getText();
        Assert.assertNotEquals("Loan Request Processed", message);
    }
    @Test(priority = 6)
    //@Order(6)// TODO -NOT PASS
    public static void transferFundsFromFirstToSecondAccount(){
        successfulRegistration();
        requestLoanFromFirstAccount();

        transferFunds.OpenTransferFunds();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

        message = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Transfer Funds", message);

        //TODO
        driver.get(currentURL);
        driver.navigate().refresh();

        transferFunds.transferFromFirstAccountToSecondAccount("200");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

        message = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Transfer Complete!", message);
    }
    @Test(priority = 7)
    //@Order(7) TODO - NOT PASS
    public static void transferFundsFromSecondToFirstAccount(){
        transferFunds.OpenTransferFunds();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

        message = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Transfer Funds", message);

        transferFunds.transferFromSecondAccountToFirstAccount("300");

        message = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Transfer Complete!", message);
    }
    @Test(priority = 8)
    public static void openNewSavingAccount(){
        openNewAccount.GoToTheOpenNewAccountForm();

        message = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Open New Account", message);

        openNewAccount.OpenNewSavingsAccountAndDepositFromFirstAccount();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1")));

        message = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1")).getText();
        Assert.assertNotEquals("Congratulations, your account is now open.", message);
    }
    @Test(priority = 9)
    public static void openNewCheckingAccount(){
        openNewAccount.GoToTheOpenNewAccountForm();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

        message = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Open New Account", message);

        openNewAccount.OpenNewCheckingAccountAndDepositFromFirstAccount();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1")));

        message = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1")).getText();
        Assert.assertNotEquals("Congratulations, your account is now open.", message);
    }
    @Test(priority = 10)
    public static void accountOverview(){
        accountsOverview.GoToTheAccountsOverviewForm();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

        message = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Accounts Overview", message);

        accountsOverview.accountOverview();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1")));

        message = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1")).getText();
        Assert.assertNotEquals("Account Activity", message);
        driver.close();
    }
}
