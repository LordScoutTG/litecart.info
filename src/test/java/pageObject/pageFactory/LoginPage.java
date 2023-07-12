package pageObject.pageFactory;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginButton;


    public void setEmailInput(String email){
        emailInput.sendKeys(email);
    }

    public void setPasswordInput(String password){
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void attemptLogin(String email, String password) {
        setEmailInput(email);
        setPasswordInput(password);
        clickLoginButton();
    }
}
