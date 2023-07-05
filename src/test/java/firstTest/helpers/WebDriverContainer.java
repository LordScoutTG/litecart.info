package firstTest.helpers;//package firstTest.helpers;
//
//import com.codeborne.selenide.Browsers;
//import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//public class WebDriverContainer {
//
//    private static Logger LOG = Logger.getLogger(WebDriverContainer.class);
//    private static WebDriver driver;
//
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            Browsers browser = Browsers.valueOf
//
//            switch (browser) {
//                case chrome:
//                    driver = new ChromeDriver();
//                    LOG.info("Initializing Chrome driver");
//                    break;
//                case firefox:
//                    driver = new FirefoxDriver();
//                    LOG.info("Initializing Firefox driver");
//                    break;
//            }
//            driver.manage().window().maximize();
//        }
//        return driver;
//    }
//
//    public static void closeDriver() {
//        LOG.debug("Closing driver");
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
