package pageObject.pageelement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TableTest {
    private WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void init() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");
    }
    @Test
    public void tableTest(){

        PageTable pageTable = new PageTable(driver);

        int rows = pageTable.table1.getRowCount();
        int columns = pageTable.table1.getColumnsCount();

        String textIn33 = pageTable.table1.getCell(3, 3).getText();
        Assert.assertEquals(textIn33, "jdoe@hotmail.com");
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}

