package com.qacart.todo.testcase;
import com.qacart.todo.API.RegisterAPI;
import com.qacart.todo.API.TasksApi;
import com.qacart.todo.BaseTest.BaseTest;
import com.qacart.todo.Pages.LoginPage;
import com.qacart.todo.Pages.NewTodopage;
import com.qacart.todo.Pages.TodoPage;
import com.qacart.todo.Utilis.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TODOTest extends BaseTest {
    @Test
    public void addTodoItem() {
//        LoginPage loginPage = new LoginPage(driver);
//        //Builder Design Pattern Technique (Chaining calls)
//        String actualResult =  loginPage.Load()
//                .LoginProcess(ConfigUtils.getInstance().getemail(), ConfigUtils.getInstance().getPassword())
//                .clickOnPlusButton()
//                .AddNewTask("First Item")
//                .GetText();
//        Assert.assertEquals(actualResult, "First Item");
        RegisterAPI registerAPI=new RegisterAPI();
        registerAPI.Register();

        NewTodopage newTodopage= new NewTodopage(driver);
        newTodopage.load();
        injectCookiestoBrowser(registerAPI.getrestassuredCookies());
        String actualResult=newTodopage.load()
                .AddNewTask("First Item")
                .GetText();
        Assert.assertEquals(actualResult,"First Item");
    }

    @Test
    public void DeleteTodo() {
        RegisterAPI registerAPI=new RegisterAPI();
        registerAPI.Register();

        TasksApi tasksApi=new TasksApi();
        tasksApi.AddTask(registerAPI.getAccessToken());

        TodoPage TodoPage= new TodoPage(driver);
        TodoPage.load();

        injectCookiestoBrowser(registerAPI.getrestassuredCookies());

        boolean notodo = TodoPage
                .load()
                .DeleteItem()
                .NoTODO_Dispalyed();

        Assert.assertTrue(notodo);
    }
}
