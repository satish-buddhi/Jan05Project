package com.company.driver;

import com.company.pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.Objects;

import static java.util.Objects.isNull;

public class Driver {
    WebDriver driver;

    public static void initDriver() throws IOException {
         String browserName = null;
        if (!isNull(DriverManager.getDriver())) {
        } else {
            browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : BasePage.readProperty("browser");
            if(browserName.contains("chrome")) {
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver());
            }
            else if(browserName.contains("firefox")){
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
            } else if (browserName.contains("edge")) {
                WebDriverManager.edgedriver().setup();
                DriverManager.setDriver(new EdgeDriver());
            }
            DriverManager.getDriver().manage().window().maximize();
        }
        DriverManager.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public static void closeDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().close();
            DriverManager.unload();
        }
    }
}
