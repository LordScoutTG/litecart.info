package liteCart;

import io.qameta.allure.*;
import liteCart.helpers.DataProviderClass;
import liteCart.pages.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import static liteCart.helpers.WebDriverContainer.setDriver;

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
    @Test(dataProvider = "duckDataProvider", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.NORMAL)
    @Story("Ducks shopping tests")
    @Flaky
    void successDuckSendKeysQuantity(String duckName) {
        LOG.debug("Checking correct sending keys to Quantity at Duck Page");
        LoginPage.acceptCookiesButtonClick();
        MainMenu.clickMainMenuRDLink();
        RubberDucksPage.clickOnDuck(duckName);
        RubberDucksPage.setQuantityByKeys();
        RubberDucksPage.assertStockStatusAndChooseLargeDuck();
        RubberDucksPage.clickOnDuckQuantitySubmit();
        WebDriverWait wait = new WebDriverWait(setDriver(), Duration.ofSeconds(5));
        wait.until((ExpectedConditions.textMatches(RubberDucksPage.cartQuantity, Pattern.compile("[1-9]+[0-9]{0,}"))));
        HomePage.clickOnCartButton();
        wait.until(ExpectedConditions.presenceOfElementLocated(CartPage.unregisteredErrorMessage));
        Assert.assertEquals(CartPage.getUnregisteredErrorMessageText(), CartPage.unregisteredErrorNoFirstNameText);
        CartPage.cleaningCart();
    }
}
