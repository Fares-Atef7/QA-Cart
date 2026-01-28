package com.qacart.todo.API;

import com.qacart.todo.Objects.Task;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TasksApi {

    public void AddTask(String token){
        Task task=new Task(false,"fares");
       Response reponse= given()
                .baseUri("https://qacart-todo.herokuapp.com")
                .header("Content-Type", "application/json")
                .body(task)
                .auth().oauth2(token)
        .when()
                .post("/api/v1/tasks")
        .then()
                .log().all().extract().response();

       if (reponse.statusCode()!=201){
           throw new RuntimeException("Error in the Response");
       }
    }
}
