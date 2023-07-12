package pageObject.fluentPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.name("login");
    private By unSuccessMessage = By.cssSelector(".notice.errors");



    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage setEmailInput(String email){
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public LoginPage setPasswordInput(String password){
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    private void clickLoginButton(){
        driver.findElement(loginButton).click();

    }

    public LoginPage loginWithIncorrectCreds() {
        setEmailInput("vadim.zubovich@gmail.com");
        setPasswordInput("Test1234!");
        clickLoginButton();
        return this;
    }

    public HomePage loginWithCorrectCreds() {
        setEmailInput("1123@123.com");
        setPasswordInput("adDA12341");
        clickLoginButton();
        return new HomePage(driver);
    }
    public LoginPage unSuccessMessageIsVisible(){
        Assert.assertTrue(driver.findElement(unSuccessMessage).isDisplayed());
        return this;
    }
}
