package finalProject.pages;

import finalProject.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static finalProject.helpers.WebDriverContainer.setDriver;

public class OrderHistoryPage extends TestBase {
    private static final By orderHistoryTitle = By.cssSelector("[class='title']");
    public static final String orderHistoryTitleText = "Order History";

    @Step("Getting Title Order History Page")
    public static String getOrderHistoryPageTitle(){
        LOG.info("Getting Title Order History Page");
        return setDriver().findElement(orderHistoryTitle).getText();
    }
}
