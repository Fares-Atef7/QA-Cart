package com.qacart.todo.testcase;


import com.qacart.todo.BaseTest.BaseTest;
import com.qacart.todo.Objects.User;
import com.qacart.todo.Pages.SignUpPage;
import com.qacart.todo.Utilis.ConfigUtils;
import com.qacart.todo.Utilis.UserFakeGeneration;
import io.qameta.allure.Feature;
import io.restassured.config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("SignUp Module")
public class SignUpTest extends BaseTest {

    @Test
    public void ShouldBeSignUpSuccessfully() {
        SignUpPage signUpPage = new SignUpPage(getDriver());

       boolean IsDisplayed= signUpPage
                .Load()
                .SignUpProcess(UserFakeGeneration.UserDetails().getFirstName(),
                        UserFakeGeneration.UserDetails().getLastName(),
                        UserFakeGeneration.UserDetails().getEmail(),
                        UserFakeGeneration.UserDetails().getPassword())
                .ISWelcomed();
        Assert.assertTrue(IsDisplayed);

    }


}
