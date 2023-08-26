package liteCart.pages;

import liteCart.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static liteCart.helpers.WebDriverContainer.setDriver;

public class CustomerServicePage extends TestBase {
    private final static By customerServiceTitle = By.cssSelector("[class=\"card-title\"]");
    private final static By contactUsTitle = By.cssSelector("[class=\"col-md-8\"] h1");
    private final static By resetPasswordTitle = By.cssSelector("[id=\"box-reset-password\"] [class=\"card-title\"]");

    public final static String customerServiceText = "Customer Service";
    public final static String contactUsText = "Contact Us";
    public final static String resetPasswordText = "Reset Password";

    @Step("Getting Title Customer Service Page")
    public static String getCustomerServiceTitle(){
        LOG.info("Getting Title Customer Service Page");
        return setDriver().findElement(customerServiceTitle).getText();
    }
    @Step("Getting Title Contact Us block")
    public static String getContactUsTitle(){
        LOG.info("Getting Title Contact Us block");
        return setDriver().findElement(contactUsTitle).getText();
    }
    @Step("Getting Title Reset Password block")
    public static String getResetPasswordTitle(){
        LOG.info("Getting Title Reset Password block");
        return setDriver().findElement(resetPasswordTitle).getText();
    }
}
