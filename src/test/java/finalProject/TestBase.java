package finalProject;

import finalProject.helpers.Browsers;
import finalProject.helpers.ScreenshotListener;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


@Listeners(ScreenshotListener.class)
public class TestBase {
    public WebDriver driver;
    protected static Logger LOG = Logger.getLogger(TestBase.class);

    @BeforeMethod
    @Step("Open ducks url Step...")
    public void setDriver() {
        Browsers browser =  Browsers.valueOf(System.getProperty("browser", "chrome"));
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        switch (browser) {
            case chrome: driver = new ChromeDriver();
                LOG.info("Initializing Chrome driver");
                break;
            case firefox: driver = new FirefoxDriver();
                LOG.info("Initializing Firefox driver");
                break;
            default: driver = new ChromeDriver();
        }


        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    @Step("Closing driver")
    public void closeDriver() {
        LOG.info("Closing driver");
        if (driver != null) {
            driver.quit();
        }
    }
}
