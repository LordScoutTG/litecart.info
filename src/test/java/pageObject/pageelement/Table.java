package pageObject.pageelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Table {
    WebElement table;

    public Table(WebElement table) {
        this.table = table;
    }

    public int getRowCount(){
        return table.findElements(By.tagName("tr")).size();
    }

    public int getColumnsCount(){
        return table.findElement(By.tagName("tr")).findElements(By.tagName("th")).size();
    }

    public WebElement getCell(int rowIndex, int colIndex){
        WebElement row = table.findElements(By.tagName("tr")).get(rowIndex);
        return row.findElements(By.tagName("td")).get(colIndex - 1);
    }
}
