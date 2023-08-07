package finalProject.pages;

import finalProject.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static finalProject.helpers.Locators.getLocator;


public class HomePage extends TestBase {

    private static final By regSettingsChangeLink = By.cssSelector("div > [href='https://litecart.stqa.ru/en/regional_settings']");

    public static final By currencySelector = By.cssSelector("[name='currency_code']");

    private static final By submitSettingsButton = By.cssSelector("button[type='submit']");

    public static final By euroPriceSymbols = By.cssSelector("[class$='price']");

    private static final By duckPageTitle = By.cssSelector("h1[class='title']");

    public static final By duckWithOnSaleSticker = By.xpath("//*[@title='On Sale']/parent::div/following::div[1]");

    public static final By duckWithCheaperPrice = By.xpath("//*[@class=\"campaign-price\"]/parent::div/preceding::div[2]");




    @Step("Verify successful login")
    public static boolean successMessageIsVisible(WebDriver driver) throws Exception {
        LOG.info("Checking success message");
        return driver.findElement(getLocator("HomePage.successMessage")).isDisplayed();
    }
    @Step("Clicking on regional settings")
    public static void regSettingsChangeLinkClick(WebDriver driver){
        LOG.info("Clicking on regional settings");
        driver.findElement(regSettingsChangeLink).click();
    }
    @Step("Clicking on currency selection")
    public static void currencySelectorClick(WebDriver driver){
        LOG.info("Clicking on currency selection");
        driver.findElement(currencySelector).click();
    }
    @Step("Saving currency selection")
    public static void submitSettingsButtonClick(WebDriver driver){
        LOG.info("Saving currency selection");
        driver.findElement(submitSettingsButton).click();
    }
    @Step("Searching for euro elements in goods")
    public static List<WebElement> searchEuroPriceSymbols(WebDriver driver){
        LOG.info("Searching for euro elements in goods");
        return new ArrayList<>(driver.findElements(euroPriceSymbols));
    }

    @Step("Checking if Duck title is visible")
    public static String duckTitleIsCorrect (WebDriver driver){
        LOG.info("Checking if Duck title is visible");
        return driver.findElement(duckPageTitle).getText();
    }

    @Step("Searching for ducks with Sale sticker")
    public static List<WebElement> searchDucksWithOnSaleSticker(WebDriver driver){
        LOG.info("Searching for ducks with Sale sticker");
        return new ArrayList<>(driver.findElements(duckWithOnSaleSticker));
    }

    @Step("Searching for ducks with cheaper price")
    public static List<WebElement> searchDucksWithCheaperPrice(WebDriver driver){
        LOG.info("Searching for ducks with cheaper price");
        return new ArrayList<>(driver.findElements(duckWithCheaperPrice));
    }
}


