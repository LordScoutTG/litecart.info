package liteCart.pages;

import io.qameta.allure.Step;
import liteCart.TestBase;
import org.openqa.selenium.By;

import static liteCart.helpers.WebDriverContainer.setDriver;

public class AccountPage extends TestBase {
    public static final String notLoggedInError = "You must be logged in to view the page.";

    private static final By alertMessage = By.className("alert-warning");

    @Step("Getting text from warning message")
    public static String getNotLoggedInError(){
        LOG.info("Getting text from warning message");
        return setDriver().findElement(alertMessage).getText();
    }
}
