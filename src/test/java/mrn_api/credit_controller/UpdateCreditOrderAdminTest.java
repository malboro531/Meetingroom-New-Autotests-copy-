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
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class UpdateCreditOrderAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6229948")
    @Test(description = "Update credit order, role - Admin")
    public void c6229948() {
        Response<CreditOrderModel> response = creditOrderApiStep
                .getCreditOrderById(DataBaseAbstractManager.getListInfoFromDB(String.format(SQL_SELECT_CREDIT_ORDERS_BY_STATUS,
                        String.valueOf(PENDING)), CreditOrderModel.class).get(0).getId());
        checkResponseCode(response, HTTP_OK);
        CreditOrderModel newCreditOrderModel = response.body();
        newCreditOrderModel.setAmount(response.body().getAmount() - 1);
        Response<CreditOrderModel> responseUpdate = creditOrderApiStep
                .updateCreditOrder(newCreditOrderModel);
        checkResponseCode(responseUpdate, HTTP_OK);
        CreditOrderModel creditOrderModelSQL = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_ORDER_BY_ID,
                response.body().getId()), CreditOrderModel.class);
        creditOrderApiStep.checkCreditOrderInDataBase(responseUpdate.body(), creditOrderModelSQL);
        checkAll();
    }
}
