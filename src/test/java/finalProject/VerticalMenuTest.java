package finalProject;

import finalProject.pages.*;
import io.qameta.allure.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static pageObject.helpers.Locators.getLocator;

@Epic("Regression Tests")
@Feature("Vertical Menu Tests")
public class VerticalMenuTest extends TestBase{
    @BeforeMethod
    void login() throws Exception {
        LoginPage.attemptLogin(driver, "1123@123.com", "adDA12341");
    }

    @Test(description="Checking Rubber Duck link in Vertical Menu")
    @Severity(SeverityLevel.NORMAL)
    @Story("Links tests")
    void successVerticalMenuRDLinkClick(){
        VerticalMenu.clickVerticalMenuRDLink(driver);
        Assert.assertTrue(RubberDucksPage.rubberDuckTitleIsVisible(driver), "Unsuccessful link click");
    }

    @Test(description="Checking successful click on checkbox in Vertical Menu")
    @Severity(SeverityLevel.MINOR)
    @Story("Checkbox tests")
    void successCheckBoxManufacturerClick(){
        VerticalMenu.clickVerticalMenuRDLink(driver);
        VerticalMenu.checkBoxManufacturerClick(driver);
        Assert.assertTrue(VerticalMenu.checkBoxIsChecked(driver), "Checkbox is not checked");
    }

    @Test(description = "Checking correct Yellow Duck search in Vertical Menu")
    @Severity(SeverityLevel.MINOR)
    @Story("Search tests")
    void successSearchYellowDuck(){
        VerticalMenu.queryInput(driver, Duck.YELLOWDUCK.value);
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        Assert.assertEquals(HomePage.duckTitleIsCorrect(driver), Duck.YELLOWDUCK.value);
    }

    @Test(description = "Checking correct Red Duck search in Vertical Menu")
    @Severity(SeverityLevel.MINOR)
    @Story("Search tests")
    void successSearchRedDuck(){
        VerticalMenu.queryInput(driver, Duck.REDDUCK.value);
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        Assert.assertEquals(HomePage.duckTitleIsCorrect(driver), Duck.REDDUCK.value);
    }

    @Test(description = "Checking correct Green Duck search in Vertical Menu")
    @Severity(SeverityLevel.MINOR)
    @Story("Search tests")
    void successSearchGreenDuck(){
        VerticalMenu.queryInput(driver, Duck.GREENDUCK.value);
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        Assert.assertEquals(HomePage.duckTitleIsCorrect(driver), Duck.GREENDUCK.value);
    }

    @Test(description = "Checking correct Blue Duck search in Vertical Menu")
    @Severity(SeverityLevel.MINOR)
    @Story("Search tests")
    void successSearchBlueDuck(){
        VerticalMenu.queryInput(driver, Duck.BLUEDUCK.value);
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        Assert.assertEquals(HomePage.duckTitleIsCorrect(driver), Duck.BLUEDUCK.value);
    }

    @Test(description = "Checking correct Purple Duck search in Vertical Menu")
    @Severity(SeverityLevel.MINOR)
    @Story("Search tests")
    void successSearchPurpleDuck(){
        VerticalMenu.queryInput(driver, Duck.PURPLEDUCK.value);
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        Assert.assertEquals(HomePage.duckTitleIsCorrect(driver), Duck.PURPLEDUCK.value);
    }
    @Test(description = "Checking correct Customer Service link click in Vertical Menu")
    @Severity(SeverityLevel.NORMAL)
    @Story("Links tests")
    void successCustomerServiceLinkClick(){
        VerticalMenu.verticalCustomerServiceLinkClick(driver);
        Assert.assertEquals(CustomerServicePage.getCustomerServiceTitle(driver), CustomerServicePage.customerServiceText);
        Assert.assertEquals(CustomerServicePage.getContactUsTitle(driver), CustomerServicePage.contactUsText);
    }
    @Test(description = "Checking correct Order History link click in Vertical Menu")
    @Severity(SeverityLevel.NORMAL)
    @Story("Links tests")
    void successOrderHistoryLinkClick(){
        VerticalMenu.verticalOrderHistoryLinkClick(driver);
        Assert.assertEquals(OrderHistoryPage.getOrderHistoryPageTitle(driver), OrderHistoryPage.orderHistoryTitleText);
    }
    @Test(description = "Checking correct Edit Account link click in Vertical Menu")
    @Severity(SeverityLevel.NORMAL)
    @Story("Links tests")
    void successEditAccountLinkClick(){
        VerticalMenu.verticalEditAccountLinkClick(driver);
        Assert.assertEquals(EditAccountPage.getEditAccountTitle(driver), EditAccountPage.editAccountTitleText);
    }
    @Test(description = "Checking correct Logout link click in Vertical Menu")
    @Severity(SeverityLevel.NORMAL)
    @Story("Links tests")
    void successLogoutLinkClick() throws Exception {
        VerticalMenu.verticalLogoutLinkClick(driver);
        Assert.assertEquals(driver.findElement(getLocator("HomePage.successMessage")).getText(), LoginPage.logoutMessage);
    }
}
