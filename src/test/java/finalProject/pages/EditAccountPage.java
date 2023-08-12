package finalProject.pages;

import finalProject.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static finalProject.helpers.WebDriverContainer.setDriver;

public class EditAccountPage extends TestBase {
    private static final By editAccountTitle = By.cssSelector("[class='title']");
    public static final String editAccountTitleText = "Edit Account";

    @Step("Getting Title Edit Account Page")
    public static String getEditAccountTitle(){
        LOG.info("Getting Title Edit Account Page");
        return setDriver().findElement(editAccountTitle).getText();
    }
}
