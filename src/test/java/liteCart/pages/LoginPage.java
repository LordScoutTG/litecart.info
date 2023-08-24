package liteCart.pages;

import liteCart.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static liteCart.helpers.Locators.getLocator;
import static liteCart.helpers.WebDriverContainer.setDriver;


public class LoginPage extends TestBase {
    private static final By unSuccessMessage = By.className("alert-danger");
    private static final By acceptCookies = By.cssSelector("[name=\"accept_cookies\"]");
    public static final String logoutMessage = "You are now logged out.";
    public static final By openSignIn = By.cssSelector("[class=\"nav-item account dropdown\"]>[data-toggle=\"dropdown\"]");
    private static final By emailInputBox = By.cssSelector("[name=\"login_form\"] [name=\"email\"]");
    private static final By passwordInputBox = By.cssSelector("[name=\"login_form\"] [name=\"password\"]");


    public static void setEmailInput(String email) throws Exception {
        LOG.debug("Accepting cookies");
        setDriver().findElement(acceptCookies).click();
        LOG.debug("Clicking sign in button");
        setDriver().findElement(openSignIn).click();
        WebDriverWait wait = new WebDriverWait(setDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(emailInputBox));
        LOG.debug("Writing login email");
        setDriver().findElement(emailInputBox).sendKeys(email);
    }

    public static void setPasswordInput(String password) throws Exception {
        LOG.debug("Writing login password");
        setDriver().findElement(passwordInputBox).sendKeys(password);
    }

    public static void clickLoginButton() throws Exception {
        LOG.debug("Clicking login button");
        setDriver().findElement(getLocator("LoginPage.loginButton")).click();
    }

    @Step("Login step with email: {1}, password: {2}, for method: {method}")
    public static void attemptLogin(String email, String password) throws Exception {
        LOG.info("Attempting login");
        setEmailInput(email);
        setPasswordInput(password);
        clickLoginButton();
    }

    public static boolean unSuccessMessageIsVisible() throws Exception {
        LOG.info("Checking unsuccessful message");
        return setDriver().findElement(unSuccessMessage).isDisplayed();
    }
}
