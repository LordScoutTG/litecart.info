package finalProject;

import finalProject.pages.HomePage;
import finalProject.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginTest extends TestBase{

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
        LoginPage.attemptLogin(driver, "1123@123.com", "adDA12341");
        Assert.assertTrue(HomePage.successMessageIsVisible(driver), "Login was not successful");
    }
}
