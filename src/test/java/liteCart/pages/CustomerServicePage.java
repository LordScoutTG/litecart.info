package liteCart.pages;

import liteCart.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static liteCart.helpers.WebDriverContainer.setDriver;

public class CustomerServicePage extends TestBase {
    private final static By customerServiceTitle = By.cssSelector("[class=\"card-title\"]");
    private final static By contactUsTitle = By.cssSelector("[class=\"col-md-8\"] h1");
    private final static By resetPasswordTitle = By.cssSelector("[id=\"box-reset-password\"] [class=\"card-title\"]");
    private static final By requiredContactUsFields = By.xpath("//input[@required]/preceding::label[1] | //textarea[@required]/preceding::label[1]");
    public final static String customerServiceText = "Customer Service";
    public final static String contactUsText = "Contact Us";
    public final static String resetPasswordText = "Reset Password";
    public final static ArrayList<String> requiredContactUsFieldsText = new ArrayList<>(Arrays.asList("First Name", "Last Name", "Email Address", "Subject", "Message", "CAPTCHA"));

    @Step("Getting Title Customer Service Page")
    public static String getCustomerServiceTitle() {
        LOG.info("Getting Title Customer Service Page");
        return setDriver().findElement(customerServiceTitle).getText();
    }

    @Step("Getting Title Contact Us block")
    public static String getContactUsTitle() {
        LOG.info("Getting Title Contact Us block");
        return setDriver().findElement(contactUsTitle).getText();
    }

    @Step("Getting Title Reset Password block")
    public static String getResetPasswordTitle() {
        LOG.info("Getting Title Reset Password block");
        return setDriver().findElement(resetPasswordTitle).getText();
    }

    @Step("Searching for fields with label 'required'")
    public static List<WebElement> searchRequiredContactUsFields() {
        LOG.info("Searching for fields with label 'required'");
        return new ArrayList<>(setDriver().findElements(requiredContactUsFields));
    }

}
