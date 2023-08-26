package liteCart.pages;

import io.qameta.allure.Step;
import liteCart.TestBase;
import org.openqa.selenium.By;

import static liteCart.helpers.WebDriverContainer.setDriver;

public class AccountPage extends TestBase {
    public static final String notLoggedInError = "You must be logged in to view the page.";
    private static final By alertMessage = By.className("alert-warning");

    private static final By signInTitle = By.cssSelector("[id=\"box-login\"] [class=\"card-title\"]");
    public static final String signInTitleText = "Sign In";
    private static final By createAccountTitle = By.cssSelector("[id=\"box-login-create\"] [class=\"card-title\"]");
    public static final String createAccountTitleText = "Create an Account";
    private static final By lostYourPasswordLink = By.cssSelector("[href=\"https://litecart.info/reset_password?email=\"]");
    @Step("Getting text from warning message")
    public static String getNotLoggedInError(){
        LOG.info("Getting text from warning message");
        return setDriver().findElement(alertMessage).getText();
    }
    @Step("Getting text from Sign In title")
    public static String getSignInTitleText() {
        LOG.info("Getting text from Sign In title");
        return setDriver().findElement(signInTitle).getText();
    }
    @Step("Getting text from Create Account title")
    public static String getCreateAccountTitleText() {
        LOG.info("Getting text from Create Account title");
        return setDriver().findElement(createAccountTitle).getText();
    }
    @Step("Clicking 'lost your password?' link")
    public static void lostYourPasswordLinkClick(){
        LOG.info("Clicking 'lost your password?' link");
        setDriver().findElement(lostYourPasswordLink).click();
    }
}
