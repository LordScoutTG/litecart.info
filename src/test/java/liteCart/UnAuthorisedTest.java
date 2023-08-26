package liteCart;

import io.qameta.allure.*;
import liteCart.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.function.Predicate;

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
    @Test(description = "Checking correct required fields at Contact Us form")
    @Severity(SeverityLevel.NORMAL)
    @Story("UnAuthorised tests")
    void successRequiredContactUsFields(){
        LoginPage.acceptCookiesButtonClick();
        HomePage.customerServiceFooterLinkClick();
        LOG.info("Checking correct required fields at Contact Us form");
        for (int i = 0; i < CustomerServicePage.requiredContactUsFieldsText.size(); i++) {
            Assert.assertEquals(CustomerServicePage.searchRequiredContactUsFields().get(i).getText(), CustomerServicePage.requiredContactUsFieldsText.get(i));
        }
    }
    @Test(description = "Checking correct Create Account page Title text")
    @Severity(SeverityLevel.MINOR)
    @Story("UnAuthorised tests")
    void successCreateAccountPageTitleText(){
        LoginPage.acceptCookiesButtonClick();
        HomePage.createAccountFooterLinkClick();
        LOG.info("Checking correct Create Account page Title text");
        Assert.assertEquals(CreateAccountPage.getCreateAccountTitle(), CreateAccountPage.createAccountTitleText);
    }
    @Test(description = "Checking correct required fields at Create Account form")
    @Severity(SeverityLevel.MINOR)
    @Story("UnAuthorised tests")
    void successRequiredCreateAccountFields(){
        LoginPage.acceptCookiesButtonClick();
        HomePage.createAccountFooterLinkClick();
        LOG.info("Checking correct required fields at Create Account form");
        for (int i = 0; i < CreateAccountPage.requiredCreateAccountFieldsText.size(); i++) {
            Assert.assertEquals(CreateAccountPage.searchRequiredCreateAccountFields().get(i).getText(), CreateAccountPage.requiredCreateAccountFieldsText.get(i));
        }
    }
}
