package pageObject.staticPO;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.TestBase;

public class StaticPageObjectTest extends TestBase {



    @Test
    public void unsuccessLoginTest() throws Exception {
        LoginPage.attemptLogin(driver, "vadim.zubovich@gmail.com", "Test1234!");
        Assert.assertTrue(LoginPage.unSuccessMessageIsVisible(driver), "Unsuccessful Login");

    }
    @Test
    public void successLoginTest() throws Exception {

        LoginPage.attemptLogin(driver, "1123@123.com", "adDA12341");
        Assert.assertTrue(HomePage.successMessageIsVisible(driver), "Login was successful");
    }

}


