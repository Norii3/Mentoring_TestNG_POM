package tasks;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ESHHomePage;
import utilities.Driver;
import utilities.MyTestListener;

@Epic("E-commerce Platform")
@Feature("User Management")
@Feature("Shopping Cart")
@Feature("Checkout Process")
@Listeners(MyTestListener.class)
public class F18T3T4_EcommerceShoppingAllureAndExtentReports {

/*
    Target: https://automationexercise.com/
        Test Scenario:
    1. Navigate to the application
    2. Sign up a new user account
    3. Add 3 products to cart
    4. Complete the shopping process (checkout)
        Allure Organization:
    - @Epic("E-commerce Platform")
    - @Feature("User Management") for signup
    - @Feature("Shopping Cart") for cart operations
    - @Feature("Checkout Process") for payment
        Page Objects Requirements:
    - All page methods must have @Step annotations
    - Use descriptive step names like "Add product {productName} to cart"
    - Include parameter values in @Step descriptions
        Allure Annotations Required:
    - @Description explaining the business scenario
    - @Severity: CRITICAL for signup and checkout, NORMAL for cart operations
    - @Story annotations for each user journey
    - @Attachment for screenshots of cart and checkout pages
*/
    @Test
    @Description("End-to-end test for user signup, cart operation, and checkout process")
    @Story("Complete user registration and purchase flow")

    void ESHAllureReportsTest(){

        ESHHomePage homePage = new ESHHomePage();

        Driver.getDriver().get("https://automationexercise.com/");
        homePage
                .clickSignupLogin()
                .enterName("Jack")
                .enterEmail(Faker.instance().internet().emailAddress())
                .clickSignup()
                .clickTitle()
                .enterPassword("123")
                .enterFirstname("Jack")
                .enterLastname("hulk")
                .enterAddress(Faker.instance().address().fullAddress())
                .selectCountry("India")
                .enterState("India")
                .enterCity("Delhi")
                .enterZipcode("110006")
                .enterMobileNumber(Faker.instance().phoneNumber().phoneNumber())
                .clickCreateAccount()
                .clickContinue()
                .clickProducts()
                .addProductByName("Blue Top")
                .addProductByName("Men Tshirt")
                .addProductByName("Sleeveless Dress")
                .clickCart()
                .clickCheckout()
                .clickPlaceOrder()
                .enterNameOnCard(Faker.instance().name().fullName())
                .enterCardNumber(Faker.instance().finance().creditCard())
                .enterCVC(Faker.instance().number().digits(3))
                .enterExpiryMonth("09")
                .enterExpiryYear("2028")
                .clickPayAndConfirmOrder()
                .assertOrderDone()
        ;
    }
}
