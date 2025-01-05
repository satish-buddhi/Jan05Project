package com.company;

import com.aventstack.extentreports.Status;
import com.company.pages.OHRMLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public final class TestCase2 extends BaseTest { // does not extend
    private TestCase2() {
    } //for no object creation

    @Test(retryAnalyzer = IRetry.class)
    public void loginWithInvalidCredentials() throws InterruptedException {
        String txt = new OHRMLoginPage().enterUserName("Admin")
                .enterpassword("admin123")
                .clickLogin().getDashboardTxt();

        Assertions.assertThat(txt).hasSize(txt.length())
                .isEqualTo("Dashboard");
    }
    @Test
    public void loginWithInvalidCredentials2() throws InterruptedException {
        String txt = new OHRMLoginPage().enterUserName("Admin")
                .enterpassword("admin123")
                .clickLogin().getDashboardTxt();

        Assertions.assertThat(txt).hasSize(txt.length())
                .isEqualTo("Dashboard");
    }
}
