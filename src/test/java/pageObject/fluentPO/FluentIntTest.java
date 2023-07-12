package pageObject.fluentPO;

import org.testng.annotations.Test;
import pageObject.TestBase;

public class FluentIntTest extends TestBase {

    @Test
    public void unSuccessLoginTest(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithIncorrectCreds().unSuccessMessageIsVisible();
    }
    @Test
    public void successLoginTest(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCorrectCreds();
        homePage.successMessageIsVisible();
    }

}
