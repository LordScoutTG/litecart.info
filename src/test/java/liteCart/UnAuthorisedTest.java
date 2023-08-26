package liteCart;

import io.qameta.allure.*;
import liteCart.pages.AccountPage;
import liteCart.pages.CustomerServicePage;
import liteCart.pages.HomePage;
import liteCart.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Main Menu Tests")
public class UnAuthorisedTest extends TestBase{

    @Test(description="Checking error unlogined message at Account page")
    @Severity(SeverityLevel.NORMAL)
    @Story("UnAuthorised tests")
    void successWarningMessageIsVisible(){
        LoginPage.acceptCookiesButtonClick();
        HomePage.clickOnAccountButton();
        LOG.info("Checking correct warning unlogined message");
        Assert.assertEquals(AccountPage.getNotLoggedInError(), AccountPage.notLoggedInError);
    }

    @Test(description = "Checking correct unauthorised sign in page Title text")
    @Severity(SeverityLevel.NORMAL)
    @Story("UnAuthorised tests")
    void successUnAuthorisedSignInPageHeadersText(){
        LoginPage.acceptCookiesButtonClick();
        HomePage.loginLinkClick();
        LOG.info("Checking correct unauthorised sign in page Title text");
        Assert.assertEquals(AccountPage.getSignInTitleText(), AccountPage.signInTitleText);
        Assert.assertEquals(AccountPage.getCreateAccountTitleText(), AccountPage.createAccountTitleText);
    }
    @Test(description = "Checking correct Reset Password page Title text")
    @Severity(SeverityLevel.MINOR)
    @Story("UnAuthorised tests")
    void successResetPasswordPageTitleText(){
        LoginPage.acceptCookiesButtonClick();
        HomePage.loginLinkClick();
        AccountPage.lostYourPasswordLinkClick();
        LOG.info("Checking correct Reset Password page Title text");
        Assert.assertEquals(CustomerServicePage.getResetPasswordTitle(), CustomerServicePage.resetPasswordText);
    }

}
