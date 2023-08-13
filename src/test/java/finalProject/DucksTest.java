package finalProject;

import finalProject.helpers.DataProviderClass;
import finalProject.pages.*;
import io.qameta.allure.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static finalProject.helpers.WebDriverContainer.getDriver;
import static finalProject.helpers.WebDriverContainer.setDriver;

@Epic("Regression Tests")
@Feature("Ducks Tests")
public class DucksTest extends TestBase {

    @BeforeMethod
    void login() throws Exception {
        LoginPage.attemptLogin("1123@123.com", "adDA12341");
    }

    @Test(description = "Checking correct sticker Sale placing")
    @Severity(SeverityLevel.NORMAL)
    @Story("Ducks shopping tests")
    void successSaleStickerOnDuck() {
        LOG.debug("Comparing if every Sale duck is YELLOW");
        HomePage.searchDucksWithOnSaleSticker().forEach(x -> Assert.assertEquals(x.getText(), Duck.YELLOWDUCK.value));
    }

    @Test(description = "Checking correct lower price for Sale ducks")
    @Severity(SeverityLevel.NORMAL)
    @Story("Ducks shopping tests")
    void successCheaperPriceOnSaleDuck() {
        LOG.debug("Comparing if every cheap price duck is YELLOW");
        HomePage.searchDucksWithCheaperPrice().forEach(x -> Assert.assertEquals(x.getText(), Duck.YELLOWDUCK.value));
    }

    @Test(dataProvider = "duckDataProvider", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.NORMAL)
    @Story("Ducks shopping tests")
    void successMainPageMostPopularDuckClick(String duckName) {
        LOG.debug("Checking correct click on most popular duck at Main Page");
        HomePage.clickOnMostPopularDuck(duckName);
        Assert.assertEquals(HomePage.duckTitleIsCorrect(), duckName);
    }

    @Test(description = "Checking correct name sort button click")
    @Severity(SeverityLevel.NORMAL)
    @Story("Ducks shopping tests")
    void successRDSortByName() {
        LOG.info("Checking correct name sort button click");
        VerticalMenu.clickVerticalMenuRDLink();
        RubberDucksPage.assertNameIsOnOrClick();
        List<String> sortedNames = RubberDucksPage.searchDuckNamesList().stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < sortedNames.size(); i++) {
            Assert.assertTrue(sortedNames.get(i).equals(RubberDucksPage.searchDuckNamesList().get(i)));
        }
    }

    @Test(description = "Checking correct price sort button click")
    @Severity(SeverityLevel.NORMAL)
    @Story("Ducks shopping tests")
    void successRDSortByPrice() {
        LOG.info("Checking correct price sort button click");
        VerticalMenu.clickVerticalMenuRDLink();
        RubberDucksPage.assertPriceIsOnOrClick();
        List<Integer> sortedPrices = RubberDucksPage.searchDuckPriceList().stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < sortedPrices.size(); i++) {
            Assert.assertTrue(sortedPrices.get(i).equals(RubberDucksPage.searchDuckPriceList().get(i)));
        }
    }

    @Test(description = "Checking currency change from USD to EURO")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Currency Tests")
    void successCurrencyChange() {
        HomePage.regSettingsChangeLinkClick();
        WebDriverWait wait = new WebDriverWait(setDriver(), Duration.ofSeconds(5));
        LOG.debug("Waiting for currency selector appeared");
        wait.until(ExpectedConditions.presenceOfElementLocated(HomePage.currencySelector));
        HomePage.currencySelectorClick();
        Actions actions = new Actions(setDriver());
        LOG.debug("Choosing EURO by clicking keys");
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        HomePage.submitSettingsButtonClick();
        LOG.debug("Waiting for elements on page appeared after saving");
        wait.until(ExpectedConditions.presenceOfElementLocated(HomePage.euroPriceSymbols));
        HomePage.searchEuroPriceSymbols().forEach(x -> Assert.assertTrue(x.getText().contains("€")));
    }

    @Test(dataProvider = "duckDataProvider", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.NORMAL)
    @Story("Ducks shopping tests")
    void successDuckPageClick(String duckName) {
        LOG.info("Checking correct click on duck at Duck Page");
        VerticalMenu.clickVerticalMenuRDLink();
        RubberDucksPage.clickOnDuck(duckName);
        Assert.assertEquals(HomePage.duckTitleIsCorrect(), duckName);
    }
    @Test(dataProvider = "duckDataProvider", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.MINOR)
    @Story("Ducks shopping tests")
    void successAddToCartButtonText(String duckName){
        LOG.info("Checking correct Add To Cart button text");
        VerticalMenu.clickVerticalMenuRDLink();
        RubberDucksPage.clickOnDuck(duckName);
        Assert.assertEquals(RubberDucksPage.getAddToCartButtonText(), RubberDucksPage.duckQuantitySubmitButtonText);
    }

    @Test(dataProvider = "duckDataProvider", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.NORMAL)
    @Story("Ducks shopping tests")
    void successDuckArrowUpQuantity(String duckName) {
        LOG.info("Checking correct click arrow UP Quantity at Duck Page");
        VerticalMenu.clickVerticalMenuRDLink();
        RubberDucksPage.clickOnDuck(duckName);
        RubberDucksPage.clickOnQuantityInput();
        Actions actions = new Actions(setDriver());
        for (int i = 1; i <= 3; i++) {
            actions.sendKeys(Keys.ARROW_UP).perform();
            Assert.assertEquals(RubberDucksPage.getQuantityFromInput(), i + 1);
        }
    }
    @Test(dataProvider = "duckDataProvider", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.NORMAL)
    @Story("Ducks shopping tests")
    @Flaky
    void successDuckSendKeysQuantity(String duckName) throws InterruptedException {
        LOG.debug("Checking correct sending keys to Quantity at Duck Page");
        VerticalMenu.clickVerticalMenuRDLink();
        RubberDucksPage.clickOnDuck(duckName);
        RubberDucksPage.setQuantityByKeys();
        RubberDucksPage.assertStockStatusAndChooseLargeDuck();
        RubberDucksPage.clickOnDuckQuantitySubmit();
        getDriver().wait(1500);
        Assert.assertEquals(RubberDucksPage.getQuantityFromCart(),String.valueOf(RubberDucksPage.quantityOrder));
    }
    @Test(dataProvider = "duckDataProvider", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.NORMAL)
    @Story("Ducks shopping tests")
    void successDuckDetailColor(String duckName){
        LOG.info("Checking correct duck details color");
        VerticalMenu.clickVerticalMenuRDLink();
        RubberDucksPage.clickOnDuck(duckName);
        RubberDucksPage.duckDetailButtonClick();
        Assert.assertEquals(RubberDucksPage.getDuckColorTextFromDetails(), duckName.contains(" ") ? duckName.split(" ")[0] : duckName);
    }
}