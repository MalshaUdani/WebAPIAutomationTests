package com.saucelabs.util;

import com.saucelabs.function.LoginFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
