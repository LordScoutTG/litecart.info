package finalProject;

import finalProject.pages.*;
import io.qameta.allure.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static finalProject.helpers.WebDriverContainer.setDriver;
import static pageObject.helpers.Locators.getLocator;

@Epic("Regression Tests")
@Feature("Vertical Menu Tests")
public class VerticalMenuTest extends TestBase{
    @BeforeMethod
    void login() throws Exception {
        LoginPage.attemptLogin( "1123@123.com", "adDA12341");
    }

    @Test(description="Checking Rubber Duck link in Vertical Menu")
    @Severity(SeverityLevel.NORMAL)
    @Story("Links tests")
    void successVerticalMenuRDLinkClick(){
        VerticalMenu.clickVerticalMenuRDLink();
        Assert.assertTrue(RubberDucksPage.rubberDuckTitleIsVisible(), "Unsuccessful link click");
    }

    @Test(description="Checking successful click on checkbox in Vertical Menu")
    @Severity(SeverityLevel.MINOR)
    @Story("Checkbox tests")
    void successCheckBoxManufacturerClick(){
        VerticalMenu.clickVerticalMenuRDLink();
        VerticalMenu.checkBoxManufacturerClick();
        Assert.assertTrue(VerticalMenu.checkBoxIsChecked(), "Checkbox is not checked");
    }

    @Test(description = "Checking correct Yellow Duck search in Vertical Menu")
    @Severity(SeverityLevel.MINOR)
    @Story("Search tests")
    void successSearchYellowDuck(){
        VerticalMenu.queryInput(Duck.YELLOWDUCK.value);
        new Actions(setDriver()).sendKeys(Keys.ENTER).perform();
        Assert.assertEquals(HomePage.duckTitleIsCorrect(), Duck.YELLOWDUCK.value);
    }

    @Test(description = "Checking correct Red Duck search in Vertical Menu")
    @Severity(SeverityLevel.MINOR)
    @Story("Search tests")
    void successSearchRedDuck(){
        VerticalMenu.queryInput(Duck.REDDUCK.value);
        new Actions(setDriver()).sendKeys(Keys.ENTER).perform();
        Assert.assertEquals(HomePage.duckTitleIsCorrect(), Duck.REDDUCK.value);
    }

    @Test(description = "Checking correct Green Duck search in Vertical Menu")
    @Severity(SeverityLevel.MINOR)
    @Story("Search tests")
    void successSearchGreenDuck(){
        VerticalMenu.queryInput(Duck.GREENDUCK.value);
        new Actions(setDriver()).sendKeys(Keys.ENTER).perform();
        Assert.assertEquals(HomePage.duckTitleIsCorrect(), Duck.GREENDUCK.value);
    }

    @Test(description = "Checking correct Blue Duck search in Vertical Menu")
    @Severity(SeverityLevel.MINOR)
    @Story("Search tests")
    void successSearchBlueDuck(){
        VerticalMenu.queryInput(Duck.BLUEDUCK.value);
        new Actions(setDriver()).sendKeys(Keys.ENTER).perform();
        Assert.assertEquals(HomePage.duckTitleIsCorrect(), Duck.BLUEDUCK.value);
    }

    @Test(description = "Checking correct Purple Duck search in Vertical Menu")
    @Severity(SeverityLevel.MINOR)
    @Story("Search tests")
    void successSearchPurpleDuck(){
        VerticalMenu.queryInput(Duck.PURPLEDUCK.value);
        new Actions(setDriver()).sendKeys(Keys.ENTER).perform();
        Assert.assertEquals(HomePage.duckTitleIsCorrect(), Duck.PURPLEDUCK.value);
    }
    @Test(description = "Checking correct Customer Service link click in Vertical Menu")
    @Severity(SeverityLevel.NORMAL)
    @Story("Links tests")
    void successCustomerServiceLinkClick(){
        VerticalMenu.verticalCustomerServiceLinkClick();
        Assert.assertEquals(CustomerServicePage.getCustomerServiceTitle(), CustomerServicePage.customerServiceText);
        Assert.assertEquals(CustomerServicePage.getContactUsTitle(), CustomerServicePage.contactUsText);
    }
    @Test(description = "Checking correct Order History link click in Vertical Menu")
    @Severity(SeverityLevel.NORMAL)
    @Story("Links tests")
    void successOrderHistoryLinkClick(){
        VerticalMenu.verticalOrderHistoryLinkClick();
        Assert.assertEquals(OrderHistoryPage.getOrderHistoryPageTitle(), OrderHistoryPage.orderHistoryTitleText);
    }
    @Test(description = "Checking correct Edit Account link click in Vertical Menu")
    @Severity(SeverityLevel.NORMAL)
    @Story("Links tests")
    void successEditAccountLinkClick(){
        VerticalMenu.verticalEditAccountLinkClick();
        Assert.assertEquals(EditAccountPage.getEditAccountTitle(), EditAccountPage.editAccountTitleText);
    }
    @Test(description = "Checking correct Logout link click in Vertical Menu")
    @Severity(SeverityLevel.NORMAL)
    @Story("Links tests")
    void successLogoutLinkClick() throws Exception {
        VerticalMenu.verticalLogoutLinkClick();
        Assert.assertEquals(setDriver().findElement(getLocator("HomePage.successMessage")).getText(), LoginPage.logoutMessage);
    }
}
