package tasks;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CLRegistrationPage;
import utilities.Driver;
import utilities.MyTestListener;

@Epic("Contact Management System")
@Feature("User Registration and Contact Management")
@Listeners(MyTestListener.class)
public class F18T1T2_ContactLestAllureAndExtentReports {

/*
    Target: https://thinking-tester-contact-list.herokuapp.com/
    Test Scenario:
    1. Navigate to the application
    2. Create a new user account
    3. Login with the created user
    4. Add 5 different contacts
    5. Assert that all contacts are properly added and displayed
    Allure Organization:
    - @Epic("Contact Management System")
    - @Feature("User Registration and Contact Management")
    - @Story annotations for: "User Registration", "User Login", "Add Contact"
    Page Objects Requirements:
    - All page methods must have @Step annotations
    - LoginPage: @Step for registration and login actions
    - ContactListPage: @Step for navigation and verification
    - AddContactPage: @Step for form filling and submission
    Allure Annotations Required:
    - @Description on all test methods
    - @Severity levels: CRITICAL for registration/login, NORMAL for contact operations
    - @Attachment for screenshots on failures
*/

    private CLRegistrationPage registrationPage;

    @Test
    @Description("Test successful login with valid credentials")
    void happyPath() {
        registrationPage = new CLRegistrationPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        registrationPage
                .enterFirstname(Faker.instance().name().firstName())
                .enterLastname(Faker.instance().name().lastName())
                .enterEmail(Faker.instance().internet().emailAddress())
                .enterPassword("Password.123")
                .clickSubmit()
                .assertAddContactButton();
    }

    @Test
    @Description("Test login with empty firstname")
    void emptyFirstnameTest() {
        registrationPage = new CLRegistrationPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        registrationPage
                .enterLastname(Faker.instance().name().lastName())
                .enterEmail(Faker.instance().internet().emailAddress())
                .enterPassword("Password.123")
                .clickSubmit()
                .assertErrorMessage("`firstName` is required.");
    }


    @Test
    @Description("Test login with special char in firstname")
    void firstnameWithSpecialCharTest() {
        registrationPage = new CLRegistrationPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        registrationPage
                .enterFirstname("J@hn")
                .enterLastname(Faker.instance().name().lastName())
                .enterEmail(Faker.instance().internet().emailAddress())
                .enterPassword("Password.123")
                .clickSubmit()
                .assertErrorMessage("firstName");
    }


    @Test
    @Description("Test login with number in firstname")
    void firstnameWithNumbersTest() {
        registrationPage = new CLRegistrationPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        registrationPage
                .enterFirstname("John123")
                .enterLastname(Faker.instance().name().lastName())
                .enterEmail(Faker.instance().internet().emailAddress())
                .enterPassword("Password.123")
                .clickSubmit()
                .assertErrorMessage("firstName");
    }

    @Test
    @Description("Test login with empty lastname")
    void emptyLastnameTest() {
        registrationPage = new CLRegistrationPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        registrationPage
                .enterFirstname(Faker.instance().name().firstName())
                .enterEmail(Faker.instance().internet().emailAddress())
                .enterPassword("Password.123")
                .clickSubmit()
                .assertErrorMessage("`firstName` is required.");
    }


    @Test
    @Description("Test login with special char in lastname")
    void lastnameWithSpecialCharTest() {
        registrationPage = new CLRegistrationPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        registrationPage
                .enterFirstname(Faker.instance().name().firstName())
                .enterLastname("J@hn")
                .enterEmail(Faker.instance().internet().emailAddress())
                .enterPassword("Password.123")
                .clickSubmit()
                .assertErrorMessage("lastName");
    }


    @Test
    @Description("Test login with number in lastname ")
    void lastnameWithNumbersTest() {
        registrationPage = new CLRegistrationPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        registrationPage
                .enterFirstname(Faker.instance().name().firstName())
                .enterLastname("John123")
                .enterEmail(Faker.instance().internet().emailAddress())
                .enterPassword("Password.123")
                .clickSubmit()
                .assertErrorMessage("lastName");
    }
}
