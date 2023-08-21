package api.pages.products.accounts;

import api.pages.BaseScreen;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import verification.VerifySoft;

public class OpenAccountDocumentsScreen extends BaseScreen {

    @FindBy(id = "checkOutDocumentsTextView")
    private WebElement documentsTextView;

    @FindBy(xpath = "//*[@resource-id=\"com.example.meetingroom_new_android:id/applicationConstraintLayout\"][1]")
    private WebElement firstDocumentButton;

    @FindBy(xpath = "//*[@resource-id=\"com.example.meetingroom_new_android:id/applicationConstraintLayout\"][2]")
    private WebElement secondDocumentButton;

    @FindBy(xpath = "//*[@resource-id=\"com.example.meetingroom_new_android:id/applicationConstraintLayout\"][3]")
    private WebElement thirdDocumentButton;

    @FindBy(id = "checkImageView")
    private WebElement firstMark;

    public void tapOnFirstDocumentButton() {
        firstDocumentButton.click();
    }

    public void tapOnSecondDocumentButton() {
        secondDocumentButton.click();
    }

    public void tapOnThirdDocumentButton() {
        thirdDocumentButton.click();
    }

    public void verifyOkMarkFirstDocIsDisplayed() {
        VerifySoft.verifyTrueSoft(firstMark.isDisplayed(), "OK mark is displayed opposite document");
    }
}
