package verification;

import driver.manager.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.ByteArrayInputStream;
import java.io.File;

public class AllureLog {

    public static void addAttachmentAndMessage(String message) {
        AppiumDriver driver = DriverManager.getDriver();
        try {
            Allure.addAttachment(message, new ByteArrayInputStream(((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES)));
            FileHandler.copy(((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE), new File("allure-results\\screenshot.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
