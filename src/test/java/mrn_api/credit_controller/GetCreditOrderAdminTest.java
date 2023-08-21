package mrn_api.credit_controller;

import api.models.controllers.AllCreditOrdersModel;
import api.models.controllers.CreditOrderModel;
import api.services.TestRails;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetCreditOrderAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
    authorization(ADMIN);
}

    @TestRails(id = "C6229951")
    @Test(description = "Get credit order by id, role - Admin", groups = {"Api"})
    public void c6229951() {
        Response<AllCreditOrdersModel> responseAll = creditOrderApiStep.getAllCreditOrders(0, 10, Strings.EMPTY);
        Response<CreditOrderModel> response = creditOrderApiStep
                .getCreditOrderById(responseAll.body().getContent().get(0).getId());
        checkResponseCode(response, HTTP_OK);
        checkAll();
    }

    @TestRails(id = "C6229950")
    @Test(description = "Gel all credit orders, role - Admin", groups = {"Api"})
    public void c6229950() {
        Response<AllCreditOrdersModel> response = creditOrderApiStep
                .getAllCreditOrders(0, 100, Strings.EMPTY);
        checkResponseCode(response, HTTP_OK);
        creditOrderApiStep.checkAllCreditOrders(creditOrderDataBaseManager.getCountAll(), response.body().getContent().size());
    }

    @TestRails(id = "C6230071")
    @Test(description = "Get all credit orders by owner id, role - Admin", groups = {"Api"})
    public void c6230071() {
        Response<AllCreditOrdersModel> response = creditOrderApiStep
                .getAllCreditOrdersByOwnerId(userId, 0, 10, Strings.EMPTY);
        checkResponseCode(response, HTTP_OK);
        creditOrderApiStep.checkAllCreditOrders(creditOrderDataBaseManager.getCountAllByOwnerId(userId),
                response.body().getContent().size());
        checkAll();
    }
}
