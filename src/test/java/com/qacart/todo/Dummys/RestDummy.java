package com.qacart.todo.Dummys;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestDummy {
    public static void main(String[] args) {

        String requestBody="{\n" +
                "    \"email\":\"khfolakh122@example.com\",\n" +
                "    \"firstName\":\"ahmed\",\n" +
                "    \"lastName\":\"ashraf\",\n" +
                "    \"password\":\"123456789\"\n" +
                "}";

        Response respone=given()
                .baseUri("https://qacart-todo.herokuapp.com")
                .header("Content-Type", "application/json")
                .body(requestBody)
        .when()
                .post("/api/v1/users/register")
        .then()
                .extract().response();

        System.out.println(respone.prettyPrint());
    }
}
