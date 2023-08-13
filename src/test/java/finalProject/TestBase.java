package finalProject;


import finalProject.helpers.ScreenshotListener;
import finalProject.helpers.WebDriverContainer;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;



public class TestBase {
    public static Logger LOG = Logger.getLogger(TestBase.class);
    @BeforeMethod
    public void initDriver() {
        WebDriverContainer.setDriver().get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void teardown() {
        WebDriverContainer.closeDriver();
    }
}

