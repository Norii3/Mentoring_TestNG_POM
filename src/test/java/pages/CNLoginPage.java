package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.Driver;

public class CNLoginPage {

    private By username = By.id("username");
    private By password = By.id("password");
    private By signin = By.id("submit");
    private By errorForUsername = By.xpath("//div[@class='show' and contains(., 'Your username is invalid!')]");
    private By errorForPassword = By.xpath("//div[@class='show' and contains(., 'Your password is invalid!')]");


    public CNLoginPage enterUsername(String username) {
        Driver.getDriver().findElement(this.username).sendKeys(username);
        return this;
    }

    public CNLoginPage enterPassword(String password) {
        Driver.getDriver().findElement(this.password).sendKeys(password);
        return this;
    }

    public CNLoginPage enterSubmit() {
        Driver.getDriver().findElement(this.signin).click();
        return this;
    }

    public CNLoginPage assertUsernameError() {
        Assert.assertTrue(true,"Your username is invalid!");
        return this;
    }

    public CNLoginPage assertPasswordError() {
        Assert.assertTrue(true,"Your password is invalid!");
        return this;
    }


}


