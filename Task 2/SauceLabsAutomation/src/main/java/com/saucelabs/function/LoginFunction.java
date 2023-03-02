package com.saucelabs.function;

import com.saucelabs.common.Constants;
import com.saucelabs.page.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginFunction {

    static WebDriver driver;
    LoginPage loginPage;

    public LoginFunction(WebDriver driver){
        this.driver=driver;
        loginPage = new LoginPage(driver);
    }

    public void navigateToLogin(){
        loginPage.loadLoginPage(Constants.APPLICATIONURL);
    }

    //login to application with user credentials
    public void loginToSauceLabs(String username, String password){
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();
    }

    public void verifyErrorMessageDisplayed(String errorMessage){
        loginPage.errorDisplayed(errorMessage);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void verifySuccessfulLogin(){
        loginPage.successfulLogin();
    }


}
