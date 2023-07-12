package homework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObject.helpers.WebDriverContainer;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        driver = WebDriverContainer.setDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    public void teardown() {
        WebDriverContainer.closeDriver();
    }
}

