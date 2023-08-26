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
    public static final By unregisteredErrorMessage = By.cssSelector("[class=\"error\"]");
    public static final String unregisteredErrorNoFirstNameText = "Customer Details: You must enter a first name.";
    public static final String unregisteredErrorNoLastNameText = "Customer Details: You must enter a last name.";
    public static final String unregisteredErrorNoAddressText = "Customer Details: You must enter an address.";
    public static final String unregisteredErrorNoCityText = "Customer Details: You must enter a city.";
    public static final String unregisteredErrorNoEmailText = "Customer Details: You must enter an email address.";
    public static final String unregisteredErrorNoPhoneText = "Customer Details: You must enter a phone number.";
    public static final String unregisteredErrorNoPostCodeText = "Customer Details: You must enter a postcode.";
    public static final By firstNameCartInput = By.name("firstname");
    public static final By lastNameCartInput = By.name("lastname");
    public static final By address1CartInput = By.name("address1");
    public static final By cityCartInput = By.name("city");
    public static final By emailCartInput = By.name("email");
    public static final By phoneCartInput = By.cssSelector("[class=\"input-group\"] [name=\"phone\"]");
    public static final By postCodeCartInput = By.cssSelector("[class=\"form-control\"][name=\"postcode\"]");
    private static final By saveChangesButton = By.cssSelector("[name=\"save_customer_details\"][type='submit']");
    public static final By agreementCheckBoxShoppingForm = By.cssSelector("[class=\"form-check\"][name=\"terms_agreed\"]");


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
    @Step("Getting unregistered error message text")
    public static String getUnregisteredErrorMessageText(){
        LOG.info("Getting unregistered error message text");
        return setDriver().findElement(unregisteredErrorMessage).getText();
    }
    @Step("Saving shopping cart changes")
    public static void savingShoppingCartChanges(){
        LOG.info("Saving shopping cart changes");
        setDriver().findElement(saveChangesButton).click();
    }
}
