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

public class CreateUserTests {

    UserService user;
    PropertyFileReader fileReader;

    @BeforeTest
    public void init(){
        user = new UserService();
        fileReader = new PropertyFileReader();
        RestAssured.baseURI= Constants.BASEURL;
    }

    @Test(description = "Create new user with valid data")
    public void createUser(){
        Response response = user.createUser(fileReader.getProperty("userName"),fileReader.getProperty("firstName"),fileReader.getProperty("lastName"),fileReader.getProperty("email"),fileReader.getProperty("password"),fileReader.getProperty("phone"),Integer.parseInt(fileReader.getProperty("userStatus")));
        String userId = response.jsonPath().getString("message");
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertNotNull(userId);
        System.out.println(response.print());
    }

}
