package steps.api;

import api.managers.CreditProductManager;
import api.models.controllers.AllCreditAccountsModel;
import api.models.controllers.CreditAccountsModel;
import api.models.controllers.CreditModel;
import io.qameta.allure.Step;
import retrofit2.Response;
import verification.VerifySoft;
import verification.Verify;

import java.util.List;

public class CreditProductApiStep {

    private CreditProductManager creditProductManager = new CreditProductManager();

    @Step("Create Credit product ")
    public Response<CreditModel> createCreditProduct(CreditModel pojoCreditProductModel) {
        return creditProductManager.createCreditProduct(pojoCreditProductModel);
    }

    @Step("Get credit product by id")
    public Response<CreditModel> getCreditProductById(String id) {
        return creditProductManager.getCreditProductById(id);
    }

    @Step("Get all credit products")
    public Response<AllCreditAccountsModel> getAllCreditProducts(int page, int size, String sort) {
        return creditProductManager.getAllCreditProducts(page, size, sort);
    }

    @Step("Get all active credit products")
    public Response<AllCreditAccountsModel> getAllActiveCreditProducts(int page, int size, String sort) {
        return creditProductManager.getAllActiveCreditProducts(page, size, sort);
    }

    @Step("Check credit Product in DB")
    public void checkCreditProductInDataBase(CreditModel pojoCreditProductModel, CreditModel creditModelSql) {
        VerifySoft.verifyEqualsSoft(pojoCreditProductModel.getId(), creditModelSql.getId(), " credit product id found in DB");
        VerifySoft.verifyEqualsSoft(pojoCreditProductModel.getCreditName(), creditModelSql.getCreditName(), "credit product name found in DB");
        VerifySoft.verifyEqualsSoft(pojoCreditProductModel.getMinSum(), creditModelSql.getMinSum(), "credit product min sum found in DB");
        VerifySoft.verifyEqualsSoft(pojoCreditProductModel.getMaxSum(), creditModelSql.getMaxSum(), "credit product max sum found in DB");
        VerifySoft.verifyEqualsSoft(pojoCreditProductModel.getCurrency(), creditModelSql.getCurrency(), "credit product Currency found in DB");
        VerifySoft.verifyEqualsSoft(pojoCreditProductModel.getMinTerm(), creditModelSql.getMinTerm(), "credit product min term  found in DB");
        VerifySoft.verifyEqualsSoft(pojoCreditProductModel.getMaxTerm(), creditModelSql.getMaxTerm(), "credit product max term found in DB");
        VerifySoft.verifyEqualsSoft(pojoCreditProductModel.getMultiplicityOfTemp(), creditModelSql.getMultiplicityOfTemp(), "credit product multiplicity Of Temp found in DB");
        VerifySoft.verifyEqualsSoft(pojoCreditProductModel.getDescription(), creditModelSql.getDescription(), "credit product description found in DB");
        VerifySoft.verifyEqualsSoft(pojoCreditProductModel.getPenaltyId(), creditModelSql.getPenaltyId(), "credit product penalty id found in DB");
        VerifySoft.verifyEqualsSoft(pojoCreditProductModel.getLoanRate(), creditModelSql.getLoanRate(), "credit product loan rate found in DB");
    }

    @Step("Check all credit accounts")
    public void checkAllCreditAccounts(Integer baseCount, Integer responseCount, List<CreditAccountsModel> creditAccountModel, List<CreditAccountsModel> creditAccountModelSql) {
        VerifySoft.verifyEqualsSoft(baseCount, responseCount, "Count of credit account in DataBase matches with response count");
        for (int i = 0; i < creditAccountModel.size(); i++) {
            VerifySoft.verifyEqualsSoft(creditAccountModel.get(i).getId(), creditAccountModelSql.get(i).getId(), "id found in DB");
            VerifySoft.verifyEqualsSoft(creditAccountModel.get(i).getOwnerId(), creditAccountModelSql.get(i).getOwnerId(), "owner id found in DB");
            VerifySoft.verifyEqualsSoft(creditAccountModel.get(i).getOpenDate(), creditAccountModelSql.get(i).getOpenDate().substring(0, 10), "open date found in DB");
            VerifySoft.verifyEqualsSoft(creditAccountModel.get(i).getCloseDate(), creditAccountModelSql.get(i).getCloseDate().substring(0, 10), "close date found in DB");
            VerifySoft.verifyEqualsSoft(creditAccountModel.get(i).getBankName(), creditAccountModelSql.get(i).getBankName(), "bank name found in DB");
            VerifySoft.verifyEqualsSoft(creditAccountModel.get(i).getCurrencyName(), creditAccountModelSql.get(i).getCurrencyName(), "currency name found in DB");
            VerifySoft.verifyEqualsSoft(creditAccountModel.get(i).getBalance(), creditAccountModelSql.get(i).getBalance(), "balance found in DB");
            VerifySoft.verifyEqualsSoft(creditAccountModel.get(i).getBorrowingLimit(), creditAccountModelSql.get(i).getBorrowingLimit(), "borrowing limit found in DB");
            VerifySoft.verifyEqualsSoft(creditAccountModel.get(i).getNextDateTemp(), creditAccountModelSql.get(i).getNextDateTemp(), "next date temp found in DB");
        }
    }

    @Step("Check all active credit products")
    public void checkAllActiveCreditProducts(AllCreditAccountsModel allCreditAccountModel) {
        List<CreditAccountsModel> content = allCreditAccountModel.getContent();
        VerifySoft.verifyTrueSoft(content.stream().allMatch(CreditAccountsModel::isActive), "Credit product is active");
    }

    @Step("Update credit product")
    public Response<CreditModel> updateCreditProduct(String id, CreditModel pojoCreditProductModel) {
        return creditProductManager.updateCreditProduct(id, pojoCreditProductModel);
    }

    @Step("Check count of all credit products")
    public void checkCountOfAllCreditProducts(Integer bdCount, Integer responseCount) {
        Verify.verifyEquals(bdCount, responseCount, "Count credit products in DataBase matches with response count");
    }
}
