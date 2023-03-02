package com.saucelabs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    By txtFirstName = By.id("first-name");
    By txtLastName = By.id("last-name");
    By txtPostalCode = By.id("postal-code");
    By btnContinue = By.id("continue");
    By lblTotalPrice = By.xpath("//div[@class='summary_info_label summary_total_label']");
    By btnFinish = By.id("finish");
    By lblComplete = By.xpath("//span[contains(text(),'Checkout: Complete!')]");


    public void setFirstName(String firstname){
        driver.findElement(txtFirstName).sendKeys(firstname);
    }

    public void setLastName(String lastname){
        driver.findElement(txtLastName).sendKeys(lastname);
    }

    public void setPostalCode(String postalCode){
        driver.findElement(txtPostalCode).sendKeys(postalCode);
    }

    public void clickContinue(){
        driver.findElement(btnContinue).click();
    }

    public String getText(){
        return driver.findElement(lblTotalPrice).getText();
    }

    public void clickFinish(){
        driver.findElement(btnFinish).click();
    }

    public void successfulOrder(){
        driver.findElement(lblComplete).isDisplayed();
    }

}
