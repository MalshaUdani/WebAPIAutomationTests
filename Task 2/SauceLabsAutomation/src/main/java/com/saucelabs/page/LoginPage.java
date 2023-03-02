package com.saucelabs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    By txtUserName = By.id("user-name");
    By txtPassword = By.id("password");
    By btnLogin = By.id("login-button");
    String lblLoginError = "//h3[contains(text(),'errorMessage')]";
    By lblProducts = By.xpath("//span[contains(text(),'Products')]");

    public void setUsername(String username){
        driver.findElement(txtUserName).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(btnLogin).click();
    }

    public void loadLoginPage(String url){
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void errorDisplayed(String errorMessage){
        driver.findElement(By.xpath(lblLoginError.replace("errorMessage",errorMessage))).isDisplayed();
    }

    public void successfulLogin(){
        driver.findElement(lblProducts).isDisplayed();
    }
}
