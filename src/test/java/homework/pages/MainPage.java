package homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static pageObject.helpers.WebDriverContainer.setDriver;

public class MainPage {
    private final By avatarVisible = By.xpath("//div//p[@class='oxd-userdropdown-name']");
    private final By logoutButton = By.xpath("//li//a[@href='/web/index.php/auth/logout']");
    private final By directoryButton = By.cssSelector("[href='/web/index.php/directory/viewDirectory']");
    private final By directoryHeader = By.xpath("//h6");
    private final By pimButton = By.xpath("//a[@href='/web/index.php/pim/viewPimModule']");
    private final By addPimButton = By.cssSelector("[class='oxd-button oxd-button--medium oxd-button--secondary']");
    private final By addPimFirstName = By.name("firstName");
    private final By addPimMiddleName = By.name("middleName");
    private final By addPimLastName = By.name("lastName");
    private final By submitPimButton = By.cssSelector("button[type='submit']");
    private final By pimInfo = By.cssSelector("div[data-v-6c07a142]");

    private final String firstName = "Roman";
    private final String middleName = "Ivanovich";
    private final String lastName = "Ivanov";

    public By getDirectoryButton() {
        return directoryButton;
    }

    public By getDirectoryHeader() {
        return directoryHeader;
    }

    public By getAddPimButton() {
        return addPimButton;
    }

    public By getAddPimFirstName() {
        return addPimFirstName;
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

    public void pimButtonClick() {
        setDriver().findElement(pimButton).click();
    }

    public void addPimButtonClick() {
        setDriver().findElement(addPimButton).click();
    }

    public void addPimFirstName() {
        setDriver().findElement(addPimFirstName).sendKeys(firstName);
    }

    public void addPimMiddleName() {
        setDriver().findElement(addPimMiddleName).sendKeys(middleName);
    }

    public void addPimLastName() {
        setDriver().findElement(addPimLastName).sendKeys(lastName);
    }

    public void submitPimButtonClick() {
        setDriver().findElement(submitPimButton).click();
    }

    public boolean isPimAdded() {
        List<WebElement> myList = setDriver().findElements(pimInfo);
        List<String> all_elements_text = new ArrayList<>();
        for (int i = 0; i < myList.size(); i++) {
            all_elements_text.add(myList.get(i).getText());
        }
        return Boolean.parseBoolean(all_elements_text.stream().filter(x -> x.equals(lastName)).findFirst().orElse(null));
    }
}
