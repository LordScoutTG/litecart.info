package finalProject.pages;

import finalProject.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static finalProject.helpers.Locators.getLocator;


public class LoginPage extends TestBase {

    public static void setEmailInput(WebDriver driver, String email) throws Exception {
        LOG.debug("Writing login email");
        driver.findElement(getLocator("LoginPage.emailInput")).sendKeys(email);
    }

    public static void setPasswordInput(WebDriver driver, String password) throws Exception {
        LOG.debug("Writing login password");
        driver.findElement(getLocator("LoginPage.passwordInput")).sendKeys(password);
    }

    public static void clickLoginButton(WebDriver driver) throws Exception {
        LOG.debug("Clicking login button");
        driver.findElement(getLocator("LoginPage.loginButton")).click();
    }

    @Step("Login step with email: {1}, password: {2}, for method: {method}")
    public static void attemptLogin(WebDriver driver, String email, String password) throws Exception {
        LOG.info("Attempting login");
        setEmailInput(driver, email);
        setPasswordInput(driver, password);
        clickLoginButton(driver);
    }
    public static boolean unSuccessMessageIsVisible(WebDriver driver) throws Exception {
        LOG.info("Checking unsuccessful message");
        return driver.findElement(getLocator("LoginPage.unSuccessMessage")).isDisplayed();
    }
}
