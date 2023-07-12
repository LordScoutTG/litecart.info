package pageObject.staticPO;

import org.openqa.selenium.WebDriver;

import static pageObject.helpers.Locators.getLocator;

public class HomePage {

    public static boolean successMessageIsVisible(WebDriver driver) throws Exception {
        return driver.findElement(getLocator("HomePage.successMessage")).isDisplayed();
    }
}
