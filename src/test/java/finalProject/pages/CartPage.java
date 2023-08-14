package finalProject.pages;

import finalProject.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static finalProject.helpers.WebDriverContainer.setDriver;

public class CartPage extends TestBase {
    private static final By removeFromCartButton = By.cssSelector("[name='remove_cart_item']");

    @Step("Clicking Remove from Cart button")
    public static void clickRemoveFromCartButton(){
        LOG.info("Clicking Remove from Cart button");
        setDriver().findElement(removeFromCartButton).click();
    }
    @Step("Checking remove button is Visible")
    public static void ifRemoveButtonIsVisible(){
        LOG.info("Checking remove button is Visible");
        setDriver().findElement(removeFromCartButton);
    }
    @Step("Cleaning Cart")
    public static void cleaningCart(){
        LOG.info("Cleaning Cart");
        HomePage.clickOnCartButton();
        try {
            ifRemoveButtonIsVisible();
            clickRemoveFromCartButton();
        }catch (NoSuchElementException e) {

        }
    }
}
