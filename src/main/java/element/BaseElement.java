package element;

import lombok.Getter;
import org.openqa.selenium.WebElement;

public class BaseElement {

    @Getter
    private WebElement webElement;

    public BaseElement() {
    }
}
