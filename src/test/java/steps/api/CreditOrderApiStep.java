package steps.api;

import api.managers.CreditOrderManager;
import api.models.controllers.AllCreditOrdersModel;
import api.models.controllers.CreditOrderModel;
import io.qameta.allure.Step;
import retrofit2.Response;
import verification.Verify;
import verification.VerifySoft;

public class CreditOrderApiStep {

    private CreditOrderManager creditOrderManager = new CreditOrderManager();

    @Step("Create credit order")
    public Response<CreditOrderModel> createCreditOrder(CreditOrderModel pojoCreditOrderModel) {
        return creditOrderManager.createCreditOrder(pojoCreditOrderModel);
    }

    @Step("Check created credit order in Data Base")
    public void checkCreditOrderInDataBase(CreditOrderModel creditOrderModel, CreditOrderModel creditOrderModelSQL) {
        VerifySoft.verifyEqualsSoft(creditOrderModel.getId(), creditOrderModelSQL.getId(), "Credit order id found in DB");
        VerifySoft.verifyEqualsSoft(creditOrderModel.getOwnerId(), creditOrderModelSQL.getOwnerId(), "Credit order owner id found in DB");
        VerifySoft.verifyEqualsSoft(creditOrderModel.getCreditProductId(), creditOrderModelSQL.getCreditProductId(), "Credit product id found in DB");
        VerifySoft.verifyEqualsSoft(creditOrderModel.getStatus(), creditOrderModelSQL.getStatus(), "Credit order status found in DB");
        VerifySoft.verifyEqualsSoft(creditOrderModel.getCreationDate(), creditOrderModelSQL.getCreationDate(), "Credit order creation date found in DB");
        VerifySoft.verifyEqualsSoft(creditOrderModel.getAmount(), creditOrderModelSQL.getAmount(), "Credit order amount found in DB");
        VerifySoft.verifyEqualsSoft(creditOrderModel.getTempCredit(), creditOrderModelSQL.getTempCredit(), "Credit order temp credit found in DB");
        VerifySoft.verifyEqualsSoft(creditOrderModel.getLoanRate(), creditOrderModelSQL.getLoanRate(), "Credit order loan rate found in DB");
        VerifySoft.verifyEqualsSoft(creditOrderModel.getAverageMonthlyIncome(), creditOrderModel.getAverageMonthlyIncome(), "Credit order average monthly income found in DB");
        VerifySoft.verifyEqualsSoft(creditOrderModel.getAverageMonthlyExpenditure(), creditOrderModelSQL.getAverageMonthlyExpenditure(), "Credit order average monthly expenditure found in DB");
        VerifySoft.verifyEqualsSoft(creditOrderModel.getEmployerId(), creditOrderModelSQL.getEmployerId(), "Credit order employer id found in DB");
    }

    @Step("Get credit order by id")
    public Response<CreditOrderModel> getCreditOrderById(String id) {
        return creditOrderManager.getCreditOrderById(id);
    }

    @Step("Get all credit orders by owner id")
    public Response<AllCreditOrdersModel> getAllCreditOrdersByOwnerId(String id, int page, int size, String sort) {
        return creditOrderManager.getAllCreditOrdersByOwnerId(id, page, size, sort);
    }

    @Step("Check count of credit orders in Data Base")
    public void checkAllCreditOrders(Integer dbCount, Integer responseCount) {
        Verify.verifyEquals(dbCount, responseCount, "Count of all credit orders in DataBase matches with response count");
    }

    @Step("Get all credit orders")
    public Response<AllCreditOrdersModel> getAllCreditOrders(int page, int size, String sort) {
        return creditOrderManager.getAllCreditOrders(page, size, sort);
    }

    @Step("Update credit order")
    public Response<CreditOrderModel> updateCreditOrder(CreditOrderModel pojoCreditOrderModel) {
        return creditOrderManager.updateCreditOrder(pojoCreditOrderModel);
    }

    @Step("Reject credit order by id")
    public Response<CreditOrderModel> rejectCreditOrderById(String id) {
        return creditOrderManager.rejectCreditOrderById(id);
    }

    @Step("Check card order status in DataBase")
    public void checkCreditOrderStatusInDB(String  dbStatus, String responseStatus) {
        Verify.verifyEquals(dbStatus, responseStatus, "Credit order status in DataBase matches with response status");
    }

    @Step("Change credit order status")
    public Response<CreditOrderModel> changeCreditOrderStatus(String id, CreditOrderModel pojoCreditOrderModel) {
        return creditOrderManager.changeCreditOrderStatus(id, pojoCreditOrderModel);
    }

    @Step("Change credit order status to approved")
    public Response<Void> approveCreditOrder(String id) {
        return creditOrderManager.approveCreditOrder(id);
    }

    @Step("Change credit order status to blocked")
    public Response<Void> blockCreditOrder(String id) {
        return creditOrderManager.blockCreditOrder(id);
    }

    @Step("Change credit order status to prepared")
    public Response<Void> prepareCreditOrder(String id) {
        return creditOrderManager.prepareCreditOrder(id);
    }
}
