package finalProject.pages;

import finalProject.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerServicePage extends TestBase {
    private final static By customerServiceTitle = By.cssSelector("[id='box-information-links'] > [class='title']");
    private final static By contactUsTitle = By.cssSelector("[id='box-contact-us'] > [class='title']");

    public final static String customerServiceText = "Customer Service";
    public final static String contactUsText = "Contact Us";

    @Step("Getting Title Customer Service Page")
    public static String getCustomerServiceTitle(WebDriver driver){
        LOG.info("Getting Title Customer Service Page");
        return driver.findElement(customerServiceTitle).getText();
    }
    @Step("Getting Title Contact Us block")
    public static String getContactUsTitle(WebDriver driver){
        LOG.info("Getting Title Contact Us block");
        return driver.findElement(contactUsTitle).getText();
    }
}
