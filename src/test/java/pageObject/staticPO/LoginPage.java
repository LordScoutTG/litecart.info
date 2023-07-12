package pageObject.staticPO;

import org.openqa.selenium.WebDriver;

import static pageObject.helpers.Locators.getLocator;

public class LoginPage {

    public static void setEmailInput(WebDriver driver, String email) throws Exception {
        driver.findElement(getLocator("LoginPage.emailInput")).sendKeys(email);
    }

    public static void setPasswordInput(WebDriver driver, String password) throws Exception {
        driver.findElement(getLocator("LoginPage.passwordInput")).sendKeys(password);
    }

    public static void clickLoginButton(WebDriver driver) throws Exception {
        driver.findElement(getLocator("LoginPage.loginButton")).click();
    }

    public static void attemptLogin(WebDriver driver, String email, String password) throws Exception {
        setEmailInput(driver, email);
        setPasswordInput(driver, password);
        clickLoginButton(driver);
    }
    public static boolean unSuccessMessageIsVisible(WebDriver driver) throws Exception {
        return driver.findElement(getLocator("LoginPage.unSuccessMessage")).isDisplayed();
    }
}
