package herokuapp.addremove;

import org.openqa.selenium.WebDriver;

import static pageObject.helpers.Locators.getLocator;

public class AddRemovePage {

    public static void addButtonClick(WebDriver driver) throws Exception {
        driver.findElement(getLocator("AddRemove.addButton")).click();
    }

    public static void removeButtonClick(WebDriver driver) throws Exception {
        driver.findElement(getLocator("AddRemove.deleteButton")).click();
    }
    public static boolean removeButtonIsVisible(WebDriver driver) throws Exception {
        return driver.findElement(getLocator("AddRemove.deleteButton")).isDisplayed();
    }
}
