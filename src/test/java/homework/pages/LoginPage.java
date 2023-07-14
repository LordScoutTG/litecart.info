package homework.pages;

import org.openqa.selenium.By;

import static pageObject.helpers.WebDriverContainer.setDriver;

public class LoginPage {

    private final By userNameInput = By.cssSelector("[name='username']");
    private final By passwordInput = By.cssSelector("[name='password']");
    private final By loginButton = By.xpath("//div/button");
    private final By loginLogo = By.xpath("//div/h5");

    public By getLoginLogo() {
        return loginLogo;
    }

    public By getUserNameInput() {
        return userNameInput;
    }

    public void userNameInput(String userName) {
        setDriver().findElement(userNameInput).sendKeys(userName);
    }

    public void passwordInput(String password) {
        setDriver().findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        setDriver().findElement(loginButton).click();
    }

    public void attemptLogin(String userName, String password) {
        userNameInput(userName);
        passwordInput(password);
        clickLoginButton();
    }

    public boolean loginLogoVisible() {
        return setDriver().findElement(loginLogo).isDisplayed();
    }
}

