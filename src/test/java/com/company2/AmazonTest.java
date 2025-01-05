package com.company2;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AmazonTest {

    @Test
    public void reportsTest() throws IOException {
        //setup
        ExtentReports reports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//src//reports//report.html");
        reporter.config().setReportName("test report");
        reporter.config().setDocumentTitle("this is docTitle");
        reports.attachReporter(reporter);
//createTEst
        ExtentTest test = reports.createTest("TEST01");
        test.pass("This is test pass message");

        ExtentTest test2 = reports.createTest("TEST02");
        test.fail("This is test fail message of 2nd ExtentTest");
//teardown
        reports.flush();
        Desktop.getDesktop().browse(
                new File(System.getProperty("user.dir")+"//src//reports//report.html").toURI());
    }
}
