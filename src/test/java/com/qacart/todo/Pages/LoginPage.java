package com.qacart.todo.Pages;
import com.qacart.todo.BaseTest.BasePage;
import com.qacart.todo.Utilis.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"email\"]")
    private WebElement emailInput;

    @FindBy(css = "[data-testid=\"password\"]")
    private WebElement passwordInput;

    @FindBy(css = "[data-testid=\"submit\"]")
    private WebElement submit;

    public LoginPage Load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }

    public TodoPage LoginProcess(String email,String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submit.click();
        return new TodoPage(driver);
    }








}
