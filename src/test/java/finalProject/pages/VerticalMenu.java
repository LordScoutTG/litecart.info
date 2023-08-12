package finalProject.pages;

import finalProject.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static finalProject.helpers.WebDriverContainer.setDriver;

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
    public static void clickVerticalMenuRDLink(){
        LOG.info("Clicking on Rubber Ducks link at Vertical Menu");
        setDriver().findElement(rubberDucksLink).click();
    }

    @Step("Query input")
    public static void queryInput(String value){
        LOG.info("Query input");
        setDriver().findElement(queryBox).sendKeys(value);
    }

    @Step("Clicking on manufacturer checkbox")
    public static void checkBoxManufacturerClick(){
        LOG.info("Clicking on manufacturer checkbox");
        setDriver().findElement(checkBoxManufacturer).click();
    }
    @Step("Checking if manufacturer checkbox is checked")
    public static boolean checkBoxIsChecked(){
        LOG.info("Checking if manufacturer checkbox is checked");
        return setDriver().findElement(checkBoxChecked).isDisplayed();
    }
    @Step("Clicking on Customer Service at vertical Menu")
    public static void verticalCustomerServiceLinkClick(){
        LOG.info("Clicking on Customer Service at vertical Menu");
        setDriver().findElement(verticalCustomerServiceLink).click();
    }
    @Step("Clicking on Order History at vertical Menu")
    public static void verticalOrderHistoryLinkClick(){
        LOG.info("Clicking on Customer Service at vertical Menu");
        setDriver().findElement(verticalOrderHistoryLink).click();
    }
    @Step("Clicking on Edit Account at vertical Menu")
    public static void verticalEditAccountLinkClick(){
        LOG.info("Clicking on Customer Service at vertical Menu");
        setDriver().findElement(verticalEditAccountLink).click();
    }
    @Step("Clicking on Logout at vertical Menu")
    public static void verticalLogoutLinkClick(){
        LOG.info("Clicking on Customer Service at vertical Menu");
        setDriver().findElement(verticalLogoutLink).click();
    }
}
