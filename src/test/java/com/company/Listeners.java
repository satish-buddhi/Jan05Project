package com.company;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.company.pages.BasePage;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Listeners implements ITestListener {
    ExtentReports reports = new ExtentReports();
    ;
    ExtentTest test;
    static String reportsPath = System.getProperty("user.dir") + "//src//reports//report.html";
    public ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportsPath);
        sparkReporter.config().setReportName("this is spark");
        sparkReporter.config().setDocumentTitle("docTitle");
        reports.attachReporter(sparkReporter);
        test = reports.createTest(result.getMethod().getMethodName());
        threadLocal.set(test);
    }

    public void onTestSuccess(ITestResult result) {
        threadLocal.get().log(Status.PASS, result.getMethod().getMethodName());
        threadLocal.get().pass(result.getMethod().getMethodName() + " test.pass - passed");
    }

    public void onTestFailure(ITestResult result) {
        try {
            threadLocal.get().addScreenCaptureFromPath(BasePage.getScreenshotPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        threadLocal.get().log(Status.FAIL, result.getThrowable());
        threadLocal.get().fail(result.getMethod().getMethodName() + " test.fail - failed");
    }

    public void onFinish(ITestContext context) {
        reports.flush();
        try {
            Desktop.getDesktop().browse(new File(reportsPath).toURI());
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult result) {
        threadLocal.get().log(Status.SKIP, result.getThrowable());
        threadLocal.get().skip(result.getMethod().getMethodName() + " - skipped");
    }
}
