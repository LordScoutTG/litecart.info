package liteCart;

import io.qameta.allure.*;
import liteCart.pages.AccountPage;
import liteCart.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Main Menu Tests")
public class UnAuthorisedTest extends TestBase{

    @Test(description="Checking error unlogined message at Account page")
    @Severity(SeverityLevel.NORMAL)
    @Story("UnAuthorised tests")
    void successWarningMessageIsVisible(){
        HomePage.clickOnAccountButton();
        LOG.info("Checking correct warning unlogined message");
        Assert.assertEquals(AccountPage.getNotLoggedInError(), AccountPage.notLoggedInError);
    }


}
