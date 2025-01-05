package com.company.pages;

import com.company.driver.DriverManager;
import org.openqa.selenium.By;

public class OHRMLoginPage extends  BasePage {

    private final By username = By.cssSelector("[name='username']");
    private final By password = By.cssSelector("[name='password']");
    private final By loginbtn = By.xpath("//button[text()=' Login ']");

    public OHRMLoginPage enterUserName(String un) throws InterruptedException {
        waitForElement(username).sendKeys(un);
        return this;
    }
    public OHRMLoginPage enterpassword(String pw){
        waitForElement(password).sendKeys(pw);
        return this;
    }
    public OHRMHomePage clickLogin(){
        waitForElement(loginbtn).click();
        return new OHRMHomePage();
    }
}
