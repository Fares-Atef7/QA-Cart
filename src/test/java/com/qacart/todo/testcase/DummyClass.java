package com.qacart.todo.testcase;

import com.qacart.todo.API.RegisterAPI;
import com.qacart.todo.Utilis.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class DummyClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver=new ChromeDriver();

        webDriver.get(ConfigUtils.getInstance().getBaseUrl());
        webDriver.manage().window().maximize();

        RegisterAPI registerAPI=new RegisterAPI();
        registerAPI.Register();

        List<Cookie>restassuredCookie=registerAPI.getrestassuredCookies();
        for (Cookie cookie:restassuredCookie){
            org.openqa.selenium.Cookie seleniumCookie=new org.openqa.selenium.Cookie(cookie.getName(),cookie.getValue());
            webDriver.manage().addCookie(seleniumCookie);
        }

        webDriver.get(ConfigUtils.getInstance().getBaseUrl());

        Thread.sleep(20000);

        webDriver.quit();
    }
}
