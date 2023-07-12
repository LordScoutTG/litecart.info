package pageObject.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = ".notice.success")
    private WebElement successMessage;


    public boolean successMessageIsVisible(){
        return successMessage.isDisplayed();
    }
}
