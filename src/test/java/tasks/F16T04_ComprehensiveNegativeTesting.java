package tasks;

import org.testng.annotations.Test;
import pages.CNLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

//import static com.sun.org.apache.xpath.internal.compiler.Token.contains;

public class F16T04_ComprehensiveNegativeTesting {

/*

Task 4: Comprehensive Negative Testing
Go to https://claruswaysda.github.io/signln.html
Do negative test with all scenarios

Requirements:
Create a FluentSignInPage class
Implement all negative test scenarios:
Empty username/password
Invalid username formats
Weak passwords
Cross-site scripting attempts
Chain validation operations for each negative scenario
Use soft assertions to collect all validation errors
Create comprehensive error reporting within fluent chains

*/

    @Test
    public void emptyUsername() {

        CNLoginPage loginPage = new CNLoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        loginPage
                .enterPassword("Password123")
                .enterSubmit()
                .assertUsernameError();

        Driver.closeDriver();
    }

    @Test
    public void emptyPassword() {

        CNLoginPage loginPage = new CNLoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        loginPage
                .enterUsername("student")
                .enterSubmit()
                .assertPasswordError();
        Driver.closeDriver();
    }

    @Test
    public void invalidUsernameFormats() {

        CNLoginPage loginPage = new CNLoginPage();

        Driver.getDriver().get("https://practicetestautomation.com/practice-test-login");
        loginPage
                .enterUsername("Admin")
                .enterPassword("Password123")
                .enterSubmit()
                .assertUsernameError();

        Driver.closeDriver();
    }

    @Test
    public void weakPasswords() {

        CNLoginPage loginPage = new CNLoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        loginPage
                .enterUsername("student")
                .enterPassword("123")
                .enterSubmit()
                .assertPasswordError();

        Driver.closeDriver();
    }

    @Test
    public void crossSiteScriptingAttempts() {

        CNLoginPage loginPage = new CNLoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        loginPage
                .enterUsername("<script>alert('XSS')</script>")
                .enterPassword("Password123")
                .enterSubmit()
                .assertUsernameError();
        Driver.closeDriver();
    }

}
