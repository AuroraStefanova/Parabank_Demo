package com.java_parabank_demo.Pages.Authorization;

import org.openqa.selenium.By;

public class Authorization_Forms_Elements {

    public By usernameField= By.xpath("//input[@name='username']");
    public By passwordField= By.xpath("//input[@name='password']");
    public By loginButton= By.xpath("//input[@name='password']");

    public By registerLinkText= By.xpath("//a[.='Register']");
    public By firstNameField= By.id("customer.firstName");
    public By lastNameField= By.id("customer.lastName");
    public By addressField= By.id("customer.address.street");
    public By cityField= By.id("customer.address.city");
    public By stateField= By.id("customer.address.state");
    public By zipCodeField= By.id("customer.address.zipCode");
    public By phoneNumberField= By.id("customer.phoneNumber");
    public By SSNField= By.id("customer.ssn");
    public By userNameField= By.id("customer.username");
    public By setPasswordField= By.id("customer.password");
    public By confirmPWField= By.id("repeatedPassword]");
    public By registerButton= By.xpath("//input[@value='Register']]");

    // Add methods

}
