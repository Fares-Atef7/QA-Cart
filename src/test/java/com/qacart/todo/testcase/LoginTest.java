package com.qacart.todo.testcase;
import com.qacart.todo.BaseTest.BaseTest;
import com.qacart.todo.Pages.LoginPage;
import com.qacart.todo.Utilis.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void ShouldBeLogin() {
        LoginPage loginPage = new LoginPage(getDriver());

        boolean isdisplayed = loginPage
                .Load()
                .LoginProcess(ConfigUtils.getInstance().getemail(), ConfigUtils.getInstance().getPassword())
                .ISWelcomed();
        Assert.assertTrue(isdisplayed);
    }
}
