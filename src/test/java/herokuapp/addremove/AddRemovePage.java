package herokuapp.addremove;


import static pageObject.helpers.Locators.getLocator;
import static pageObject.helpers.WebDriverContainer.setDriver;

public class AddRemovePage {

    public static void addButtonClick() throws Exception {
        setDriver().findElement(getLocator("AddRemove.addButton")).click();
    }

    public static void removeButtonClick() throws Exception {
        setDriver().findElement(getLocator("AddRemove.deleteButton")).click();
    }
    public static boolean removeButtonIsVisible() throws Exception {
        return setDriver().findElements(getLocator("AddRemove.deleteButton")).size() > 0;
    }
}
