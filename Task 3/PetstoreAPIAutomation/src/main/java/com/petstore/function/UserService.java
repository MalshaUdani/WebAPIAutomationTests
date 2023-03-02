package com.petstore.function;

import com.petstore.common.Endpoints;
import com.petstore.model.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService {

    User user = new User();
    int id = (int) (Math.random() * 10000 + 1);

    //Create new user
    public Response createUser(String username, String firstname, String lastname, String email, String password,String phone, int userStatus){
        user.setId(id);
        user.setUserName(username);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setUserStatus(userStatus);
        Response response = given().contentType("application/json")
                .body(user)
                .when().post(Endpoints.CREATEUSER)
                .then().extract().response();
        return response;
    }

    //Get existing user
    public Response getUser(String userName){
        Response response = given().contentType("application/json")
                .when().get(Endpoints.GETEUSER.replace("{username}",userName))
                .then().extract().response();
        return response;
    }

    //Delete user
    public Response deleteUser(String userName){
        Response response = given().contentType("application/json")
                .when().delete(Endpoints.DELETEUSER.replace("{username}",userName))
                .then().extract().response();
        return response;
    }

}
