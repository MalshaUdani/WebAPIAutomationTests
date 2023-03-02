package com.saucelabs.function;

import com.saucelabs.page.CheckoutPage;
import org.openqa.selenium.WebDriver;

public class CheckoutFunction {

    static WebDriver driver;
    CheckoutPage checkoutPage;

    public CheckoutFunction(WebDriver driver){
        this.driver=driver;
        checkoutPage = new CheckoutPage(driver);
    }

    //Add user information for checkout
    public void addInformation(String firstName, String lastName, String postalCode){
        checkoutPage.setFirstName(firstName);
        checkoutPage.setLastName(lastName);
        checkoutPage.setPostalCode(postalCode);
    }

    public void continueCheckout(){
        checkoutPage.clickContinue();
    }

    public String getTotalPrice(){
        return checkoutPage.getText();
    }

    public void completeOrderCheckout(){
        checkoutPage.clickFinish();
    }

    public void verifySuccessfulOrder(){
        checkoutPage.successfulOrder();
    }
}
