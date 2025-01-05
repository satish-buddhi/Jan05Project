package com.company;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.company.driver.Driver;
import com.company.pages.BasePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected  BaseTest(){}

    @BeforeMethod
    public void setup() throws IOException {

       Driver.initDriver();
    }
    @AfterMethod
    public void tearDown(){
       Driver.closeDriver();
    }
}
