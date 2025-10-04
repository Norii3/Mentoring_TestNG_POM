package tests;

import org.testng.annotations.Test;
import pages.UserRegistrationPage;
import utilities.Driver;

public class C09_UserRegistration {

    //US01: As a new user I want to register for an account by providing my personal information.
    /*
    Go to https://claruswaysda.github.io/Registration.html
    Enter valid SSN
    ..... Task ....
     */

    @Test
    void happyPath(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-33-4567")
                .enterFirstname("John")
                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("CV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("John.1234")
                .clickRegister()
                .assertJSAlert("Form submitted!");
    }

    @Test
    void incorrectSSNTest(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("33-4567")
                .enterFirstname("John")
                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("CV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("John.1234")
                .clickRegister()
                .assertValidationMessage("Please match the requested format.","ssn");
    }

    //Rest is assignment!!!

    @Test
    void emptySSNTest(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterFirstname("John")
                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("CV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("John.1234")
                .clickRegister()
                .assertValidationMessage("Please fill out this field.","ssn");
    }

    @Test
    void noHyphensSSNTest(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123334567")
                .enterFirstname("John")
                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("CV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("John.1234")
                .clickRegister()
                .assertValidationMessage("Please match the requested format.","ssn");
    }

    @Test
    void ssnWithLettersTest(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-33-mn67")
                .enterFirstname("John")
                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("CV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("John.1234")
                .clickRegister()
                .assertValidationMessage("Please match the requested format.","ssn");
    }

    @Test
    void ssnWithSpecialCharacters(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-33-@567")
                .enterFirstname("John")
                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("CV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("John.1234")
                .clickRegister()
                .assertValidationMessage("Please match the requested format.","ssn");
    }

}
