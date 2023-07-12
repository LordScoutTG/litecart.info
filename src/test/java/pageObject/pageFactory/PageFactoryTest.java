package pageObject.pageFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.TestBase;

public class PageFactoryTest extends TestBase {


    @Test
    public void loginTest(){


        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        loginPage.attemptLogin("1123@123.com", "adDA12341");
        Assert.assertTrue(homePage.successMessageIsVisible(), "Login was unsuccessfull");
    }
}
