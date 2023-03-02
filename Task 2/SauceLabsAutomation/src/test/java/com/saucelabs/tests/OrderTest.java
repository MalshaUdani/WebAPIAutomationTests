package com.saucelabs.tests;

import com.saucelabs.common.Constants;
import com.saucelabs.function.CheckoutFunction;
import com.saucelabs.function.LoginFunction;
import com.saucelabs.function.ProductsFunction;
import com.saucelabs.util.PropertyFileReader;
import com.saucelabs.util.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderTest extends TestBase {

    ProductsFunction product;
    CheckoutFunction checkout;
    LoginFunction login;
    PropertyFileReader fileReader = new PropertyFileReader();
    String itemPrice,totalPrice;

    @BeforeMethod
    public void init(){
        product = new ProductsFunction(driver);
        login = new LoginFunction(driver);
        checkout = new CheckoutFunction(driver);
        login.navigateToLogin();
        login.loginToSauceLabs(fileReader.getProperty("userName"),fileReader.getProperty("password"));
        login.verifySuccessfulLogin();
    }

    @Test (description = "Verify user can successfully create an order with multiple products")
    public void createOrderWithMultipleProducts() {
        product.addProductToCart("bolt-t-shirt");
        itemPrice = product.getProductsPrice();
        Assert.assertEquals(itemPrice,"$15.99");
        product.navigateToProductsPage();
        product.addProductToCart("backpack");
        product.checkoutProducts();
        checkout.addInformation(fileReader.getProperty("firstName"),fileReader.getProperty("lastName"),fileReader.getProperty("postalCode"));
        checkout.continueCheckout();
        totalPrice = checkout.getTotalPrice();
        Assert.assertEquals(totalPrice,"Total: $49.66");
        checkout.completeOrderCheckout();
        checkout.verifySuccessfulOrder();
    }
}
