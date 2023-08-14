package finalProject.helpers;


import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.qameta.allure.listener.TestLifecycleListener;
import java.io.ByteArrayInputStream;



public class ScreenshotListener implements TestLifecycleListener  {
    Logger LOG = Logger.getLogger(ScreenshotListener.class);

    @Override
    public void beforeTestStop(TestResult result) {

        if (result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN) {
            if (WebDriverContainer.getDriver() != null)
                Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot) WebDriverContainer.setDriver()).getScreenshotAs(OutputType.BYTES)));
        }

    }

//    @Override
//    public void onTestFailure(ITestResult testResult) {
//
//        File screenshot = ((TakesScreenshot) WebDriverContainer.setDriver()).getScreenshotAs(OutputType.FILE);
//        try {
//            Allure.addAttachment(testResult.getTestName() + " screenshot", new FileInputStream(screenshot));
//        } catch (FileNotFoundException e) {
//            LOG.error("Could not take screenshot " + e.getMessage());
//        }
//    }
}
