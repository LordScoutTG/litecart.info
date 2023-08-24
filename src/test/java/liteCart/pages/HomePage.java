package liteCart.pages;

import liteCart.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static liteCart.helpers.WebDriverContainer.setDriver;


public class HomePage extends TestBase {

    public static final By successMessage = By.className("alert-success");

    private static final By regSettingsChangeLink = By
            .cssSelector("div > [href=\"https://litecart.info/regional_settings?redirect_url=https%3A%2F%2Flitecart.info%2F#box-regional-settings\"]");

    public static final By currencySelector = By.cssSelector("[name='currency_code']");

    private static final By submitSettingsButton = By.cssSelector("button[name='save']");

    public static final By euroPriceSymbols = By.cssSelector("[class$='price']");

    private static final By duckPageTitle = By.cssSelector("h1[class='title']");

    public static final By duckWithOnSaleSticker = By
            .xpath("//*[@title='On Sale']/parent::div/following::div[1]/h4");

    public static final By duckWithCheaperPrice = By
            .xpath("//*[@class=\"campaign-price\"]/parent::div/preceding::h4[1]");
    private static final By cartButton = By.cssSelector("[id='cart']");


    public static By getMostPopularDuckLocator(String duckName){
        return By.xpath(String.format("//section[@id=\"box-popular-products\"]//a[@title='%s']", duckName));
    }

    @Step("Verify successful login")
    public static boolean successMessageIsVisible() throws Exception {
        LOG.info("Checking success message");
        return setDriver().findElement(successMessage).isDisplayed();
    }
    @Step("Clicking on regional settings")
    public static void regSettingsChangeLinkClick(){
        LOG.info("Clicking on regional settings");
        setDriver().findElement(regSettingsChangeLink).click();
    }
    @Step("Clicking on currency selection")
    public static void currencySelectorClick(){
        LOG.info("Clicking on currency selection");
        setDriver().findElement(currencySelector).click();
    }
    @Step("Saving currency selection")
    public static void submitSettingsButtonClick(){
        LOG.info("Saving currency selection");
        setDriver().findElement(submitSettingsButton).click();
    }
    @Step("Searching for euro elements in goods")
    public static List<WebElement> searchEuroPriceSymbols(){
        LOG.info("Searching for euro elements in goods");
        return new ArrayList<>(setDriver().findElements(euroPriceSymbols));
    }

    @Step("Checking if Duck title is visible")
    public static String duckTitleIsCorrect (){
        LOG.info("Checking if Duck title is visible");
        return setDriver().findElement(duckPageTitle).getText();
    }

    @Step("Searching for ducks with Sale sticker")
    public static List<WebElement> searchDucksWithOnSaleSticker(){
        LOG.info("Searching for ducks with Sale sticker");
        return new ArrayList<>(setDriver().findElements(duckWithOnSaleSticker));
    }

    @Step("Searching for ducks with cheaper price")
    public static List<WebElement> searchDucksWithCheaperPrice(){
        LOG.info("Searching for ducks with cheaper price");
        return new ArrayList<>(setDriver().findElements(duckWithCheaperPrice));
    }

    @Step("Clicking on Most Popular Duck at Main Page")
    public static void clickOnMostPopularDuck(String duckName){
        LOG.info("Clicking on Most Popular Duck at Main Page");
        WebDriverWait wait = new WebDriverWait(setDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(getMostPopularDuckLocator(duckName)));
        setDriver().findElement(getMostPopularDuckLocator(duckName)).click();
    }
    @Step("Clicking on Cart Button")
    public static void clickOnCartButton(){
        LOG.info("Clicking on Cart Button");
        setDriver().findElement(cartButton).click();
    }

}


