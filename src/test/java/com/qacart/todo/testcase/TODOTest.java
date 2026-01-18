package com.qacart.todo.testcase;
import com.qacart.todo.BaseTest.BaseTest;
import com.qacart.todo.Pages.LoginPage;
import com.qacart.todo.Utilis.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TODOTest extends BaseTest {
    @Test
    public void addTodoItem() {
        LoginPage loginPage = new LoginPage(driver);
        //Builder Design Pattern Technique (Chaining calls)
        String actualResult =  loginPage.Load()
                .LoginProcess(ConfigUtils.getInstance().getemail(), ConfigUtils.getInstance().getPassword())
                .clickOnPlusButton()
                .AddNewTask("First Item")
                .GetText();
        Assert.assertEquals(actualResult, "First Item");
    }

    @Test (enabled = false)
    public void DeleteTodo() {
        LoginPage loginPage = new LoginPage(driver);
        //Builder Design Pattern Technique (Chaining calls)
        boolean notodo = loginPage
                .Load()
                .LoginProcess(ConfigUtils.getInstance().getemail(), ConfigUtils.getInstance().getPassword())
                .clickOnPlusButton()
                .AddNewTask("First Item")
                .DeleteItem()
                .NoTODO_Dispalyed();

        Assert.assertTrue(notodo);
    }
}
