package herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObject.Browsers;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void initDriver(){
        Browsers browser =  Browsers.valueOf(System.getProperty("browser", "chrome"));

        switch (browser) {
            case chrome: driver = new ChromeDriver();
                break;
            case firefox: driver = new FirefoxDriver();
                break;
            default: driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
