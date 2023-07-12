package pageObject.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase{

    private By unSuccessMessage = By.cssSelector(".notice.errors");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean unSuccessMessageIsVisible(){
        return driver.findElement(unSuccessMessage).isDisplayed();
    }

    public boolean hasOpened(){
        return super.hasOpened(driver, "Online Store | My Store");
    }
}
