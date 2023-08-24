package liteCart.pages;

import liteCart.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static liteCart.helpers.WebDriverContainer.setDriver;

public class RubberDucksPage extends TestBase {
    public static final String duckQuantitySubmitButtonText = "Add To Cart";
    public static final Integer quantityOrder = 10;
    private static final By rubberDuckTitle = By.cssSelector("h1[class='title']");
    private static final By duckQuantityInput = By.cssSelector("[type='number']");
    private static final By duckQuantitySubmitButton = By.cssSelector("[type='submit']");
    public static final By cartQuantity = By.cssSelector("[class=\"badge quantity\"]");
    private static final By availableStockStatus = By.cssSelector("[class='stock-available']");
    private static final By sizeOptionsMenu = By.cssSelector("[name='options[Size]']");
    private static final By detailsDuckBodyColor = By
            .xpath("//table[@class=\"table table-striped table-hover\"]//td[text()[contains(.,'Body')]]/following-sibling::td");

    public static By getDuckLocator(String duckName){
        return By.cssSelector(String.format("[alt='%s']", duckName));
    }

    @Step("Checking Rubber Ducks title")
    public static boolean rubberDuckTitleIsVisible(){
        LOG.info("Checking Rubber Ducks title");
        return setDriver().findElement(rubberDuckTitle).isDisplayed();
    }

    @Step("Clicking on Duck at Duck Page")
    public static void clickOnDuck(String duckName){
        LOG.info("Clicking on Duck at Duck Page");
        setDriver().findElement(getDuckLocator(duckName)).click();
    }
    @Step("Clicking on Duck Quantity Input")
    public static void clickOnQuantityInput(){
        LOG.info("Clicking on Duck Quantity Input");
        setDriver().findElement(duckQuantityInput).click();
    }
    @Step("Clicking on Duck Quantity Submit Button")
    public static void clickOnDuckQuantitySubmit(){
        LOG.info("Clicking on Duck Quantity Submit Button");
        setDriver().findElement(duckQuantitySubmitButton).click();
    }
    @Step("Setting Quantity Input")
    public static int getQuantityFromInput(){
        LOG.info("Setting Quantity Input");
        JavascriptExecutor js = (JavascriptExecutor) setDriver();
        return Integer.parseInt((String) js
                .executeScript("return arguments[0].value", setDriver().findElement(duckQuantityInput)));
    }
    @Step("Set Quantity sending keys")
    public static void setQuantityByKeys(){
        LOG.info("Set Quantity sending keys");
        setDriver().findElement(duckQuantityInput).clear();
        setDriver().findElement(duckQuantityInput).sendKeys(String.valueOf(quantityOrder));
    }
    @Step("Get Quantity value from Cart box")
    public static String getQuantityFromCart(){
        LOG.info("Get Quantity value from Cart box");
        return setDriver().findElement(cartQuantity).getText();
    }
    @Step("Size Options Menu click")
    public static void sizeOptionsMenuClick(){
        LOG.info("Size Options Menu click");
        setDriver().findElement(sizeOptionsMenu).click();
    }
    @Step("Choosing small size")
    public static void choosingSmallSizeDuck(){
        LOG.info("Choosing small size");
        sizeOptionsMenuClick();
        Actions actions = new Actions(setDriver());
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
    }
    @Step("Choosing medium size")
    public static void choosingMediumSizeDuck(){
        LOG.info("Choosing medium size");
        sizeOptionsMenuClick();
        Actions actions = new Actions(setDriver());
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }
    @Step("Choosing large size")
    public static void choosingLargeSizeDuck(){
        LOG.info("Choosing large size");
        sizeOptionsMenuClick();
        Actions actions = new Actions(setDriver());
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ENTER);
        actions.perform();
    }
    @Step("Checking if Stock Status Available and choose Small Duck")
    public static void assertStockStatusAndChooseSmallDuck(){
        LOG.info("Checking if Stock Status Available and choose Small Duck");
        try {
            setDriver().findElement(availableStockStatus);
            sizeOptionsMenuClick();
            choosingSmallSizeDuck();
        } catch (NoSuchElementException e){
        }
    }
    @Step("Checking if Stock Status Available and choose Medium Duck")
    public static void assertStockStatusAndChooseMediumDuck(){
        LOG.info("Checking if Stock Status Available and choose Medium Duck");
        try {
            setDriver().findElement(availableStockStatus);
            choosingMediumSizeDuck();
        } catch (NoSuchElementException e){
        }
    }
    @Step("Checking if Stock Status Available and choose Large Duck")
    public static void assertStockStatusAndChooseLargeDuck() {
        LOG.info("Checking if Stock Status Available and choose Large Duck");
        try {
            setDriver().findElement(availableStockStatus);
            sizeOptionsMenuClick();
            choosingLargeSizeDuck();
        } catch (NoSuchElementException e){
        }
    }
    @Step("Checking correct submit button text")
    public static String getAddToCartButtonText(){
        LOG.info("Checking correct submit button text");
       return setDriver().findElement(duckQuantitySubmitButton).getText();
    }

    @Step("Getting Duck color from details")
    public static String getDuckColorTextFromDetails(){
        LOG.info("Getting Duck color from details");
        return setDriver().findElement(detailsDuckBodyColor).getText();
    }
}
