package pageObject.helpers;

import io.qameta.allure.Allure;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ScreenshotListener implements ITestListener {
    Logger LOG = Logger.getLogger(ScreenshotListener.class);

    @Override
    public void onTestFailure(ITestResult testResult) {
        File screenshot = ((TakesScreenshot)WebDriverContainer.setDriver()).getScreenshotAs(OutputType.FILE);
        try {
            Allure.addAttachment(testResult.getTestName() + " screenshot", new FileInputStream(screenshot));
        } catch (FileNotFoundException e) {
            LOG.error("Could not take screenshot " + e.getMessage());
        }
    }
}
