package api.widgets;

import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ErrorFrame extends Widget {

    public ErrorFrame(WebElement element) {
        super(element);
    }

    private final WebElement errorTextTitle = findElement(By.id("incorrectTextView"));

    private final WebElement errorTextContent = findElement(By.id("someTextView"));

    private final WebElement changeMethodLink = findElement(By.id("changeMethodTextView"));

    private final WebElement repeatLaterLink = findElement(By.id("repeatLaterTextView"));

    public void tapOnChangeMethodLink() {
        changeMethodLink.click();
    }

    public void tapOnRepeatLaterLink() {
        repeatLaterLink.click();
    }

    public String getErrorTextTitle() {
        return errorTextTitle.getText();
    }

    public String getErrorTextContent() {
        return errorTextContent.getText();
    }
}
