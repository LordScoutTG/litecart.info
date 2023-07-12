package pageObject.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.name("login");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmailInput(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPasswordInput(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void attemptLogin(String email, String password) {
        setEmailInput(email);
        setPasswordInput(password);
        clickLoginButton();
    }

    public boolean hasOpened(){
        return super.hasOpened(driver, "Online Store | My Store");
    }
}
