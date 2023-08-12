package finalProject.pages;

import finalProject.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.util.List;
import java.util.stream.Collectors;

import static finalProject.helpers.WebDriverContainer.setDriver;

public class RubberDucksPage extends TestBase {
    public static final String duckQuantitySubmitButtonText = "Add To Cart";
    public static final Integer quantityOrder = 10;
    private static final By rubberDuckTitle = By.xpath("//*[@id='box-category']/h1");
    private static final By nameSortButton = By.cssSelector("[href=\"https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=name\"]");
    private static final By priceSortButton = By.cssSelector("href=\"https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=price\"");
    private static final By duckPrice = By.xpath("//*[@class='price-wrapper']/*[last()]");
    private static final By duckName = By.cssSelector("[class='name']");
    private static final By duckQuantityInput = By.cssSelector("[type='number']");
    private static final By duckQuantitySubmitButton = By.cssSelector("[type='submit']");
    private static final By cartQuantity = By.cssSelector("[class='content'] > [class='quantity']");
    private static final By availableStockStatus = By.cssSelector("[class='stock-available']");
    private static final By sizeOptionsMenu = By.cssSelector("[name='options[Size]']");
    private static final By duckDetailButton = By.cssSelector("[href='#tab-details']");
    private static final By detailsDuckBodyColor = By.xpath("//tbody/tr[@class='row']/td[text()[contains(.,'Body:')]]/following-sibling::td");

    public static By getDuckLocator(String duckName){
        return By.cssSelector(String.format("[alt='%s']", duckName));
    }

    @Step("Checking Rubber Ducks title")
    public static boolean rubberDuckTitleIsVisible(){
        LOG.info("Checking Rubber Ducks title");
        return setDriver().findElement(rubberDuckTitle).isDisplayed();
    }

    @Step("Click on price sort button and check")
    public static void assertPriceIsOnOrClick() {
        LOG.info("Click on price sort button and check");
        try {
            setDriver().findElement(priceSortButton).click();
            setDriver().findElement(priceSortButton);
            Assert.fail();
        } catch (InvalidSelectorException e) {
        }
    }
    @Step("Click on name sort button and check")
    public static void assertNameIsOnOrClick() {
        LOG.info("Click on name sort button and check");
        try {
            setDriver().findElement(nameSortButton).click();
            setDriver().findElement(priceSortButton);
            Assert.fail();
        } catch (InvalidSelectorException e) {
        }
    }
    @Step("Taking all duck prices")
    public static List<Integer> searchDuckPriceList(){
        LOG.info("Taking all duck prices");
        return setDriver().findElements(duckPrice).stream().map(x->x.getText().substring(1)).map(Integer::valueOf)
                .collect(Collectors.toList());
    }
    @Step("Taking all duck names")
    public static List<String> searchDuckNamesList(){
        LOG.info("Taking all duck names");
        return setDriver().findElements(duckName).stream().map(WebElement::getText).collect(Collectors.toList());
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
    @Step("Clicking on Duck Detail button")
    public static void duckDetailButtonClick(){
        LOG.info("Clicking on Duck Detail button");
        setDriver().findElement(duckDetailButton).click();
    }
    @Step("Getting Duck color from details")
    public static String getDuckColorTextFromDetails(){
        LOG.info("Getting Duck color from details");
        return setDriver().findElement(detailsDuckBodyColor).getText();
    }
}
