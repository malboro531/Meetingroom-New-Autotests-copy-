package helpers;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DropDownSelectorHelper {

    public static void chooseFirstElement(WebElement element) {
        new Actions(DriverManager.getDriver()).moveToElement(element, 0, 150)
                .click().build().perform();
    }

    public static void chooseSecondElement(WebElement element) {
        new Actions(DriverManager.getDriver()).moveToElement(element, 0, 250)
                .click().build().perform();
    }

    public static void chooseThirdElement(WebElement element) {
        new Actions(DriverManager.getDriver()).moveToElement(element, 0, 400)
                .click().build().perform();
    }
}
