package com.java_parabank_demo.helpers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CredentialsAndURLS {

    private static String baseURL;
    private static String registerURL;
    private static String users;
    private static String firstName;
    private static String lastName;
    private static String address;
    private static String state;
    private static String zipCode;
    private static String phone;
    private static String ssn;
    private static String username;
    private static String password;
    private static String confirmPW;

    public static void credentialsAndURLS() throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader("C:/Users/Samuil/Desktop/Parabank/java_parabank_demo/src/main/java" +
                "/com/java_parabank_demo/config/config.json");
        Object object = jsonparser.parse(reader);
        JSONObject configJsonObj = (JSONObject) object;

        baseURL = (String) configJsonObj.get("baseURL");
        registerURL = (String) configJsonObj.get("registerURL");
       // users = (String) configJsonObj.get("users"); //TODO
        firstName = (String) configJsonObj.get("name");
        lastName = (String) configJsonObj.get("lastName");
        address = (String) configJsonObj.get("address");
        state = (String) configJsonObj.get("state");
        zipCode = (String) configJsonObj.get("zipcode");
        phone = (String) configJsonObj.get("phone");
        ssn = (String) configJsonObj.get("ssn");
        username = (String) configJsonObj.get("username");
        password = (String) configJsonObj.get("password");
        confirmPW = (String) configJsonObj.get("confirmPW");
       // confirmPW = configJsonObj.get("confirmPW").toString();
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public static String getBaseURL() {
        return baseURL;
    }

    public void setUsers(String baseURL) {
        this.users = users;
    }

    public static String getUsers() {
        return users;
    }

    public void setRegisterURL(String registerURL) {
        this.registerURL = registerURL;
    }

    public static String getRegisterURL() {
        return registerURL;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public static String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static String getLastName() {
        return lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static String getAddress() {
        return address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static String getState() {
        return state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public static String getZipCode() {
        return zipCode;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static String getPhone() {
        return phone;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public static String getSsn() {
        return ssn;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getPassword() {
        return password;
    }

    public void setConfirmPW(String confirmPW) {
        this.confirmPW = confirmPW;
    }

    public static String getConfirmPW() {
        return confirmPW;
    }

    @Test
    public void test() throws IOException, ParseException, org.json.simple.parser.ParseException {
        credentialsAndURLS();
        System.out.println(baseURL);
        System.out.println(registerURL);

    }
}
