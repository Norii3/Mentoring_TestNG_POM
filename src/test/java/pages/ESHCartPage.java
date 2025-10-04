package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.Driver;

public class ESHCartPage {

    private By checkout = By.cssSelector(".check_out");

    @Step("Proceed to checkout")
    public ESHCheckoutPage clickCheckout(){
        Driver.getDriver().findElement(checkout).click();
        return new ESHCheckoutPage();
    }


}
