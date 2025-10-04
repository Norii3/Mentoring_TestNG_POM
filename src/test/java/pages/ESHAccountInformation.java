package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class ESHAccountInformation {

    private By title = By.id("id_gender2");
    private By password = By.id("password");
    private By firstname = By.id("first_name");
    private By lastname = By.id("last_name");
    private By address = By.id("address1");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobileNumber = By.id("mobile_number");
    private By createAccount = By.xpath("//button[@type='submit' and contains(., 'Create Account')]");

    @Step("Select title")
    public ESHAccountInformation clickTitle(){
        Driver.getDriver().findElement(title).click();
        return this;
    }

    @Step("Enter password")
    public ESHAccountInformation enterPassword(String password){
        Driver.getDriver().findElement(this.password).sendKeys(password);
        return this;
    }

    @Step("Enter first name: {firstName}")
    public ESHAccountInformation enterFirstname(String firstname){
        Driver.getDriver().findElement(this.firstname).sendKeys(firstname);
        return this;
    }

    @Step("Enter first name: {lastName}")
    public ESHAccountInformation enterLastname(String lastname){
        Driver.getDriver().findElement(this.lastname).sendKeys(lastname);
        return this;
    }

    @Step("Enter address: {address}")
    public ESHAccountInformation enterAddress(String address){
        Driver.getDriver().findElement(this.address).sendKeys(address);
        return this;
    }

    @Step("Enter country: {country}")
    public ESHAccountInformation selectCountry(String country){
        new Select(Driver.getDriver().findElement(this.country)).selectByVisibleText(country);
        return this;
    }

    @Step("Enter state: {state}")
    public ESHAccountInformation enterState(String state){
        Driver.getDriver().findElement(this.state).sendKeys(state);
        return this;
    }

    @Step("Enter city: {city}")
    public ESHAccountInformation enterCity(String city){
        Driver.getDriver().findElement(this.city).sendKeys(city);
        return this;
    }

    @Step("Enter Zipcode: {zipcode}")
    public ESHAccountInformation enterZipcode(String zipcode){
        Driver.getDriver().findElement(this.zipcode).sendKeys(zipcode);
        return this;
    }

    @Step("Enter MobileNumber: {mobileNumber}")
    public ESHAccountInformation enterMobileNumber(String mobileNumber){
        Driver.getDriver().findElement(this.mobileNumber).sendKeys(mobileNumber);
        return this;
    }

    @Step("Create account")
    public ESHAccountCreatedPage clickCreateAccount(){
        Driver.getDriver().findElement(createAccount).click();
        return new ESHAccountCreatedPage();
    }



}
