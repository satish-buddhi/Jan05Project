package com.company.pages;

import com.company.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OHRMHomePage extends  BasePage{

    final By txt_Dashboard = By.xpath("//h6[text()='Dashboard']");

    public String getDashboardTxt(){
        String dashboard = waitForElement(txt_Dashboard).getText();
        return dashboard;
    }



}
