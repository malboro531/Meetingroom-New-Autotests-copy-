package element;

import org.openqa.selenium.WebElement;

import static constants.GlobalData.TRUE;

public class RadioButtonElement extends BaseElement {

    private final WebElement webElement;

    public RadioButtonElement(WebElement element) {
        this.webElement = element;
    }

    public boolean isChecked() {
        return webElement.getAttribute("Checked").equalsIgnoreCase(TRUE);
    }
}
