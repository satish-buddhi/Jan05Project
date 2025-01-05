package com.company2;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ReportsTesting {
    ExtentReports  reports =  new ExtentReports(); ;
    ExtentTest test;
   static String reportsPath = System.getProperty("user.dir") + "//src//reports//report.html";
public  ThreadLocal <ExtentTest> threadLocal = new ThreadLocal<>();
   public  void initReports(){

       ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportsPath);
       sparkReporter.config().setReportName("this is spark");
       sparkReporter.config().setDocumentTitle("docTitle");
       reports.attachReporter(sparkReporter);
   }

   public  void closeReports() throws IOException {
       reports.flush();
       Desktop.getDesktop().browse(new File(reportsPath).toURI());
   }

    @Test
    public  void callTest1(){
       test = reports.createTest("calling TEst1");
         threadLocal.set(test);
        threadLocal.get().log(Status.PASS,"test.log - success message");
        threadLocal.get().pass("test.pass - passed");
    }
    @Test
    public  void callTest2(){
        test = reports.createTest("calling TEst2");
        threadLocal.set(test);
        threadLocal.get().log(Status.FAIL,"test.log - success message 2");
        threadLocal.get().fail("test.pass - failed");
    }


}
