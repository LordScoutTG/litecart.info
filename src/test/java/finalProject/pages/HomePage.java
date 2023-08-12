package finalProject.pages;

import finalProject.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static finalProject.helpers.Locators.getLocator;
import static finalProject.helpers.WebDriverContainer.setDriver;


public class HomePage extends TestBase {

    private static final By regSettingsChangeLink = By.cssSelector("div > [href='https://litecart.stqa.ru/en/regional_settings']");

    public static final By currencySelector = By.cssSelector("[name='currency_code']");

    private static final By submitSettingsButton = By.cssSelector("button[type='submit']");

    public static final By euroPriceSymbols = By.cssSelector("[class$='price']");

    private static final By duckPageTitle = By.cssSelector("h1[class='title']");

    public static final By duckWithOnSaleSticker = By.xpath("//*[@title='On Sale']/parent::div/following::div[1]");

    public static final By duckWithCheaperPrice = By.xpath("//*[@class=\"campaign-price\"]/parent::div/preceding::div[2]");


    public static By getMostPopularDuckLocator(String duckName){
        return By.xpath(String.format("//div[@id=\"box-most-popular\"]//a[@title='%s'][div]", duckName));
    }






    @Step("Verify successful login")
    public static boolean successMessageIsVisible() throws Exception {
        LOG.info("Checking success message");
        return setDriver().findElement(getLocator("HomePage.successMessage")).isDisplayed();
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
        setDriver().findElement(getMostPopularDuckLocator(duckName)).click();
    }
}


