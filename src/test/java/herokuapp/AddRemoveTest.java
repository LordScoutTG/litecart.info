package herokuapp;

import herokuapp.addremove.AddRemovePage;
import herokuapp.addremove.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddRemoveTest extends TestBase{

    @Test
    public void successAddingTest() throws Exception {
        MainPage.addRemovePageClick(driver);
        AddRemovePage.addButtonClick(driver);
        Assert.assertTrue(AddRemovePage.removeButtonIsVisible(driver), "There is no DELETE button");
    }

    @Test
    public void successDeletingTest() throws Exception {
        MainPage.addRemovePageClick(driver);
        AddRemovePage.addButtonClick(driver);
        AddRemovePage.removeButtonClick(driver);
        Assert.assertFalse(AddRemovePage.removeButtonIsVisible(driver), "Button is still displayed");
    }
}
