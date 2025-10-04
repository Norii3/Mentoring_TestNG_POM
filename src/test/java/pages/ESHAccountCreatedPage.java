package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.Driver;

public class ESHAccountCreatedPage {

    private By continueBtn = By.xpath("//a[@href and contains(., 'Continue')]");

    @Step("Click Continue button")
    public ESHHomePage clickContinue(){
        Driver.getDriver().findElement(continueBtn).click();
        return new ESHHomePage();
    }
}
