package steps.api;

import api.managers.CreditCardProductManager;
import api.models.controllers.CreditCardProductModel;
import io.qameta.allure.Step;
import retrofit2.Response;
import verification.Verify;

import java.util.List;

public class CreditCardProductApiStep {

    private CreditCardProductManager creditCardProductManager = new CreditCardProductManager();

    @Step("Create credit card product")
    public Response<CreditCardProductModel> createCreditCardProduct(CreditCardProductModel pojoCreditCardProductModel) {
        return creditCardProductManager.createCreditCardProduct(pojoCreditCardProductModel);
    }

    @Step("Get credit card product by id")
    public Response<CreditCardProductModel> getCreditCardProductById(String id) {
        return creditCardProductManager.getCreditCardProductById(id);
    }

    @Step("Get all credit card products")
    public Response<List<CreditCardProductModel>> getAllCreditCardProducts() {
        return creditCardProductManager.getAllCreditCardProducts();
    }

    @Step("Check count of credit card products in Data Base")
    public void checkAllCreditCardProducts(Integer dbCount, Integer responseCount) {
        Verify.verifyEquals(dbCount, responseCount, "Count credit card products in DataBase matches with response count");
    }

    @Step("Delete credit card product by id")
    public Response<CreditCardProductModel> deleteCreditCardProduct(String id) {
        return creditCardProductManager.deleteCreditCardProduct(id);
    }

    @Step("Update credit card product")
    public Response<CreditCardProductModel> updateCreditCardProduct(String id, CreditCardProductModel pojoCreditCardProductModel) {
        return creditCardProductManager.updateCreditCardProduct(id, pojoCreditCardProductModel);
    }

    @Step("Check credit card product in Data Base")
    public void checkCreditCardProductInDataBase(CreditCardProductModel pojoCreditCardProductModel, CreditCardProductModel creditCardProductModel) {
        Verify.verifyEquals(pojoCreditCardProductModel.getId(), creditCardProductModel.getId(), "Credit card product id found in DB");
        Verify.verifyEquals(pojoCreditCardProductModel.getCashback(), creditCardProductModel.getCashback(), "Credit card product cashback found in DB");
        Verify.verifyEquals(pojoCreditCardProductModel.getPrice(), creditCardProductModel.getPrice(), "Credit card product price found in DB");
        Verify.verifyEquals(pojoCreditCardProductModel.getAdvantages(), creditCardProductModel.getAdvantages(), "Credit card product advantages found in DB");
        Verify.verifyEquals(pojoCreditCardProductModel.getBankPartners(), creditCardProductModel.getBankPartners(), "Credit card product bank partners found in DB");
        Verify.verifyEquals(pojoCreditCardProductModel.getLoyaltyProgram(), creditCardProductModel.getLoyaltyProgram(), "Credit card product loyalty program found in DB");
        Verify.verifyEquals(pojoCreditCardProductModel.getMaintenanceCost(), creditCardProductModel.getMaintenanceCost(), "Credit card product maintenance cost found in DB");
        Verify.verifyEquals(pojoCreditCardProductModel.getMinSumBalance(), creditCardProductModel.getMinSumBalance(), "Credit card product min sum balance found in DB");
        Verify.verifyEquals(pojoCreditCardProductModel.getCurrency(), creditCardProductModel.getCurrency(), "Credit card product currency found in DB");
        Verify.verifyEquals(pojoCreditCardProductModel.getTypeCardId(), creditCardProductModel.getTypeCardId(), "Credit card product type card id found in DB");
    }
}
