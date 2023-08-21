package mrn_api.credit_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.CreditOrderModel;
import api.services.TestRails;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_SELECT_CREDIT_ORDERS_BY_STATUS;
import static constants.ApiDataBase.SQL_SELECT_CREDIT_ORDER_BY_ID;
import static constants.enums.CreditOrderStatus.PENDING;
import static constants.enums.CreditOrderStatus.REJECTED;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class DeleteCreditOrderAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6229943")
    @Test(description = "Reject credit order by id, role - Admin")
    public void c6229943() {
        Response<CreditOrderModel> response = creditOrderApiStep
                .getCreditOrderById(DataBaseAbstractManager.getListInfoFromDB(String.format(SQL_SELECT_CREDIT_ORDERS_BY_STATUS,
                        String.valueOf(PENDING)), CreditOrderModel.class).get(0).getId());
        checkResponseCode(response, HTTP_OK);
        creditOrderApiStep.rejectCreditOrderById(response.body().getId());
        String dbCreditOrderStatus = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_ORDER_BY_ID,
                response.body().getId()), CreditOrderModel.class).getStatus();
        creditOrderApiStep.checkCreditOrderStatusInDB(dbCreditOrderStatus, String.valueOf(REJECTED));
        checkAll();
    }
}
