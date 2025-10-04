package pages;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.Driver;

public class ESHProductsPage {

    private String addCartButtonByName = "//div[@class='single-products' and contains(., '%s')]//a";
    private By cartButton = By.xpath("//div[@class='col-sm-8']//ul//a[@href and contains(.,  ' Cart')]");

    @Severity(SeverityLevel.NORMAL)
    @Step("Add product {productName} to cart")
    public ESHProductsPage addProductByName(String productName) {
        Driver.getDriver().findElement(By.xpath(String.format(addCartButtonByName, productName))).click();
        return this;
    }

    @Step("Click Cart button")
    public ESHCartPage clickCart(){
        Driver.getDriver().findElement(cartButton).click();
        return new ESHCartPage();
    }
}
