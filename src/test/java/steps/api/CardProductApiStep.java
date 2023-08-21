package steps.api;

import api.managers.CardProductManager;
import api.models.controllers.AllCardProductModel;
import api.models.controllers.CardProductModel;
import io.qameta.allure.Step;
import retrofit2.Response;
import verification.Verify;
import verification.VerifySoft;

public class CardProductApiStep {

    private CardProductManager cardProductManager = new CardProductManager();

    @Step("Create card product")
    public Response<CardProductModel> createCardProduct(CardProductModel cardProductModel) {
        return cardProductManager.createCardProduct(cardProductModel);
    }

    @Step("Check created card product in DB")
    public void checkCreatedCardProductInDataBaseById(CardProductModel cardProductModel, CardProductModel cardProductModelSql) {
        VerifySoft.verifyEqualsSoft(cardProductModel.getId(), cardProductModelSql.getId(), "card product id found in DB");
    }

    @Step("Check created card product in DB")
    public void checkCreatedCardProductInDataBaseByLimits(CardProductModel cardProductModel, CardProductModel cardProductModelSql) {
        VerifySoft.verifyEqualsSoft(cardProductModel.getLimits(), cardProductModelSql.getLimits(), "card product limits found in DB");
    }

    @Step("Delete card product by card product id")
    public Response<CardProductModel> deleteCardProduct(String id) {
        return cardProductManager.deleteCardProduct(id);
    }

    @Step("Update card product")
    public Response<CardProductModel> updateCardProduct(CardProductModel cardProduct) {
        return cardProductManager.updateCardProduct(cardProduct);
    }

    @Step("Get all card products")
    public Response<AllCardProductModel> getAllCardProducts(int page, int size, String sort) {
        return cardProductManager.getAllCardProducts(page, size, sort);
    }

    @Step("Check count of all card products")
    public void checkCountOfAllCardProducts(Integer bdCount, Integer responseCount) {
        Verify.verifyEquals(bdCount, responseCount, "Count card products in DataBase matches with response count");
    }

    @Step("Get card product by id")
    public Response<CardProductModel> getCardProductById(String id) {
        return cardProductManager.getCardProductById(id);
    }
}
