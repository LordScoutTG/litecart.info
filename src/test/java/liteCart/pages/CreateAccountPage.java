package liteCart.pages;

import io.qameta.allure.Step;
import liteCart.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static liteCart.helpers.WebDriverContainer.setDriver;

public class CreateAccountPage extends TestBase {
    private static final By createAccountTitle = By.cssSelector("h1[class=\"card-title\"]");
    public static final String createAccountTitleText = "Create Account";
    private static final By requiredCreateAccountFields = By.xpath("//*[@required]/preceding::label[1][not(@class=\"checkbox\") and not(starts-with(text(),\" Remember Me\"))]");
    public final static ArrayList<String> requiredCreateAccountFieldsText = new ArrayList<>(Arrays.asList("First Name", "Last Name", "Country", "Email", "Desired Password", "Confirm Password", "CAPTCHA"));

    @Step("Getting Title Create Account Page")
    public static String getCreateAccountTitle() {
        LOG.info("Getting Title Create Account Page");
        return setDriver().findElement(createAccountTitle).getText();
    }
    @Step("Searching for fields with label 'required'")
    public static List<WebElement> searchRequiredCreateAccountFields() {
        LOG.info("Searching for fields with label 'required'");
        return new ArrayList<>(setDriver().findElements(requiredCreateAccountFields));
    }
}
