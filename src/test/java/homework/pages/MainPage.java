package homework.pages;

import org.openqa.selenium.By;
import static pageObject.helpers.WebDriverContainer.setDriver;

public class MainPage {
    private final By avatarVisible = By.xpath("//div//p[@class='oxd-userdropdown-name']");
    private final By logoutButton = By.xpath("//li//a[@href='/web/index.php/auth/logout']");
    private final By directoryButton = By.cssSelector("[href='/web/index.php/directory/viewDirectory']");
    private final By directoryHeader = By.xpath("//h6");

    public By getDirectoryButton() {
        return directoryButton;
    }

    public By getDirectoryHeader() {
        return directoryHeader;
    }

    public void avatarClick() {
        setDriver().findElement(avatarVisible).click();
    }

    public void logoutButtonClick() {
        setDriver().findElement(logoutButton).click();
    }

    public void directoryButtonClick() {
        setDriver().findElement(directoryButton).click();
    }

    public boolean directoryHeaderVisible(String text) {
        return setDriver().findElement(directoryHeader).getText().equals(text);
    }
}
