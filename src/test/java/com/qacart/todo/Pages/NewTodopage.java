package com.qacart.todo.Pages;

import com.qacart.todo.BaseTest.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodopage extends BasePage {
    public NewTodopage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement NewTodoInput;

    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement submit_newTask;
    public TodoPage AddNewTask(String Item){
        NewTodoInput.sendKeys(Item);
        submit_newTask.click();
        return new TodoPage(driver);
    }


}
