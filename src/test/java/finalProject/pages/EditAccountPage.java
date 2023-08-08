package finalProject.pages;

import finalProject.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditAccountPage extends TestBase {
    private static final By editAccountTitle = By.cssSelector("[class='title']");
    public static final String editAccountTitleText = "Edit Account";

    @Step("Getting Title Edit Account Page")
    public static String getEditAccountTitle(WebDriver driver){
        LOG.info("Getting Title Edit Account Page");
        return driver.findElement(editAccountTitle).getText();
    }
}
