package liteCart.pages;

import liteCart.TestBase;
import io.qameta.allure.Step;
import liteCart.helpers.WebDriverContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static liteCart.helpers.WebDriverContainer.setDriver;

public class CartPage extends TestBase {
    private static final String emptyCartText = "There are no items in your cart.";
    private static final By removeFromCartButton = By.cssSelector("[name=\"remove_cart_item\"]");
    private static final By cartTitle = By.cssSelector("[class=\"cart wrapper\"] [class=\"card-title\"]");
    private static final By cartText = By.cssSelector("[class=\"text-center\"]");

    @Step("Clicking Remove from Cart button")
    public static void clickRemoveFromCartButton() {
        LOG.info("Clicking Remove from Cart button");
        setDriver().findElement(removeFromCartButton).click();
    }

    @Step("Checking remove button is Visible")
    public static void ifRemoveButtonIsVisible() {
        WebDriverWait wait = new WebDriverWait(WebDriverContainer.setDriver(), Duration.ofSeconds(5));
        LOG.debug("Waiting for Cart title appeared");
        wait.until(ExpectedConditions.presenceOfElementLocated(cartTitle));
        LOG.info("Checking remove button is Visible");
        setDriver().findElement(removeFromCartButton);
    }

    @Step("Cleaning Cart")
    public static void cleaningCart() {
        LOG.info("Cleaning Cart");
        HomePage.clickOnCartButton();
        try {
            ifRemoveButtonIsVisible();
            clickRemoveFromCartButton();
        } catch (NoSuchElementException e) {

        }
        WebDriverWait wait = new WebDriverWait(WebDriverContainer.setDriver(), Duration.ofSeconds(5));
        LOG.debug("Waiting empty cart text appeared");
        wait.until(ExpectedConditions.presenceOfElementLocated(cartText));
        Assert.assertEquals(setDriver().findElement(cartText).getText(), emptyCartText);
    }
}
