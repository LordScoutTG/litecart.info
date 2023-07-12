package homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;

import static pageObject.helpers.WebDriverContainer.setDriver;

public class LoginPage {

    private By userNameInput = By.cssSelector("[name='username']");
    private By passwordInput = By.cssSelector("[name='password']");
    private By loginButton = By.xpath("//div/button");

    private By loginLogo = By.xpath("//div/h5");

    public By getLoginLogo() {
        return loginLogo;
    }

    public void userNameInput(String userName){
        setDriver().findElement(userNameInput).sendKeys(userName);
    }

    public void passwordInput(String password){
        setDriver().findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton(){
        setDriver().findElement(loginButton).click();
    }

    public void attemptLogin(String userName, String password) {
        userNameInput(userName);
        passwordInput(password);
        clickLoginButton();
    }

    public By getUserNameInput() {
        return userNameInput;
    }

    public boolean loginLogoVisible(){
        return setDriver().findElement(loginLogo).isDisplayed();
    }
}

