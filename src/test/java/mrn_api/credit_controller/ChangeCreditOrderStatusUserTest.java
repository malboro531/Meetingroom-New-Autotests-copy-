package mrn_api.credit_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.CreditOrderModel;
import api.services.TestRails;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_SELECT_CREDIT_ORDERS_BY_STATUS;
import static constants.enums.CreditOrderStatus.*;
import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;
import static java.net.HttpURLConnection.HTTP_OK;

public class ChangeCreditOrderStatusUserTest extends BaseApiTestUsingDataBase {

    private CreditOrderModel creditOrder;

    @BeforeClass
    public void initiateTokenAndPrepareTestData() {
        authorization(USER);
        Response<CreditOrderModel> response = creditOrderApiStep
                .getCreditOrderById(DataBaseAbstractManager.getListInfoFromDB(String.format(SQL_SELECT_CREDIT_ORDERS_BY_STATUS,
                        String.valueOf(PREPARED)), CreditOrderModel.class).get(0).getId());
        checkResponseCode(response, HTTP_OK);
        creditOrder = response.body();
    }

    @TestRails(id = "С6100238")
    @Test(description = "Change credit order status to APPROVED, role - User")
    public void c6100238() {
        creditOrder.setStatus(String.valueOf(APPROVED));
        Response<CreditOrderModel> response = creditOrderApiStep
                .changeCreditOrderStatus(creditOrder.getId(), creditOrder);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6100240")
    @Test(description = "Change credit order status to PENDING, role - User")
    public void c6100240() {
        creditOrder.setStatus(String.valueOf(PENDING));
        Response<CreditOrderModel> response = creditOrderApiStep
                .changeCreditOrderStatus(creditOrder.getId(), creditOrder);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6100241")
    @Test(description = "Change credit order status to REJECTED, role - User")
    public void c6100241() {
        creditOrder.setStatus(String.valueOf(REJECTED));
        Response<CreditOrderModel> response = creditOrderApiStep
                .changeCreditOrderStatus(creditOrder.getId(), creditOrder);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }

    @TestRails(id = "C6100242")
    @Test(description = "Change credit order status to BLOCK, role - User")
    public void c6100242() {
        creditOrder.setStatus(String.valueOf(BLOCK));
        Response<CreditOrderModel> response = creditOrderApiStep
                .changeCreditOrderStatus(creditOrder.getId(), creditOrder);
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }
}
