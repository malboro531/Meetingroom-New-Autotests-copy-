package steps.order_cards;

import api.pages.order_card.DeliveryMethodScreen;
import io.qameta.allure.Step;
import verification.Verify;

public class DeliveryMethodStep {

    protected DeliveryMethodScreen deliveryMethodScreen;

    @Step("On DeliveryMethodScreen Screen")
    public void onDeliveryMethodScreen() {
        deliveryMethodScreen = new DeliveryMethodScreen();
    }

    @Step("Verify 'Delivery Method' is open")
    public void verifyIsDeliveryMethodOpen() {
        deliveryMethodScreen.verifyPageIsOpened();
    }

    @Step("Tap Return Back Button")
    public void tapReturnButton() {
        deliveryMethodScreen.tapReturnButton();
    }

    @Step("Tap Branch Tab")
    public void tapBranchTab() {
        deliveryMethodScreen.tapBranchTab();
    }

    @Step("Verify CityScreen on Tab is displayed")
    public void cityOnTabIsDisplayed() {
        Verify.verifyTrue(deliveryMethodScreen.cityOnTabIsDisplayed(), "Webelement is displayed");
    }

    @Step("Verify Bank Branch on Tab is displayed")
    public void bankOnTabIsDisplayed() {
        Verify.verifyTrue(deliveryMethodScreen.bankOnTabIsDisplayed(), "Webelement is displayed");
    }
}