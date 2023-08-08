package finalProject.pages;

import finalProject.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerticalMenu extends TestBase {
    private static final By rubberDucksLink = By.xpath("//ul[@class='list-vertical']/li[@class='category-1']/a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']");
    private static final By queryBox = By.cssSelector("[name='query']");
    private static final By checkBoxManufacturer = By.cssSelector("label > input");
    private static final By checkBoxChecked = By.cssSelector("label > input[checked='checked']");
    private static final By verticalCustomerServiceLink = By.xpath("//*[@class='content']//a[@href=\"https://litecart.stqa.ru/en/customer-service-s-0\"]");
    private static final By verticalOrderHistoryLink = By.xpath("//*[@class='content']//a[@href=\"https://litecart.stqa.ru/en/order_history\"]");
    private static final By verticalEditAccountLink = By.xpath("//*[@class='content']//a[@href=\"https://litecart.stqa.ru/en/edit_account\"]");
    private static final By verticalLogoutLink = By.xpath("//*[@class='content']//a[@href=\"https://litecart.stqa.ru/en/logout\"]");


    @Step("Clicking on Rubber Ducks link at Vertical Menu")
    public static void clickVerticalMenuRDLink(WebDriver driver){
        LOG.info("Clicking on Rubber Ducks link at Vertical Menu");
        driver.findElement(rubberDucksLink).click();
    }

    @Step("Query input")
    public static void queryInput(WebDriver driver, String value){
        LOG.info("Query input");
        driver.findElement(queryBox).sendKeys(value);
    }

    @Step("Clicking on manufacturer checkbox")
    public static void checkBoxManufacturerClick(WebDriver driver){
        LOG.info("Clicking on manufacturer checkbox");
        driver.findElement(checkBoxManufacturer).click();
    }
    @Step("Checking if manufacturer checkbox is checked")
    public static boolean checkBoxIsChecked(WebDriver driver){
        LOG.info("Checking if manufacturer checkbox is checked");
        return driver.findElement(checkBoxChecked).isDisplayed();
    }
    @Step("Clicking on Customer Service at vertical Menu")
    public static void verticalCustomerServiceLinkClick(WebDriver driver){
        LOG.info("Clicking on Customer Service at vertical Menu");
        driver.findElement(verticalCustomerServiceLink).click();
    }
    @Step("Clicking on Order History at vertical Menu")
    public static void verticalOrderHistoryLinkClick(WebDriver driver){
        LOG.info("Clicking on Customer Service at vertical Menu");
        driver.findElement(verticalOrderHistoryLink).click();
    }
    @Step("Clicking on Edit Account at vertical Menu")
    public static void verticalEditAccountLinkClick(WebDriver driver){
        LOG.info("Clicking on Customer Service at vertical Menu");
        driver.findElement(verticalEditAccountLink).click();
    }
    @Step("Clicking on Logout at vertical Menu")
    public static void verticalLogoutLinkClick(WebDriver driver){
        LOG.info("Clicking on Customer Service at vertical Menu");
        driver.findElement(verticalLogoutLink).click();
    }
}
