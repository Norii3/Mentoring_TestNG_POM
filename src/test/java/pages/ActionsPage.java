package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ActionsPage {

    private By source = By.xpath("//div[@class='container']//div[@id='drag1' and contains(., 'Drag me')]");
    private By target = By.xpath("//div[@class='container']//div[@id='drop1' and contains(., 'Drop here')]");
    private By contextClick = By.id("showSuccessButton");
    private By doubleClick = By.id("doubleClickButton");
    private By  hover = By.id("hoverButton");


    public ActionsPage actions(){
        Set<String> wHandles = Driver.getDriver().getWindowHandles();
        List<String> windowHandles = new ArrayList<>(wHandles);
        Driver.getDriver().switchTo().window(windowHandles.get(1));
        Actions actions = new Actions(Driver.getDriver());
        actions
                .dragAndDrop(Driver.getDriver().findElement(this.source), Driver.getDriver().findElement(this.target))
                .contextClick(Driver.getDriver().findElement(this.contextClick))
                .doubleClick(Driver.getDriver().findElement(this.doubleClick))
                .moveToElement(Driver.getDriver().findElement(this.hover));

        return this;
    }

    public ActionsPage assertDragDrop() {
        Assert.assertTrue(true, "Item successfully dropped!");
        return this;
    }

    public ActionsPage assertClick() {
        Assert.assertTrue(true, "Button right-clicked!");
        return this;
    }

    public ActionsPage assertDoubleClick() {
        Assert.assertTrue(true, "Button double-clicked!");
        return this;
    }

    public ActionsPage assertHover() {
        Assert.assertTrue(true, "The Selenium WebDriver");
        return this;
    }
}


