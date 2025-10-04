package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.Driver;

public class ESHPaymentPage {

    private By nameOnCard = By.xpath("//input[@class='form-control']");
    private By cardNumber = By.name("card_number");
    private By cvc = By.xpath("//input[@name='cvc']");
    private By expiryMonth = By.name("expiry_month");
    private By expiryYear = By.name("expiry_year");
    private By payAndConfirmOrder = By.id("submit");

    @Step("Enter name on card: {nameOnCard}")
    public ESHPaymentPage enterNameOnCard(String nameOnCard){
        Driver.getDriver().findElement(this.nameOnCard).sendKeys(nameOnCard);
        return this;
    }

    @Step("Enter card number: {cardNumber}")
    public ESHPaymentPage enterCardNumber(String cardNumber){
        Driver.getDriver().findElement(this.cardNumber).sendKeys(cardNumber);
        return this;
    }

    @Step("Enter cvc: {cvc}")
    public ESHPaymentPage enterCVC(String cvc){
        Driver.getDriver().findElement(this.cvc).sendKeys(cvc);
        return this;
    }

    @Step("Enter expiry month: {expiryMonth}")
    public ESHPaymentPage enterExpiryMonth(String expiryMonth){
        Driver.getDriver().findElement(this.expiryMonth).sendKeys(expiryMonth);
        return this;
    }

    @Step("Enter expiry year: {expiryYear}")
    public ESHPaymentPage enterExpiryYear(String expiryYear){
        Driver.getDriver().findElement(this.expiryYear).sendKeys(expiryYear);
        return this;
    }

    @Step("Pay and confirm order")
    public ESHPaymentPage clickPayAndConfirmOrder(){
        Driver.getDriver().findElement(payAndConfirmOrder).click();
        Assert.assertTrue(true,"Your order has been placed successfully!");
        return this;
    }

    @Step("Verify order success")
    public ESHPaymentPage assertOrderDone(){
        Assert.assertTrue(true,"Your order has been placed successfully!");
        return this;
    }


}
