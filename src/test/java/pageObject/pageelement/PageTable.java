package pageObject.pageelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageTable {

    public Table table1;

    private By table1Locator = By.id("table1");

    private WebDriver driver;

    public PageTable(WebDriver driver){
        this.driver = driver;
        table1 = new Table(driver.findElement(table1Locator));
    }
}
