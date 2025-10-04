package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.Driver;

public class ESHHomePage {

    private By signup = By.xpath("//a[@href='/login']");
    private By products = By.xpath("//div[@class='col-sm-8' and contains(.,  'Products')]");

    @Step("Click on Signup/Login button")
    public ESHSignupPage clickSignupLogin(){
        Driver.getDriver().findElement(signup).click();
        return new ESHSignupPage();
    }

    @Step("Click on Products button")
    public ESHProductsPage clickProducts(){
        Driver.getDriver().findElement(products).click();
        return new ESHProductsPage();
    }


}
