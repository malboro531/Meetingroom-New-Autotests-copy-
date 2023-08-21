package helpers;

import constants.SettingData;
import driver.manager.DriverManager;
import element.BaseElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    private static final Logger logger = LogManager.getLogger(Waiter.class.getName());

    private static WebDriverWait getWait() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(SettingData.WAIT_TIMEOUT));
    }

    public static void waitForVisibility(BaseElement baseElement) {
        try {
            getWait().until(ExpectedConditions.visibilityOf(baseElement.getWebElement()));
        } catch (TimeoutException e) {
            logger.error("Element is not a visible " + e);
        }
    }

    public static void waitForElementToBeClickable(BaseElement baseElement) {
        try {
            getWait().until(ExpectedConditions.elementToBeClickable(baseElement.getWebElement()));
        } catch (TimeoutException e) {
            logger.error("Element is not clickable " + e);
        }
    }
}
