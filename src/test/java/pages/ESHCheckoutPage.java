package pages;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.Driver;

public class ESHCheckoutPage {

    private By placeOrder = By.cssSelector(".check_out");

    @Severity(SeverityLevel.CRITICAL)
    @Step("Place Order")
    public ESHPaymentPage clickPlaceOrder(){
        Driver.getDriver().findElement(placeOrder).click();
        return new ESHPaymentPage();
    }
}
