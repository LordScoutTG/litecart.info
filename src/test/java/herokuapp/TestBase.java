package herokuapp;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObject.helpers.ScreenshotListener;
import pageObject.helpers.WebDriverContainer;

@Listeners(ScreenshotListener.class)
public class TestBase {


    WebDriver driver;

    @BeforeMethod
    public void initDriver() {
       driver = WebDriverContainer.setDriver();
       driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterMethod
    public void teardown() {
        WebDriverContainer.closeDriver();
    }
}
