package pageObject.object;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.TestBase;

public class PageObjectTest extends TestBase {

    @Test
    public void loginTest(){


        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.attemptLogin("vadim.zubovich@gmail.com", "Test1234!");
        Assert.assertTrue(homePage.unSuccessMessageIsVisible(), "Login was successfull");
    }
    @Test
    public void homePageLoadedTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.attemptLogin("1123@123.com", "adDA12341");
        Assert.assertTrue(homePage.hasOpened(), "Home page has not opened");
    }
}
