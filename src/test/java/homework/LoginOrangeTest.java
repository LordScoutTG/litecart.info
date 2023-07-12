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
        wait.until(ExpectedConditions.presenceOfElementLocated(mainPage.getDirectoryButton()));
        mainPage.directoryButtonClick();
        wait.until(ExpectedConditions.presenceOfElementLocated(mainPage.getDirectoryHeader()));
        Assert.assertTrue(mainPage.directoryHeaderVisible("Directory"), "Direcory header missing");

    }

    @Test
    public void logoutTest() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        WebDriverWait wait = new WebDriverWait(WebDriverContainer.setDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getUserNameInput()));
        loginPage.attemptLogin("Admin", "admin123");
        wait.until(ExpectedConditions.presenceOfElementLocated(mainPage.getDirectoryButton()));
        mainPage.avatarClick();
        mainPage.logoutButtonClick();
        wait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getLoginLogo()));
        Assert.assertTrue(loginPage.loginLogoVisible(), "No Login displayed");
    }
}
