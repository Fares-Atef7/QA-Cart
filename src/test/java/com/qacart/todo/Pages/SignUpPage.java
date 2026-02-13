package com.qacart.todo.Pages;

import com.qacart.todo.BaseTest.BasePage;
import com.qacart.todo.Utilis.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"first-name\"]")
    private WebElement FirstNameInput;

    @FindBy(css = "[data-testid=\"last-name\"]")
    private WebElement LastNameInput;

    @FindBy(css = "[data-testid=\"email\"]")
    private WebElement Email;

    @FindBy(css = "[data-testid=\"password\"]")
    private WebElement Password;

    @FindBy(css = "[data-testid=\"confirm-password\"]")
    private WebElement ConfirmPassword;

    @FindBy(css = "[data-testid=\"submit\"]")
    private WebElement submit;

    public SignUpPage Load() {
        driver.get("https://qacart-todo.herokuapp.com/signup");
        return this;
    }


    @Step
    public TodoPage SignUpProcess(String firstName, String lastName, String email, String password) {
        FirstNameInput.sendKeys(firstName);
        LastNameInput.sendKeys(lastName);
        Email.sendKeys(email);
        Password.sendKeys(password);
        ConfirmPassword.sendKeys(password);
        submit.click();
        return new TodoPage(driver);
    }
}
