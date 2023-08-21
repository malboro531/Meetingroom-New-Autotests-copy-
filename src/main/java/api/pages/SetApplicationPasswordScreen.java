package api.pages;


import element.RadioButtonElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.GlobalData.SET_APPLICATION_PASSWORD_TITLE;

@PageName(pageName = SET_APPLICATION_PASSWORD_TITLE)
public class SetApplicationPasswordScreen extends BaseScreen {

    @Required
    @FindBy(id = "set_new_password")
    private WebElement setNewPasswordButton;

    @FindBy(id = "use_password_switch")
    private WebElement usePasswordSwitchRadioButton;

    public void tapSetNewPasswordButton() {
        setNewPasswordButton.click();
    }

    public void tapUsePasswordSwitchRadioButton() {
        usePasswordSwitchRadioButton.click();
    }

    public boolean isPasswordSwitchRadioButtonChecked() {
        return new RadioButtonElement(usePasswordSwitchRadioButton).isChecked();
    }
}
