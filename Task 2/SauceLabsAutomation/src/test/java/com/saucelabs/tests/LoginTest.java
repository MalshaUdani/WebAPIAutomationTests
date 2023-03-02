package com.saucelabs.tests;

import com.saucelabs.common.Constants;
import com.saucelabs.function.LoginFunction;
import com.saucelabs.util.PropertyFileReader;
import com.saucelabs.util.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginFunction login;
    PropertyFileReader fileReader;

    @BeforeMethod
    public void init(){
        login = new LoginFunction(driver);
        fileReader = new PropertyFileReader();
    }

    @Test (description = "Login to application with valid user credentials")
    public void loginWithValidUser(){
        login.navigateToLogin();
        Assert.assertEquals(login.getPageTitle(),"Swag Labs");
        login.loginToSauceLabs(fileReader.getProperty("userName"),fileReader.getProperty("password"));
        login.verifySuccessfulLogin();
    }

    @Test (description = "Login to application with locked user credentials")
    public void loginWithLockedUser(){
        login.navigateToLogin();
        Assert.assertEquals(login.getPageTitle(),"Swag Labs");
        login.loginToSauceLabs(fileReader.getProperty("lockUserName"),fileReader.getProperty("password"));
        login.verifyErrorMessageDisplayed("Epic sadface: Sorry, this user has been locked out.");
    }
}
