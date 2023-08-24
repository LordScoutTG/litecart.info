package finalProject.pages;

import finalProject.TestBase;
import io.qameta.allure.Step;

import static finalProject.helpers.Locators.getLocator;
import static finalProject.helpers.WebDriverContainer.setDriver;


public class LoginPage extends TestBase {

    public static final String logoutMessage = "You are now logged out.";


    public static void setEmailInput(String email) throws Exception {
        LOG.debug("Writing login email");
        setDriver().findElement(getLocator("LoginPage.emailInput")).sendKeys(email);
    }

    public static void setPasswordInput(String password) throws Exception {
        LOG.debug("Writing login password");
        setDriver().findElement(getLocator("LoginPage.passwordInput")).sendKeys(password);
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
        return setDriver().findElement(getLocator("LoginPage.unSuccessMessage")).isDisplayed();
    }
}
