package tasks;

import com.aventstack.extentreports.Status;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.OHRMLoginPage;
import utilities.Driver;
import utilities.ExtentReportManager;
import utilities.MyTestListener;

import java.time.LocalTime;

@Listeners(MyTestListener.class)
public class F17T4_SCListenerForFailedTests {
    /*
    Task 4: Screenshot Capture Listener for Failed Tests
    Objective: Implement a custom TestNG listener that automatically captures screenshots when tests
    fail.
    Requirements:
    Create a custom listener class implementing ITestListener interface
    Override the onTestFailure method to capture screenshots
    Save screenshots in a "screenshots" folder with meaningful names (testName_timestamp.png)
    Include browser setup in the listener to access WebDriver instance
    Apply the listener to a test class that contains at least one intentionally failing test
    Verify screenshots are captured and saved correctly when tests fail
    Expected Output: When any test fails, a screenshot should be automatically captured and saved with
    a descriptive filename including test name and timestamp.
     */


    @BeforeMethod
    void beforeMethod() {

        ExtentReportManager.createTest(this.getClass().getSimpleName());
        ExtentReportManager.log(Status.INFO, "Test is starting: " + LocalTime.now());
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    void oHRMPositiveLoginTest() {//Happy Path
        OHRMLoginPage loginPage = new OHRMLoginPage();
        loginPage
                .enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin()
                .assertLogin();
        Driver.closeDriver();
    }

    @Test
    void oHRMNegativeLoginTest1() {
        OHRMLoginPage loginPage = new OHRMLoginPage();
        loginPage
                .enterPassword("admin123")
                .clickLogin()
                .assertUsernameError()
        ;
        Driver.closeDriver();
    }

    @Test
    void oHRMNegativeLoginTest2() {
        OHRMLoginPage loginPage = new OHRMLoginPage();
        loginPage
                .enterUsername("Admin")
                .clickLogin()
                .assertPasswordError()
        ;
        Driver.closeDriver();
    }

    @Test
    void oHRMNegativeLoginTest3() {
        OHRMLoginPage loginPage = new OHRMLoginPage();
        loginPage
                .clickLogin()
                .assertUsernameError()
                .assertPasswordError()
        ;
        Driver.closeDriver();
    }

    @Test
    void oHRMNegativeLoginTest4() {
        OHRMLoginPage loginPage = new OHRMLoginPage();
        loginPage
                .enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin()
                .assertInvalidCredentials()
        ;
        Driver.closeDriver();
    }

    @AfterMethod
    void afterMethod(ITestResult result) {
        ExtentReportManager.logResult(result);
        ExtentReportManager.flushReport();
        Driver.closeDriver();
    }
}
