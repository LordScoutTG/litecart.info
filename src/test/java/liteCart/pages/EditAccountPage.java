package liteCart.pages;

import liteCart.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static liteCart.helpers.WebDriverContainer.setDriver;

public class EditAccountPage extends TestBase {
    private static final By editAccountTitle = By.cssSelector("h2[class=\"card-title\"]");
    public static final String editAccountTitleText = "Account";

    @Step("Getting Title Edit Account Page")
    public static String getEditAccountTitle(){
        LOG.info("Getting Title Edit Account Page");
        return setDriver().findElement(editAccountTitle).getText();
    }
}
