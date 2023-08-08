package finalProject;

import finalProject.pages.HomePage;
import finalProject.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginTest extends TestBase{

    private static final String correctLoginEmail = "1123@123.com";
    private static final String correctLoginPassword = "adDA12341";

    @Test(description="Login with incorrect creds")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Login tests")
    void unsuccessLoginTest() throws Exception {
        LOG.debug("Attempting login with incorrect creds");
        LoginPage.attemptLogin(driver, "vadim.zubovich@gmail.com", "Test1234!");
        Assert.assertTrue(LoginPage.unSuccessMessageIsVisible(driver), "Unsuccessful Login");
    }
    @Test(description="Login with correct creds")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Login tests")
    void successLoginTest() throws Exception {
        LOG.debug("Attempting login with correct creds");
        LoginPage.attemptLogin(driver, correctLoginEmail, correctLoginPassword);
        Assert.assertTrue(HomePage.successMessageIsVisible(driver), "Login was not successful");
    }
}
