package com.qacart.todo.Dummys;

import com.qacart.todo.API.RegisterAPI;

public class RestDummy {
    public static void main(String[] args) {

        RegisterAPI registerAPI=new RegisterAPI();
        registerAPI.Register();
        System.out.println(registerAPI.getAccessToken());
        System.out.println(registerAPI.getUserID());
        System.out.println(registerAPI.getFirstName());

    }
}

/*
*  User user=new User("test2","test22","khfolakh132353@example.com","Fares A9");

        Response respone = given()
                .baseUri("https://qacart-todo.herokuapp.com")
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post("/api/v1/users/register")
                .then()
                .extract().response();
        String accessToken=respone.path("access_token");

        System.out.println(accessToken);*/