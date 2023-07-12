package herokuapp;


import herokuapp.basicauth.BasicAuthPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.helpers.WebDriverContainer;


import static pageObject.helpers.Locators.getLocator;
import static pageObject.helpers.WebDriverContainer.setDriver;

public class BasicAuthTest extends TestBase{



    @BeforeMethod
    public void comeFromMain() throws Exception {
        WebDriverContainer.setDriver().findElement(getLocator("MainPage.basicAuth")).click();

    }
    @Test
    public static void insertText(){

        setDriver().get("https://admin:admin@the-internet.herokuapp.com/basic_auth");  // в базовую авторизацию данные передаются гет запросом
        Assert.assertTrue(BasicAuthPage.successMessageIsVisible(), "Congratulations! You must have the proper credentials.");

    }
}
