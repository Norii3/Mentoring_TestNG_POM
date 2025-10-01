package tests;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CLAddContactPage;
import pages.CLAddUserPage;
import pages.CLContactListPage;
import pages.CLHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReportManager;

import java.time.LocalTime;

public class C08_CLAppWithExtentReports {

    @BeforeMethod
    void beforeMethod(){
        ExtentReportManager.createTest(this.getClass().getSimpleName());
        ExtentReportManager.log(Status.INFO,"Test started at: "+ LocalTime.now());
    }

    @Test
    void ContactList() throws InterruptedException {

        CLHomePage homePage = new CLHomePage();
        CLAddUserPage addUserPage = new CLAddUserPage();
        CLContactListPage contactListPage = new CLContactListPage();
        CLAddContactPage addContactPage = new CLAddContactPage();

        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));

        homePage.signup.click();

        addUserPage.firstName.sendKeys(Faker.instance().name().fullName());
        addUserPage.lastName.sendKeys(Faker.instance().name().lastName());
        addUserPage.email.sendKeys(Faker.instance().internet().emailAddress());
        addUserPage.password.sendKeys(Faker.instance().internet().password());
        addUserPage.submit.click();

        for(int i=0; i<5; i++){
            Thread.sleep(1000);
            contactListPage.addContact.click();
            addContactPage.firstName.sendKeys(Faker.instance().name().firstName());
            addContactPage.lastName.sendKeys(Faker.instance().name().lastName());
            addContactPage.submit.click();

        }

        Assert.assertEquals(contactListPage.contactRows.size(), 5);

        Driver.closeDriver();

    }

    @AfterMethod
    void tearDown(ITestResult result){
        ExtentReportManager.log(Status.INFO,"Test finished at: "+ LocalTime.now());
        ExtentReportManager.logResult(result);
        ExtentReportManager.flushReport();
    }
}
