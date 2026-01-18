package com.qacart.todo.factory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
public class DriverFactory {
    // each variable private
    //   private WebDriver driver;

        public WebDriver initilizeDrive(){
            String browser=System.getProperty("browser","edge");
            WebDriver driver;
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
                default:
                    throw new RuntimeException("Invalid Browser Name");
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            return driver;
        }
}
