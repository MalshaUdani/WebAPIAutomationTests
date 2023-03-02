package com.saucelabs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver){
        this.driver=driver;
    }

    String btnAddtoCart = "add-to-cart-sauce-labs-productName";
    By iconAddtoCart = By.id("shopping_cart_container");
    By btnContinueShopping = By.id("continue-shopping");
    By btnCheckout = By.id("checkout");
    By lblPrice1 = By.xpath("//div[@class='inventory_item_price']");


    public void clickAddToCart(String productName){
        driver.findElement(By.id(btnAddtoCart.replace("productName",productName))).click();
    }

    public void clickAddToCartIcon(){
        driver.findElement(iconAddtoCart).click();
    }

    public void clickContinueShopping(){
        driver.findElement(btnContinueShopping).click();
    }

    public void clickCheckout(){
        driver.findElement(btnCheckout).click();
    }

    public String getText(){
        return driver.findElement(lblPrice1).getText();
    }

}
