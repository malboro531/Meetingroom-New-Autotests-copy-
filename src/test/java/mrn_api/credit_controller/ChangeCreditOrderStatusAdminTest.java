package mrn_api.credit_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.CreditOrderModel;
import api.services.TestRails;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_SELECT_CREDIT_ORDERS_BY_STATUS;
import static constants.ApiDataBase.SQL_SELECT_CREDIT_ORDER_BY_ID;
import static constants.enums.CreditOrderStatus.*;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class ChangeCreditOrderStatusAdminTest extends BaseApiTestUsingDataBase {

    private CreditOrderModel creditOrder;

    @BeforeClass
    public void initiateTokenAndPrepareTestData() {
        authorization(ADMIN);
        Response<CreditOrderModel> response = creditOrderApiStep
                .getCreditOrderById(DataBaseAbstractManager.getListInfoFromDB(String.format(SQL_SELECT_CREDIT_ORDERS_BY_STATUS,
                        String.valueOf(PREPARED)), CreditOrderModel.class).get(0).getId());
        checkResponseCode(response, HTTP_OK);
        creditOrder = response.body();
    }

    @TestRails(id = "C6100228")
    @Test(description = "Change credit order status to APPROVED, role - Admin")
    public void c6100228() {
        creditOrder.setStatus(String.valueOf(APPROVED));
        Response<CreditOrderModel> response = creditOrderApiStep
                .changeCreditOrderStatus(creditOrder.getId(), creditOrder);
        checkResponseCode(response, HTTP_OK);
        String dbCreditOrderStatus = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_ORDER_BY_ID,
                response.body().getId()), CreditOrderModel.class).getStatus();
        creditOrderApiStep.checkCreditOrderStatusInDB(dbCreditOrderStatus, String.valueOf(APPROVED));
        checkAll();
    }

    @TestRails(id = "C6100235")
    @Test(description = "Change credit order status to PENDING, role - Admin")
    public void c6100235() {
        creditOrder.setStatus(String.valueOf(PENDING));
        Response<CreditOrderModel> response = creditOrderApiStep
                .changeCreditOrderStatus(creditOrder.getId(), creditOrder);
        checkResponseCode(response, HTTP_OK);
        String dbCreditOrderStatus = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_ORDER_BY_ID,
                response.body().getId()), CreditOrderModel.class).getStatus();
        creditOrderApiStep.checkCreditOrderStatusInDB(dbCreditOrderStatus, String.valueOf(PENDING));
        checkAll();
    }

    @TestRails(id = "C6100236")
    @Test(description = "Change credit order status to REJECTED, role - Admin")
    public void c6100236() {
        creditOrder.setStatus(String.valueOf(REJECTED));
        Response<CreditOrderModel> response = creditOrderApiStep
                .changeCreditOrderStatus(creditOrder.getId(), creditOrder);
        checkResponseCode(response, HTTP_OK);
        String dbCreditOrderStatus = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_ORDER_BY_ID,
                response.body().getId()), CreditOrderModel.class).getStatus();
        creditOrderApiStep.checkCreditOrderStatusInDB(dbCreditOrderStatus, String.valueOf(REJECTED));
        checkAll();
    }

    @TestRails(id = "C6100237")
    @Test(description = "Change credit order status to BLOCK, role - Admin")
    public void c6100237() {
        creditOrder.setStatus(String.valueOf(BLOCK));
        Response<CreditOrderModel> response = creditOrderApiStep
                .changeCreditOrderStatus(creditOrder.getId(), creditOrder);
        checkResponseCode(response, HTTP_OK);
        String dbCreditOrderStatus = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_ORDER_BY_ID,
                response.body().getId()), CreditOrderModel.class).getStatus();
        creditOrderApiStep.checkCreditOrderStatusInDB(dbCreditOrderStatus, String.valueOf(BLOCK));
        checkAll();
    }

    @AfterMethod
    public void changeCardOrderStatusBackToPrepared() {
        creditOrder.setStatus(String.valueOf(PREPARED));
        Response<CreditOrderModel> response = creditOrderApiStep
                .changeCreditOrderStatus(creditOrder.getId(), creditOrder);
        checkResponseCode(response, HTTP_OK);
    }
}
