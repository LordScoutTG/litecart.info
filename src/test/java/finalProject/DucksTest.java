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

@Epic("Regression Tests")
@Feature("Ducks Tests")
public class DucksTest extends TestBase{

    @BeforeMethod
    void login() throws Exception {
        LoginPage.attemptLogin(driver, "1123@123.com", "adDA12341");
    }

    @Test(description = "Checking correct sticker Sale placing")
    @Severity(SeverityLevel.NORMAL)
    @Story("Ducks shopping tests")
    void successSaleStickerOnDuck(){
        LOG.debug("Comparing if every Sale duck is YELLOW");
        HomePage.searchDucksWithOnSaleSticker(driver).forEach(x->Assert.assertEquals(x.getText(), Duck.YELLOWDUCK.value));
    }

    @Test(description = "Checking correct lower price for Sale ducks")
    @Severity(SeverityLevel.NORMAL)
    @Story("Ducks shopping tests")
    void successCheaperPriceOnSaleDuck(){
        LOG.debug("Comparing if every cheap price duck is YELLOW");
        HomePage.searchDucksWithCheaperPrice(driver).forEach(x-> Assert.assertEquals(x.getText(), Duck.YELLOWDUCK.value));
    }

    @Test(dataProvider = "duckDataProvider", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.NORMAL)
    @Story("Ducks shopping tests")
    void successMainPageMostPopularDuckClick(String duckName){
        LOG.debug("Checking correct click on most popular duck at Main Page");
        HomePage.clickOnMostPopularDuck(driver, duckName);
        Assert.assertEquals(HomePage.duckTitleIsCorrect(driver), duckName);
    }
    @Test(description = "Checking correct name sort button click")
    @Severity(SeverityLevel.NORMAL)
    @Story("Ducks shopping tests")
    void successRDSortByName(){
        LOG.info("Checking correct name sort button click");
        VerticalMenu.clickVerticalMenuRDLink(driver);
        RubberDucksPage.assertNameIsOnOrClick(driver);
        List<String> sortedNames = RubberDucksPage.searchDuckNamesList(driver).stream().sorted().collect(Collectors.toList());
        for(int i = 0; i < sortedNames.size(); i++){
            Assert.assertTrue(sortedNames.get(i).equals(RubberDucksPage.searchDuckNamesList(driver).get(i)));
        }
    }
    @Test(description = "Checking correct price sort button click")
    @Severity(SeverityLevel.NORMAL)
    @Story("Ducks shopping tests")
    void successRDSortByPrice(){
        LOG.info("Checking correct price sort button click");
        VerticalMenu.clickVerticalMenuRDLink(driver);
        RubberDucksPage.assertPriceIsOnOrClick(driver);
        List<Integer> sortedPrices = RubberDucksPage.searchDuckPriceList(driver).stream().sorted().collect(Collectors.toList());
        for(int i = 0; i < sortedPrices.size(); i++){
            Assert.assertTrue(sortedPrices.get(i).equals(RubberDucksPage.searchDuckPriceList(driver).get(i)));
        }
    }

    @Test(description="Checking currency change from USD to EURO")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Currency Tests")
    void successCurrencyChange() {
        HomePage.regSettingsChangeLinkClick(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        LOG.debug("Waiting for currency selector appeared");
        wait.until(ExpectedConditions.presenceOfElementLocated(HomePage.currencySelector));
        HomePage.currencySelectorClick(driver);
        Actions actions = new Actions(driver);
        LOG.debug("Choosing EURO by clicking keys");
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        HomePage.submitSettingsButtonClick(driver);
        LOG.debug("Waiting for elements on page appeared after saving");
        wait.until(ExpectedConditions.presenceOfElementLocated(HomePage.euroPriceSymbols));
        HomePage.searchEuroPriceSymbols(driver).forEach(x -> Assert.assertTrue(x.getText().contains("€")));
    }
}
