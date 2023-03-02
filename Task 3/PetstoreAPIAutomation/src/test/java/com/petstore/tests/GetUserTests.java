package com.petstore.tests;

import com.petstore.common.Constants;
import com.petstore.function.UserService;
import com.petstore.util.PropertyFileReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetUserTests {

    UserService user;
    PropertyFileReader fileReader;

    @BeforeTest
    public void init(){
        user = new UserService();
        fileReader = new PropertyFileReader();
        RestAssured.baseURI= Constants.BASEURL;
        //String username = user.createUser("test1","test1","test1","test1@gmail.com","test123","123456789",1).jsonPath().getString("username");
    }

    @Test(description = "Retrieve existing user")
    public void getUser(){
        Response response = user.getUser(fileReader.getProperty("updateUser"));
        String username = response.jsonPath().getString("username");
        System.out.println(response.print());
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(username, fileReader.getProperty("updateUser"));
        System.out.println(response.print());
    }
}
