package homework.pages;

import org.openqa.selenium.By;
import static pageObject.helpers.WebDriverContainer.setDriver;

public class MainPage {
    private By avatarVisible = By.xpath("//div//p[@class='oxd-userdropdown-name']");

    private By logoutButton = By.xpath("//li//a[@href='/web/index.php/auth/logout']");

    public By getAvatarVisible() {
        return avatarVisible;
    }

    public boolean confirmAvatarVisible(){
       return setDriver().findElement(avatarVisible).isDisplayed();
    }

    public void avatarClick(){
        setDriver().findElement(avatarVisible).click();
    }

    public void logoutButtonClick(){
        setDriver().findElement(logoutButton).click();
    }
}
