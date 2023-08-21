package steps.api;

import api.managers.DepositProductManager;
import api.models.controllers.AllDepositProductsModel;
import api.models.controllers.deposit.*;
import api.models.controllers.deposit.DepositProductModel;
import api.models.controllers.deposit.PojoDepositProductEditModel;
import api.models.controllers.deposit.PojoDepositProductModel;
import io.qameta.allure.Step;
import retrofit2.Response;
import verification.VerifySoft;

import java.util.List;

public class DepositProductApiStep {

    private DepositProductManager depositProductManager = new DepositProductManager();

    @Step("Get deposit product by id")
    public Response<DepositProductModel> getDepositProductById(String id) {
        return depositProductManager.getDepositProductById(id);
    }

    @Step("Get All deposit products")
    public Response<AllDepositProductsModel> getAllDepositModel(int page, int size) {
        return depositProductManager.getAllDepositProducts(page, size);
    }

    @Step("Search deposit product by depositName and currencyName")
    public Response<AllDepositProductsModel> getDepositProductByNameAndCurrency(int page, int size, String depositName, String currencyName) {
        return depositProductManager.getDepositProductByNameAndCurrency(page, size, depositName, currencyName);
    }

    @Step("Compare deposit product")
    public void checkDepositProduct(DepositProductModel depositProductModel, DepositProductModel depositProductModelSql) {
        //TODO
        //Verify.verifyNotNull(depositProductModelSql, "deposit product has read from DB");
        VerifySoft.verifyTrueSoft(depositProductModel.equals(depositProductModelSql), "response object equals DB object");
    }

    @Step("Create Deposit product ")
    public Response<PojoDepositProductModel> createDepositProduct(PojoDepositProductModel pojoDepositProductModel) {
        return depositProductManager.createDepositProduct(pojoDepositProductModel);
    }

    @Step("Edit Deposit product ")
    public Response<Void> editDepositProduct(PojoDepositProductEditModel pojoDepositProductEditModel) {
        return depositProductManager.editDepositProduct(pojoDepositProductEditModel);
    }

    @Step("Delete Deposit product")
    public Response<DepositProductModel> deleteDepositProductByID(String id) {
        return depositProductManager.deleteDepositProductById(id);
    }

    @Step("Check created deposit Product in DB")
    public void checkCreatedDepositProductInDataBase(PojoDepositProductModel pojoDepositProductModel, DepositProductModel depositProductModel) {
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.getId(), depositProductModel.getId(), " deposit product id found in DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.getDepositName(), depositProductModel.getDepositName(), "deposit product name found in DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.getType().getId(), depositProductModel.getType().getId(), "deposit product Type id found in DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.getType().getName(), depositProductModel.getType().getName(), "deposit product Type name found in DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.getCurrency().getId(), depositProductModel.getCurrency().getId(), "deposit product Currency id found in DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.getCurrency().getName(), depositProductModel.getCurrency().getName(), "deposit product Currency name found in DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.getMinTermMonths(), depositProductModel.getMinTermMonths(), "deposit product minTermMonth found in DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.getMaxTermMonths(), depositProductModel.getMaxTermMonths(), "deposit product maxTermMonth found in DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.getMinAmount(), depositProductModel.getMinAmount(), "deposit product minAmount found in DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.getMaxAmount(), depositProductModel.getMaxAmount(), "deposit product maxAmount found in DB");
//        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.getMinInterestRate(), depositProductModel.getMaxInterestRate(), "deposit product minInterestRate match with DB");
//        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.getMaxInterestRate(), depositProductModel.getMaxInterestRate(), "deposit product maxInterestRate match with DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.isFixedInterest(), depositProductModel.isFixedInterest(), "deposit product fixedInterest match with DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.isSubsequentReplenishment(), depositProductModel.isSubsequentReplenishment(), "deposit product SubsequentReplenishment match with DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.isEarlyWithdrawal(), depositProductModel.isEarlyWithdrawal(), "deposit product EarlyWithdrawal match with DB");
//        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.isInterestWithdrawal(), depositProductModel.isInterestWithdrawal(), "deposit product InterestWithdrawal match with DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.isCapitalization(), depositProductModel.isCapitalization(), "deposit product Capitalization match with DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.isRevocable(), depositProductModel.isRevocable(), "deposit product revocable match with DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.isCustomizable(), depositProductModel.isCustomizable(), "deposit product customizable match with DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.isActive(), depositProductModel.isActive(), "deposit product Capitalization match with DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.getDescriptions().get(0).getShortDescription(), depositProductModel.getDescriptions().get(0).getShortDescription(), "deposit product short description match with DB");
        VerifySoft.verifyEqualsSoft(pojoDepositProductModel.getDescriptions().get(0).getFullDescription(), depositProductModel.getDescriptions().get(0).getFullDescription(), "deposit product full description match with DB");
    }

    public void checkResponceDataBaseCountDepositProduct(Integer baseCount, Integer responceCount) {
        VerifySoft.verifyEqualsSoft(baseCount, responceCount, "Count of deposit products in DataBase matches with responce count");
    }

    @Step("Check that created deposit products aren't equal with Id")
    public void checkDifferentDepositProductsWithId(String depositProductCreatedId, String depositProductId) {
        VerifySoft.verifyNotEqualsSoft(depositProductCreatedId, depositProductId, "deposits are equal");
    }

    @Step("Get all currencies for deposit products")
    public Response<List<Currency>> getAllDepositCurrencies() {
        return depositProductManager.getAllCurrenciesForDeposit();
    }

    @Step("Get all types for deposit products")
    public Response<List<Type>> getAllTypesForDepositProducts() {
        return depositProductManager.getAllTypesForDeposit();
    }

    @Step("Get filtered deposit products")
    public Response<AllSortDepositProductModel> getFilteredDepositProducts(int page, int size, String sort) {
        return depositProductManager.getFilteredDepositProducts(page, size, sort);
    }
}
