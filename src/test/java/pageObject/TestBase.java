package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void init() {
        Browsers browser =  Browsers.valueOf(System.getProperty("browser", "chrome"));

        switch (browser) {
            case chrome: driver = new ChromeDriver();
            break;
            case firefox: driver = new FirefoxDriver();
            break;
            default: driver = new ChromeDriver();
        }


        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void teardown() {

            driver.quit();


    }
}

