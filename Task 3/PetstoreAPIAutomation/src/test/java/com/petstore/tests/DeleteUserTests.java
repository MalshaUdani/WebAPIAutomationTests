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

public class DeleteUserTests {

    UserService user;
    PropertyFileReader fileReader;

    @BeforeTest
    public void init(){
        user = new UserService();
        fileReader = new PropertyFileReader();
        RestAssured.baseURI= Constants.BASEURL;
        //String username = user.createUser("test1","test1","test1","test1@gmail.com","test123","123456789",1).jsonPath().getString("id");;
    }

    @Test(description = "Delete already created user")
    public void deleteUser(){
        Response response = user.deleteUser(fileReader.getProperty("deleteUser"));
        String username = response.jsonPath().getString("message");
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(username, fileReader.getProperty("deleteUser"));
        System.out.println(response.print());
    }
}
