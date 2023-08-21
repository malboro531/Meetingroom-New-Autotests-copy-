package helpers;

import driver.manager.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {

    public static void acceptAlertIfPresented() {
        AppiumDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
                Alert alert = driver.switchTo().alert();
                alert.accept();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
