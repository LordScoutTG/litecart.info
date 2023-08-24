package herokuapp;

import herokuapp.addremove.AddRemovePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.helpers.WebDriverContainer;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static pageObject.helpers.Locators.getLocator;
import static pageObject.helpers.WebDriverContainer.setDriver;


public class AddRemoveTest extends TestBase{

//    @BeforeMethod
//    public void comeFromMain() throws Exception {
//        WebDriverContainer.setDriver().findElement(getLocator("MainPage.addRemove")).click();
//    }

    @Test
    public void successAddingTest() throws Exception {
        AddRemovePage.addButtonClick();
        Assert.assertTrue(AddRemovePage.removeButtonIsVisible(), "There is no DELETE button");
    }

    @Test
    public void successDeletingTest() throws Exception {
        AddRemovePage.addButtonClick();
        AddRemovePage.removeButtonClick();
        Assert.assertFalse(AddRemovePage.removeButtonIsVisible(), "Button is still displayed");
    }

    @Test
    public void successMultipleDeletingTest() throws Exception {
        Random clicks = new Random();
        int randomClicks = clicks.nextInt(150);
        for (int i = 0; i<randomClicks; i++){
            AddRemovePage.addButtonClick();
        }
        do {
            AddRemovePage.removeButtonClick();
        } while (AddRemovePage.removeButtonIsVisible());
    }
    WebDriver driver = new ChromeDriver();

    public WebDriver getDriver() {
        return driver;
    }

    private static By weatherAugustTemp = By.cssSelector("[class=\"first\"] + [class=\"first_in_group positive\"]");

    public List<Integer> getWeather(){
        return getDriver().findElements(weatherAugustTemp).stream().map(x->x.getText().substring(1)).map(Integer::valueOf)
                .collect(Collectors.toList());
    }
    public Double averageTemp(){
        return getWeather().stream().mapToDouble(Integer::intValue)
                .average()
                .orElse(Double.NaN);
    }
    public WebDriver closeDriver() {
        return driver;
    }
    @Test
    public void temp(){
        int year;
        int month;
        for (year = 2010; year <= 2023; year++) {
            for (month = 1; month <= 12; month++){
                getDriver();
                String web = String.format("https://www.gismeteo.ru/diary/5003/%s/%s/", year, month);
                driver.get(web);
                System.out.println(year + " ---- " + month + " --- " +  Math.round(averageTemp()));
                closeDriver();
            }

        }
    }
}
