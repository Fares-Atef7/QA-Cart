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
import com.qacart.todo.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod; // تغيير هنا
import org.testng.annotations.BeforeMethod; // تغيير هنا

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod // خليناها BeforeMethod عشان تفتح متصفح جديد لكل اختبار
    public void setUp(){
        driver = new DriverFactory().initilizeDrive();
    }

    @AfterMethod // خليناها AfterMethod عشان تقفل المتصفح بعد كل اختبار
    public void tearDown(){
        // شرط مهم عشان لو الدرايفر أصلاً بـ null ميعملش Error وهو بيقفل
        if(driver != null){
            driver.quit();
        }
    }
}