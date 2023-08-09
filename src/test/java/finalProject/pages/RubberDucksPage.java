package finalProject.pages;

import finalProject.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.util.List;
import java.util.stream.Collectors;

public class RubberDucksPage extends TestBase {

    private static final By rubberDuckTitle = By.xpath("//*[@id='box-category']/h1");
    private static final By nameSortButton = By.cssSelector("[href=\"https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=name\"]");
    private static final By priceSortButton = By.cssSelector("href=\"https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=price\"");
    private static final By duckPrice = By.xpath("//*[@class='price-wrapper']/*[last()]");
    private static final By duckName = By.cssSelector("[class='name']");
    private static final By duckQuantityInput = By.cssSelector("[type='number']");
    private static final By duckQuantitySubmitButton = By.cssSelector("[type='submit']");
    public static final String duckQuantitySubmitButtonText = "Add To Cart";
    public static final Integer quantityOrder = 10;
    private static final By cartQuantity = By.cssSelector("[class='content'] > [class='quantity']");
    private static final By availableStockStatus = By.cssSelector("[class='stock-available']");
    private static final By sizeOptionsMenu = By.cssSelector("[name='options[Size]']");

    public static By getDuckLocator(String duckName){
        return By.cssSelector(String.format("[alt='%s']", duckName));
    }

    @Step("Checking Rubber Ducks title")
    public static boolean rubberDuckTitleIsVisible(WebDriver driver){
        LOG.info("Checking Rubber Ducks title");
        return driver.findElement(rubberDuckTitle).isDisplayed();
    }

    @Step("Click on price sort button and check")
    public static void assertPriceIsOnOrClick(WebDriver driver) {
        LOG.info("Click on price sort button and check");
        try {
            driver.findElement(priceSortButton).click();
            driver.findElement(priceSortButton);
            Assert.fail();
        } catch (InvalidSelectorException e) {
        }
    }
    @Step("Click on name sort button and check")
    public static void assertNameIsOnOrClick(WebDriver driver) {
        LOG.info("Click on name sort button and check");
        try {
            driver.findElement(nameSortButton).click();
            driver.findElement(priceSortButton);
            Assert.fail();
        } catch (InvalidSelectorException e) {
        }
    }
    @Step("Taking all duck prices")
    public static List<Integer> searchDuckPriceList(WebDriver driver){
        LOG.info("Taking all duck prices");
        return driver.findElements(duckPrice).stream().map(x->x.getText().substring(1)).map(Integer::valueOf)
                .collect(Collectors.toList());
    }
    @Step("Taking all duck names")
    public static List<String> searchDuckNamesList(WebDriver driver){
        LOG.info("Taking all duck names");
        return driver.findElements(duckName).stream().map(WebElement::getText).collect(Collectors.toList());
    }
    @Step("Clicking on Duck at Duck Page")
    public static void clickOnDuck(WebDriver driver, String duckName){
        LOG.info("Clicking on Duck at Duck Page");
        driver.findElement(getDuckLocator(duckName)).click();
    }
    @Step("Clicking on Duck Quantity Input")
    public static void clickOnQuantityInput(WebDriver driver){
        LOG.info("Clicking on Duck Quantity Input");
        driver.findElement(duckQuantityInput).click();
    }
    @Step("Clicking on Duck Quantity Submit Button")
    public static void clickOnDuckQuantitySubmit(WebDriver driver){
        LOG.info("Clicking on Duck Quantity Submit Button");
        driver.findElement(duckQuantitySubmitButton).click();
    }
    @Step("Setting Quantity Input")
    public static Integer getQuantityFromInput(WebDriver driver){
        LOG.info("Setting Quantity Input");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return Integer.parseInt((String) js
                .executeScript("return arguments[0].value", driver.findElement(duckQuantityInput)));
    }
    @Step("Set Quantity sending keys")
    public static void setQuantityByKeys(WebDriver driver){
        LOG.info("Set Quantity sending keys");
        driver.findElement(duckQuantityInput).clear();
        driver.findElement(duckQuantityInput).sendKeys(String.valueOf(quantityOrder));
    }
    @Step("Get Quantity value from Cart box")
    public static String getQuantityFromCart(WebDriver driver){
        LOG.info("Get Quantity value from Cart box");
        return driver.findElement(cartQuantity).getText();
    }
    @Step("Size Options Menu click")
    public static void sizeOptionsMenuClick(WebDriver driver){
        LOG.info("Size Options Menu click");
        driver.findElement(sizeOptionsMenu).click();
    }
    @Step("Choosing small size")
    public static void choosingSmallSizeDuck(WebDriver driver){
        LOG.info("Choosing small size");
        sizeOptionsMenuClick(driver);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
    }
    @Step("Choosing medium size")
    public static void choosingMediumSizeDuck(WebDriver driver){
        LOG.info("Choosing medium size");
        sizeOptionsMenuClick(driver);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }
    @Step("Choosing large size")
    public static void choosingLargeSizeDuck(WebDriver driver){
        LOG.info("Choosing large size");
        sizeOptionsMenuClick(driver);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ENTER);
        actions.perform();
    }
    @Step("Checking if Stock Status Available and choose Small Duck")
    public static void assertStockStatusAndChooseSmallDuck(WebDriver driver){
        LOG.info("Checking if Stock Status Available and choose Small Duck");
        try {
            driver.findElement(availableStockStatus);
            sizeOptionsMenuClick(driver);
            choosingSmallSizeDuck(driver);
        } catch (NoSuchElementException e){
        }
    }
    @Step("Checking if Stock Status Available and choose Medium Duck")
    public static void assertStockStatusAndChooseMediumDuck(WebDriver driver){
        LOG.info("Checking if Stock Status Available and choose Medium Duck");
        try {
            driver.findElement(availableStockStatus);
            choosingMediumSizeDuck(driver);
        } catch (NoSuchElementException e){
        }
    }
    @Step("Checking if Stock Status Available and choose Large Duck")
    public static void assertStockStatusAndChooseLargeDuck(WebDriver driver) {
        LOG.info("Checking if Stock Status Available and choose Large Duck");
        try {
            driver.findElement(availableStockStatus);
            sizeOptionsMenuClick(driver);
            choosingLargeSizeDuck(driver);
        } catch (NoSuchElementException e){
        }
    }
}
