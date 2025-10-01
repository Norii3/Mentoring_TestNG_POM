package tasks.smoke_test2;

import org.testng.annotations.Test;
import pages.*;
import utilities.Driver;

public class ProductPageSmokeTest {


    @Test
    void oHRMPositiveLoginTest() {//Happy Path
        OHRMLoginPage loginPage = new OHRMLoginPage();
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage
                .enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin()
                .assertLogin();
        Driver.closeDriver();
    }

    }
