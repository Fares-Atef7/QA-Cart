package com.qacart.todo.Pages;

import com.qacart.todo.BaseTest.BasePage;
import com.qacart.todo.Utilis.ConfigUtils;
import com.qacart.todo.config.ENDPOINT;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {


    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement isWelcomed;
    @Step
    public boolean ISWelcomed() {
        return isWelcomed.isDisplayed();
    }

    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement add;

    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement newTodo;

    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement submitnewTask;

    @FindBy(css = "[data-testid=\"todo-text\"]")
    private WebElement todoText;

    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement DeleteButton;

    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement no_todos;

//    public void addTaskProcess() {
//        add.click();
//        newTodo.sendKeys("First Item");
//        submitnewTask.click();
//    }
    @Step
    public TodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ ENDPOINT.TODOPAGE_ENDPOINT);
        return this;
    }
    @Step
    public NewTodopage clickOnPlusButton() {
        add.click();
        return new NewTodopage(driver);
    }
    @Step
    public String GetText() {
        return todoText.getText();
    }
    /*public void SendKey(){
        newTodo.sendKeys("First Item");
    }
    public void SubmitNewTask(){
        submitnewTask.click();
    }*/
    @Step
    public TodoPage DeleteItem(){
        DeleteButton.click();
        return new TodoPage(driver);
    }
    @Step
    public boolean NoTODO_Dispalyed(){
        return no_todos.isDisplayed();
    }
}
