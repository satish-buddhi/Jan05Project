package com.company.pages;

import com.company.constants.FrameworkConstants;
import com.company.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {


    public WebElement waitForElement(By ele){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
    }
    public static String getScreenshotPath() throws IOException {
        String screenshotPath = FrameworkConstants.getErrorScreenshotPath();
       File src =  ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File(screenshotPath));
        return screenshotPath;
    }
    public static String readProperty(String prop) throws IOException {

        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(FrameworkConstants.getPropertiesFilePath());
        properties.load(fis);
        System.out.println(properties.getProperty("browser"));
       return properties.getProperty(prop);

    }
}
