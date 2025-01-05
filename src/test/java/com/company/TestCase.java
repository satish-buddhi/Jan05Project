package com.company;

import com.aventstack.extentreports.Status;
import com.company.pages.BasePage;
import com.company.pages.OHRMLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;

public final class TestCase extends BaseTest { // does not extend
    private TestCase() {
    } // for no object creation

    @Test
    public void loginWithValidCredentials() throws InterruptedException, IOException {
       String txt =  new OHRMLoginPage().enterUserName("Admin")
                .enterpassword("admin1234")
                .clickLogin().getDashboardTxt();
        Assertions.assertThat(txt).hasSize(txt.length())
                .isEqualTo("Dashboard");
    }
    @Test
    public void loginWithValidCredentials2() throws InterruptedException, IOException {
        String txt =  new OHRMLoginPage().enterUserName("Admin")
                .enterpassword("admin123")
                .clickLogin().getDashboardTxt();
        Assertions.assertThat(txt).hasSize(txt.length())
                .isEqualTo("Dashboard");
    }

}
