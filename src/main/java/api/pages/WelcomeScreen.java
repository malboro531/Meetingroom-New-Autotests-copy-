package api.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static constants.GlobalData.WELCOME_TITLE;

@PageName(pageName = WELCOME_TITLE)
public class WelcomeScreen extends BaseScreen {

    @Required
    @FindBy(id = "mainFragment")
    private WebElement welcomeScreenBaseElement;

    @FindBy(id = "login_btn")
    private List<WebElement> loginButtonList;

    @FindBy(id = "create_credit_card")
    private WebElement getYourCardFrame;

    @FindBy(id = "calculate_credit_frame")
    private WebElement calculateYourCreditFrame;

    @FindBy(id = "login_btn")
    private WebElement loginButton;

    @FindBy(id = "demo_btn")
    private WebElement demoButton;

    public void tapOnGetYourCardFrame() {
        getYourCardFrame.click();
    }

    public void tapOnCalculateYourCreditFrame() {
        calculateYourCreditFrame.click();
    }

    public void tapOnLoginButton() {
        loginButton.click();
    }

    public void tapOnDemoButton() {
        demoButton.click();
    }

    public boolean isWelcomeScreenDisplayed() {
        return loginButtonList.size() != 0;
    }
}
