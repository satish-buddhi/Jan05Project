package com.company;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetry implements IRetryAnalyzer {
    int count=0, maxTry = 1;
    @Override
    public boolean retry(ITestResult result) {
        while (count<maxTry){
            count++;
            return true;
        }
        return false;
    }
}
