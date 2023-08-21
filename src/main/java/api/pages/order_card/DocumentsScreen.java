package api.pages.order_card;

import api.pages.BaseScreen;
import api.pages.PageName;
import api.pages.Required;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

import static constants.DataOrderCard.DOCUMENTS;
import static constants.PersonalDetails.*;
import static helpers.FilesEquals.isFilesEqual;

@PageName(pageName = DOCUMENTS)
public class DocumentsScreen extends BaseScreen {

    @Required
    @FindBy(id = "checkOutDocumentsTextView")
    private WebElement checkOutTextView;

    @FindBy(id = "imageViewMainClickableArea")
    private WebElement returnButton;

    @FindBy(id = "step_status_line_horizontal")
    private WebElement stepStatusLine;

    @FindBy(xpath = "//android.view.ViewGroup[1]/android.widget.TextView")
    private WebElement firstDocTextView;

    @FindBy(id = "//android.view.ViewGroup[2]/android.widget.TextView")
    private WebElement secondDocTextView;

    @FindBy(id = "//android.view.ViewGroup[3]/android.widget.TextView")
    private WebElement thirdDocTextView;

    @FindBy(id = "primary_button")
    private WebElement continueButton;

    @FindBy(id = "imageViewMainClickableArea")
    private WebElement firstDocCheckBox;

    @FindBy(id = "checkOutDocumentsTextView")
    private WebElement secondDocCheckBox;

    @FindBy(id = "step_status_line_horizontal")
    private WebElement thirdDocCheckBox;

    @FindBy(xpath = "//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    private WebElement firstDocument;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView")
    private WebElement secondDocument;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView")
    private WebElement thirdDocument;

    @FindBy(id = "checkImageView")
    private WebElement checkMark;

    @FindBy(id = "long_text_description_title")
    private WebElement title;

    public void tapFirstDocument() {
        firstDocCheckBox.click();
    }

    public void tapSecondDocument() {
        secondDocCheckBox.click();
    }

    public void tapThirdDocument() {
        thirdDocCheckBox.click();
    }

    public void tapContinueButton() {
        continueButton.click();
    }

    public boolean isFirstDocumentDisplayed() {
        return firstDocument.isDisplayed();
    }

    public boolean isContinueButtonDisplayed() {
        return continueButton.isDisplayed();
    }

    public boolean isSecondDocumentDisplayed() {
        return secondDocument.isDisplayed();
    }

    public boolean isThirdDocumentDisplayed() {
        return thirdDocument.isDisplayed();
    }

    public boolean isNextButtonDisplayed() {
        return continueButton.isEnabled();
    }

    public void tapOnFirstDocument() {
        firstDocument.click();
    }

    public void tapOnSecondDocument() {
        secondDocument.click();
    }

    public void tapOnThirdDocument() {
        thirdDocument.click();
    }

    public boolean isCheckMarkDisplayed() {
        return checkMark.isDisplayed();
    }

    public boolean isTitleDisplayed() {
        return title.isDisplayed();
    }

    public static boolean isFirstDocumentEquals() {
        File firstFile = new File(COMP_PATH_DOWNLOAD + TARIFF);
        File secondFile = new File(COMP_PATH_ORIGINAL + TARIFF);
        return isFilesEqual(firstFile.toPath(), secondFile.toPath());
    }

    public static boolean isSecondDocumentEquals() {
        File firstFile = new File(COMP_PATH_DOWNLOAD + TERMS_OF_COMPREHENSIVE_BANKING);
        File secondFile = new File(COMP_PATH_ORIGINAL + TERMS_OF_COMPREHENSIVE_BANKING);
        return isFilesEqual(firstFile.toPath(), secondFile.toPath());
    }

    public static boolean isThirdDocumentEquals() {
        File firstFile = new File(COMP_PATH_DOWNLOAD + APPLICATION_FORM_WITH_CONCERT);
        File secondFile = new File(COMP_PATH_ORIGINAL + APPLICATION_FORM_WITH_CONCERT);
        return isFilesEqual(firstFile.toPath(), secondFile.toPath());
    }
}