package herokuapp.basicauth;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static pageObject.helpers.WebDriverContainer.setDriver;

public class BasicAuthPage {


    private static By confirm = By.xpath("//div/p");

    public static boolean successMessageIsVisible(){
        return setDriver().findElement(confirm).isDisplayed();
    }

}
