package steps.api;

import api.managers.CreditCardManager;
import api.models.controllers.*;
import io.qameta.allure.Step;
import retrofit2.Response;
import verification.Verify;
import verification.VerifySoft;

public class CreditCardApiStep {

    private CreditCardManager creditCardManager = new CreditCardManager();

    @Step("Create credit card")
    public Response<CreditCardModel> createCreditCard(CreditCardModel pojoCreditCardModel) {
        return creditCardManager.createCreditCard(pojoCreditCardModel);
    }

    @Step("Check created credit card in Data Base")
    public void checkCreditCardInDataBase(CreditCardModel creditCardModel, CreditCardModel creditCardModelSQL) {
        VerifySoft.verifyEqualsSoft(creditCardModel.getId(), creditCardModelSQL.getId(), "Credit card id found in DB");
        VerifySoft.verifyEqualsSoft(creditCardModel.getAccountId(), creditCardModelSQL.getAccountId(), "Credit card account id found in DB");
        VerifySoft.verifyEqualsSoft(creditCardModel.getCardProductId(), creditCardModelSQL.getCardProductId(), "Credit card product id found in DB");
        VerifySoft.verifyEqualsSoft(creditCardModel.isActive(), creditCardModelSQL.isActive(), "Credit card is active-information found in DB");
        VerifySoft.verifyEqualsSoft(creditCardModel.getLastFourNumbers(), creditCardModelSQL.getLastFourNumbers(), "Credit card last four numbers found in DB");
        VerifySoft.verifyEqualsSoft(creditCardModel.getFirstTwelveNumbers(), creditCardModelSQL.getFirstTwelveNumbers(), "Credit card first twelve found in DB");
        VerifySoft.verifyEqualsSoft(creditCardModel.getValidFromDate(), creditCardModelSQL.getValidFromDate(), "Credit card valid from date-information found in DB");
        VerifySoft.verifyEqualsSoft(creditCardModel.getExpireDate(), creditCardModelSQL.getExpireDate(), "Credit card expire date found in DB");
        VerifySoft.verifyEqualsSoft(creditCardModel.getHolderName(), creditCardModelSQL.getHolderName(), "Credit card holder name found in DB");
        VerifySoft.verifyEqualsSoft(creditCardModel.getSecurityCode(), creditCardModelSQL.getSecurityCode(), "Credit card security code found in DB");
    }

    @Step("Update credit card")
    public Response<CreditCardModel> updateCreditCard(String id, CreditCardModel pojoCreditCardModel) {
        return creditCardManager.updateCreditCard(id, pojoCreditCardModel);
    }

    @Step("Get all credit cards")
    public Response<AllCreditCardsModel> getAllCreditCardsOfCurrentUser(int page, int size, String sort) {
        return creditCardManager.getAllCreditCardsOfCurrentUser(page, size, sort);
    }

    @Step("Check count of credit cards in Data Base")
    public void checkAllCreditCards(Integer dbCount, Integer responseCount) {
        Verify.verifyEquals(dbCount, responseCount, "Count of all credit cards of current user in DataBase matches with response count");
    }

    @Step("Get credit card by id")
    public Response<CreditCardModel> getCreditCardById(String id) {
        return creditCardManager.getCreditCardById(id);
    }

    @Step("Check credit card not active status in Data Base")
    public void checkCreditCardNotActiveStatus(boolean isActive) {
        Verify.verifyFalse(isActive, "Credit card status in Data Base is not active");
    }

    @Step("Check credit card active status in Data Base")
    public void checkCreditCardActiveStatus(boolean isActive) {
        Verify.verifyTrue(isActive, "Credit card status in Data Base is active");
    }

    @Step("Deactivate credit card by id")
    public Response<Void> deactivateCreditCard(String id) {
        return creditCardManager.deactivateCreditCard(id);
    }

    @Step("Activate credit card by id")
    public Response<Void> activateCreditCard(String id) {
        return creditCardManager.activateCreditCard(id);
    }
}
