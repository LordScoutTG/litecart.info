package liteCart;

import liteCart.pages.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static liteCart.helpers.WebDriverContainer.setDriver;


@Epic("Regression Tests")
@Feature("Main Menu Tests")
public class MainMenuTest extends TestBase {
    @BeforeMethod
    void login() throws Exception {
        LoginPage.attemptLogin( "1123@123.com", "adDA12341");
    }
    @Test(description="Checking Rubber Duck link in Main Menu")
    @Severity(SeverityLevel.NORMAL)
    @Story("Links tests")
    void successVerticalMenuRDLinkClick(){
        MainMenu.clickMainMenuRDLink();
        Assert.assertTrue(RubberDucksPage.rubberDuckTitleIsVisible(), "Unsuccessful link click");
    }
    @Test(description = "Checking correct Customer Service link click in Main Menu")
    @Severity(SeverityLevel.NORMAL)
    @Story("Links tests")
    void successCustomerServiceLinkClick(){
        MainMenu.verticalCustomerServiceLinkClick();
        Assert.assertEquals(CustomerServicePage.getCustomerServiceTitle(), CustomerServicePage.customerServiceText);
        Assert.assertEquals(CustomerServicePage.getContactUsTitle(), CustomerServicePage.contactUsText);
    }
    @Test(description = "Checking correct Order History link click in Main Menu")
    @Severity(SeverityLevel.NORMAL)
    @Story("Links tests")
    void successOrderHistoryLinkClick(){
        LoginPage.signInMenuClick();
        MainMenu.verticalOrderHistoryLinkClick();
        Assert.assertEquals(OrderHistoryPage.getOrderHistoryPageTitle(), OrderHistoryPage.orderHistoryTitleText);
    }
    @Test(description = "Checking correct Edit Account link click in Main Menu")
    @Severity(SeverityLevel.NORMAL)
    @Story("Links tests")
    void successEditAccountLinkClick(){
        LoginPage.signInMenuClick();
        MainMenu.verticalEditAccountLinkClick();
        Assert.assertEquals(EditAccountPage.getEditAccountTitle(), EditAccountPage.editAccountTitleText);
    }
    @Test(description = "Checking correct Logout link click in Main Menu")
    @Severity(SeverityLevel.NORMAL)
    @Story("Links tests")
    void successLogoutLinkClick(){
        LoginPage.signInMenuClick();
        MainMenu.verticalLogoutLinkClick();
        Assert.assertEquals(setDriver().findElement(HomePage.successMessage).getText(), LoginPage.logoutMessage);
    }
}
