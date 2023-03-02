package com.saucelabs.function;

import com.saucelabs.page.LoginPage;
import com.saucelabs.page.ProductsPage;
import org.openqa.selenium.WebDriver;

public class ProductsFunction {

    static WebDriver driver;
    ProductsPage productsPage;

    public ProductsFunction(WebDriver driver){
        this.driver=driver;
        productsPage = new ProductsPage(driver);
    }

    //Add a product to the cart
    public void addProductToCart(String productName){
        productsPage.clickAddToCart(productName);
        productsPage.clickAddToCartIcon();
    }

    public void navigateToProductsPage(){
        productsPage.clickContinueShopping();
    }

    public void checkoutProducts(){
        productsPage.clickCheckout();
    }

    public String getProductsPrice(){
        return productsPage.getText();
    }

}
