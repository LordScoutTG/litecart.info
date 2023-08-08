package finalProject.pages;

import finalProject.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class RubberDucksPage extends TestBase {

    private static final By rubberDuckTitle = By.xpath("//*[@id='box-category']/h1");
    private static final By nameSortButton = By.cssSelector("[href=\"https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=name\"]");
    private static final By priceSortButton = By.cssSelector("href=\"https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=price\"");
    private static final By duckPrice = By.xpath("//*[@class='price-wrapper']/*[last()]");
    private static final By duckName = By.cssSelector("[class='name']");


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
}
