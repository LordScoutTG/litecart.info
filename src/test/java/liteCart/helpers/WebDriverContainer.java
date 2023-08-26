package liteCart.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;


public class WebDriverContainer {

    private static Logger LOG = Logger.getLogger(WebDriverContainer.class);
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();           // Создаём потокобезопасный драйвер

    public static WebDriver getDriver(){                                                // Геттер для драйвера. Работаем только через него
        return driver.get();
    }

    public static WebDriver setDriver(){
        if (getDriver() == null) {
            Browsers browser = Browsers.valueOf(System.getProperty("browser", "chrome"));
            System.setProperty("webdriver.http.factory", "jdk-http-client"); // Устраняет ошибку асинхр клиента
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
//            options.addArguments("--start-maximized");
            options.addArguments("window-size=1920x1080");
            switch (browser) {
                case chrome:
                    driver.set(ThreadGuard.protect(new ChromeDriver(options)));
                    LOG.info("Initializing Chrome driver");
                    break;
                case firefox:
                    driver.set(ThreadGuard.protect(new FirefoxDriver()));
                    LOG.info("Initializing Firefox driver");
                    break;
            }
            getDriver().manage().window().maximize();
//            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        }
        return getDriver();
    }

    public static void closeDriver() {
        LOG.debug("Closing driver");
        if (getDriver() != null) {
            getDriver().manage().deleteAllCookies();
            getDriver().quit();
            driver.remove();                                                // снимаем потокобезопасность
        }
    }
}