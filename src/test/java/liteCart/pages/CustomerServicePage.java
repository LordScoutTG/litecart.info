package liteCart.pages;

import liteCart.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static liteCart.helpers.WebDriverContainer.setDriver;

public class CustomerServicePage extends TestBase {
    private final static By customerServiceTitle = By.cssSelector("[class=\"card-title\"]");
    private final static By contactUsTitle = By.cssSelector("[class=\"col-md-8\"] h1");

    public final static String customerServiceText = "Customer Service";
    public final static String contactUsText = "Contact Us";

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
}
