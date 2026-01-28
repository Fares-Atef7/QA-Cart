//package com.qacart.todo.BaseTest;
//
//import com.qacart.todo.factory.DriverFactory;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//public class BaseTest {
//    protected WebDriver driver;
//
//    @BeforeTest
//    public void setUp(){
//        driver= new DriverFactory().initilizeDrive();
//    }
//
//    @AfterTest
//    public void tearDown(){
//        driver.quit();
//    }
//
//}



package com.qacart.todo.BaseTest;
import com.qacart.todo.Utilis.CookieUtils;
import com.qacart.todo.factory.DriverFactory;
import io.restassured.http.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod; // تغيير هنا
import org.testng.annotations.BeforeMethod; // تغيير هنا

import java.util.List;

public class BaseTest {
    protected ThreadLocal<WebDriver>  driver=new ThreadLocal<>();

    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }
    public WebDriver getDriver(){
        return this.driver.get();
    }
    @BeforeMethod // خليناها BeforeMethod عشان تفتح متصفح جديد لكل اختبار
    public void setUp() {
       WebDriver driver = new DriverFactory().initilizeDrive();
        setDriver(driver);
    }

    @AfterMethod // خليناها AfterMethod عشان تقفل المتصفح بعد كل اختبار
    public void tearDown() {
        // شرط مهم عشان لو الدرايفر أصلاً بـ null ميعملش Error وهو بيقفل
        if (driver != null) {
            getDriver().quit();
        }
    }

    public void injectCookiestoBrowser(List<Cookie> restassuredCookie) {
        List<org.openqa.selenium.Cookie> seleniumCookie = CookieUtils.ConvertRestAssuredToSeleniumCookie(restassuredCookie);
        for (org.openqa.selenium.Cookie cookie : seleniumCookie) {
            getDriver().manage().addCookie(cookie);
        }
    }
}