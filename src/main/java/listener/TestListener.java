package listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListener.class);

    public void onTestStart(ITestResult result) {
        logger.info("Test was START! -> " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Test was PASS! -> " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        logger.error("Test was FAIL! -> " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        logger.warn("Test was SKIP! -> " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        logger.info("Started -> " + context);
    }

    public void onFinish(ITestContext context) {
        logger.info("Finished -> " + context);
    }
}