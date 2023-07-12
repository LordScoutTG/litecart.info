package herokuapp;

import herokuapp.addremove.AddRemovePage;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.helpers.WebDriverContainer;

import java.util.Random;

import static pageObject.helpers.Locators.getLocator;


public class AddRemoveTest extends TestBase{

    @BeforeMethod
    public void comeFromMain() throws Exception {
        WebDriverContainer.setDriver().findElement(getLocator("MainPage.addRemove")).click();
    }

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
}
