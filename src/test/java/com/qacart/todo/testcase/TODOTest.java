package com.qacart.todo.testcase;
import com.qacart.todo.API.RegisterAPI;
import com.qacart.todo.API.TasksApi;
import com.qacart.todo.BaseTest.BaseTest;
import com.qacart.todo.Pages.NewTodopage;
import com.qacart.todo.Pages.TodoPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
@Feature("Todo Module")
public class TODOTest extends BaseTest {

    @Story("Add Todo Correctly")
    @Test(description = "test the functionality of add todo item")
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

        NewTodopage newTodopage= new NewTodopage(getDriver());
        newTodopage.load();
        injectCookiestoBrowser(registerAPI.getrestassuredCookies());
        String actualResult=newTodopage.load()
                .AddNewTask("First Item")
                .GetText();
        Assert.assertEquals(actualResult,"First Item");
    }



    @Story("Delete Todo Correctly")
    @Test(description = "test the functionality of Delete todo item")
    public void DeleteTodo() {
        RegisterAPI registerAPI=new RegisterAPI();
        registerAPI.Register();

        TasksApi tasksApi=new TasksApi();
        tasksApi.AddTask(registerAPI.getAccessToken());

        TodoPage TodoPage= new TodoPage(getDriver());
        TodoPage.load();

        injectCookiestoBrowser(registerAPI.getrestassuredCookies());

        boolean notodo = TodoPage
                .load()
                .DeleteItem()
                .NoTODO_Dispalyed();

        Assert.assertTrue(notodo);
    }
}
