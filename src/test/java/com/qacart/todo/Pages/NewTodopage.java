package com.qacart.todo.Pages;

import com.qacart.todo.BaseTest.BasePage;
import com.qacart.todo.Utilis.ConfigUtils;
import com.qacart.todo.config.ENDPOINT;
import io.qameta.allure.Step;
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

    @Step
    public TodoPage AddNewTask(String Item){
        new TodoPage(driver).clickOnPlusButton();
        NewTodoInput.sendKeys(Item);
        submit_newTask.click();
        return new TodoPage(driver);
    }
    @Step
    public NewTodopage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ ENDPOINT.NEWTODOPAGE_ENDPOINT);
        return this;
    }
}
