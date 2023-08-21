package steps;

import api.pages.PromoScreen;
import io.qameta.allure.Step;

public class PromoStep {

    protected PromoScreen promoScreen;

    @Step("On 'Promo' screen")
    public void onPromoScreen() {
        promoScreen = new PromoScreen();
    }

    @Step("Tap on cross image")
    public void tapOnCrossImage() {
        promoScreen.tapOnCrossImg();
    }

    @Step("Tap on skip to design button")
    public void tapOnSkipToDesignButton() {
        promoScreen.tapOnSkipToDesignButton();
    }

    @Step("Verify 'PromoScreen' is open")
    public void verifyPromoScreenIsOpen() {
        promoScreen.verifyPageIsOpened();
    }

    @Step("Tap on order a card")
    public void tapOnOrderACard() {
        promoScreen.tapOnOrderCard();
    }

    @Step("Swipe card ro left from Order Card")
    public void swipeFromOrderCard() {
        promoScreen.swipeToOrderCard();
    }

    @Step("Tap on settings button")
    public void tapOnSettingsButton(){
        promoScreen.tapOnSettingsButton();
    }
}
