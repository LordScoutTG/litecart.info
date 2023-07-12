package homework;

import homework.pages.LoginPage;
import homework.pages.MainPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.helpers.WebDriverContainer;

import java.time.Duration;

public class LoginOrangeTest extends TestBase{

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        WebDriverWait wait = new WebDriverWait(WebDriverContainer.setDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getUserNameInput()));
        loginPage.attemptLogin("Admin", "admin123");
        wait.until(ExpectedConditions.presenceOfElementLocated(mainPage.getAvatarVisible()));

        Assert.assertTrue(mainPage.confirmAvatarVisible(), "Avatar was not found");
    }

    @Test
    public void logoutTest(){
        loginTest();
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        mainPage.avatarClick();
        mainPage.logoutButtonClick();
        WebDriverWait wait = new WebDriverWait(WebDriverContainer.setDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getLoginLogo()));
        Assert.assertTrue(loginPage.loginLogoVisible(), "No Login displayed");
    }
}
