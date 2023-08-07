package finalProject.pages;

import finalProject.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RubberDucks extends TestBase {

    private static final By rubberDuckTitle = By.xpath("//*[@id='box-category']/h1");


    @Step("Checking Rubber Ducks title")
    public static boolean rubberDuckTitleIsVisible(WebDriver driver){
        LOG.info("Checking Rubber Ducks title");
        return driver.findElement(rubberDuckTitle).isDisplayed();
    }
}
