package liteCart.pages;

import io.qameta.allure.Step;
import liteCart.TestBase;
import liteCart.helpers.WebDriverContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static liteCart.helpers.WebDriverContainer.setDriver;

public class MainMenu extends TestBase {
    private static final By categoriesMenuButton = By.cssSelector("[class=\"nav-item categories dropdown\"]");
    private static final By categoriesRubberDuckLink = By.cssSelector("[class=\"nav-item\"] > [href=\"https://litecart.info/rubber-ducks-c-1/\"]");
    private static final By verticalCustomerServiceLink = By
            .cssSelector("[class=\"nav-item customer-service\"] > [href=\"https://litecart.info/customer-service\"]");
    private static final By verticalOrderHistoryLink = By
            .cssSelector("[class=\"dropdown-menu dropdown-menu-end\"] [href=\"https://litecart.info/order_history\"]");
    private static final By verticalEditAccountLink = By
            .cssSelector("[class=\"dropdown-menu dropdown-menu-end\"] [href=\"https://litecart.info/edit_account\"]");
    private static final By verticalLogoutLink = By
            .cssSelector("[class=\"dropdown-menu dropdown-menu-end\"] [href=\"https://litecart.info/logout\"]");

    @Step("Clicking on Rubber Ducks link at Main Menu")
    public static void clickMainMenuRDLink(){
        LOG.info("Clicking on Rubber Ducks link at Main Menu");
        WebDriverWait wait = new WebDriverWait(WebDriverContainer.setDriver(), Duration.ofSeconds(5));
        LOG.debug("Waiting for Categories link appeared");
        wait.until(ExpectedConditions.elementToBeClickable(categoriesMenuButton));
        setDriver().findElement(categoriesMenuButton).click();
        LOG.debug("Waiting for RD link appeared");
        wait.until(ExpectedConditions.elementToBeClickable(categoriesRubberDuckLink));
        setDriver().findElement(categoriesRubberDuckLink).click();
    }

    @Step("Clicking on Customer Service at Main Menu")
    public static void verticalCustomerServiceLinkClick(){
        LOG.info("Clicking on Customer Service at Main Menu");
        setDriver().findElement(verticalCustomerServiceLink).click();
    }

    @Step("Clicking on Order History at Main Menu")
    public static void verticalOrderHistoryLinkClick(){
        LOG.info("Clicking on Customer Service at Main Menu");
        setDriver().findElement(verticalOrderHistoryLink).click();
    }
    @Step("Clicking on Edit Account at Main Menu")
    public static void verticalEditAccountLinkClick(){
        LOG.info("Clicking on Customer Service at Main Menu");
        setDriver().findElement(verticalEditAccountLink).click();
    }
    @Step("Clicking on Logout at Main Menu")
    public static void verticalLogoutLinkClick(){
        LOG.info("Clicking on Customer Service at Main Menu");
        setDriver().findElement(verticalLogoutLink).click();
    }
}
