package herokuapp;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObject.helpers.ScreenshotListener;
import pageObject.helpers.WebDriverContainer;

@Listeners(ScreenshotListener.class)
public class TestBase {


    WebDriver driver;

//    @BeforeMethod
//    public void initDriver() {
//       driver = WebDriverContainer.setDriver();
//       driver.get("https://www.gismeteo.ru/diary/5003/2010/8/");
//    }

    @AfterMethod
    public void teardown() {
        WebDriverContainer.closeDriver();
    }
}
