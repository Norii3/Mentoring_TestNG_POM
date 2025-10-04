package pages;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.Driver;

public class ESHSignupPage {

    private By name = By.xpath("//input[@name='name']");
    private By email = By.xpath("//input[@data-qa='signup-email']");
    private By submit = By.xpath("//button[@data-qa='signup-button']");

    @Step("Enter name: {name}")
    public ESHSignupPage enterName(String name){
        Driver.getDriver().findElement(this.name).sendKeys(name);
        return this;
    }

    @Step("Enter email: {email}")
    public ESHSignupPage enterEmail(String email){
        Driver.getDriver().findElement(this.email).sendKeys(email);
        return this;
    }

    @Severity(SeverityLevel.CRITICAL)
    @Step("Click on Signup button")
    public ESHAccountInformation clickSignup(){
        Driver.getDriver().findElement(submit).click();
        return new ESHAccountInformation();
    }

}
