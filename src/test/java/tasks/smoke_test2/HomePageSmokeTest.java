package tasks.smoke_test2;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SDLoginPage;
import pages.SDProductsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class HomePageSmokeTest {

  /*  Objective: Design and implement a comprehensive smoke test suite for an e-commerce application.
    Requirements:
    Create at least 3 smoke test classes: HomePage, ProductPage, and CheckoutPage
    Each class should contain one critical path test
            Organize tests in a "smokeTest" package
    Create XML configuration with verbose level 5
    All tests should complete within 2 minutes total
    Expected Output: A reliable smoke test suite that validates core application functionality.
    */



    @Test
    void  homePageTest(){
        SDLoginPage loginPage = new SDLoginPage();
        SDProductsPage productsPage = new SDProductsPage();

        Driver.getDriver().get(ConfigReader.getProperty("sd_url"));

        loginPage.login(ConfigReader.getProperty("sd_username"),
                 ConfigReader.getProperty("sd_password"));



        productsPage.sortProducts(2);

        Assert.assertEquals(productsPage.getPriceList().getFirst(), 7.99);
        Assert.assertEquals(productsPage.getPriceList().getLast(), 49.99);
        Driver.closeDriver();


    }
}
