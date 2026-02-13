package com.qacart.todo.testcase;
import com.qacart.todo.BaseTest.BaseTest;
import com.qacart.todo.Pages.LoginPage;
import com.qacart.todo.Utilis.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Login Module")
public class LoginTest extends BaseTest {
    @Story("Login with Correct Information")
    @Description("it will login by filling the email and password and navigate to home page")
    @Test(description = "Login with Faker information but valid data")
    public void ShouldBeLoginSuccessfully() {
        LoginPage loginPage = new LoginPage(getDriver());

        boolean isDisplayed = loginPage
                .Load()
                .LoginProcess("example@gmail.com", "123456")
                .ISWelcomed();
        Assert.assertTrue(isDisplayed);
    }
}



