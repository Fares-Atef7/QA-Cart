package com.qacart.todo.Utilis;

import com.github.javafaker.Faker;
import com.qacart.todo.Objects.User;

public class UserFakeGeneration {
    public static User UserDetails() {
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        String email = new Faker().internet().emailAddress();
        String password = new Faker().internet().password();
        User user = new User(firstName, lastName, email, password);
        return user;
    }
}
