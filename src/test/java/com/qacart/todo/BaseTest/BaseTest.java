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
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod; // تغيير هنا
import org.testng.annotations.BeforeMethod; // تغيير هنا

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
    public void tearDown(ITestResult result) throws IOException {
       String testCaseName=result.getMethod().getMethodName();
       File file =new File("target"+File.separator+"ScreenShots"+File.separator+testCaseName+File.separator+".png");
        TakeScreenShots(file);
        // شرط مهم عشان لو الدرايفر أصلاً بـ null ميعملش Error وهو بيقفل
        if (driver != null) {
            getDriver().quit();
        }
    }
    @Step
    public void injectCookiestoBrowser(List<Cookie> restassuredCookie) {
        List<org.openqa.selenium.Cookie> seleniumCookie = CookieUtils.ConvertRestAssuredToSeleniumCookie(restassuredCookie);
        for (org.openqa.selenium.Cookie cookie : seleniumCookie) {
            getDriver().manage().addCookie(cookie);
        }
    }

    public  void TakeScreenShots(File destFile){
        File file=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, destFile);
            InputStream inputStream =new FileInputStream(destFile);
            Allure.addAttachment("ScreenShots",inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}