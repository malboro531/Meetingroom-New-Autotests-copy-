package mrn_api.credit_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.controllers.CreditOrderModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.ApiDataBase.SQL_SELECT_CREDIT_ORDERS_BY_STATUS;
import static constants.ApiDataBase.SQL_SELECT_CREDIT_ORDER_BY_ID;
import static constants.enums.CreditOrderStatus.*;
import static constants.enums.Role.ADMIN;
import static constants.enums.Role.UNAUTHORIZED;
import static java.net.HttpURLConnection.*;

public class PatchCreditOrderAdminTest extends BaseApiTestUsingDataBase {

    private CreditOrderModel creditOrder;

    @BeforeClass
    public void initiateTokenAndPrepareTestData() {
        authorization(ADMIN);
        Response<CreditOrderModel> response = creditOrderApiStep
                .getCreditOrderById(DataBaseAbstractManager.getListInfoFromDB(String.format(SQL_SELECT_CREDIT_ORDERS_BY_STATUS,
                        String.valueOf(PENDING)), CreditOrderModel.class).get(0).getId());
        checkResponseCode(response, HTTP_OK);
        creditOrder = response.body();
    }

    @TestRails(id = "C6229946")
    @Test(description = "Approve credit order by id, role - Admin", groups = "{Api}")
    public void c6229946() {
        Response<Void> response = creditOrderApiStep.approveCreditOrder(creditOrder.getId());
        checkResponseCode(response, HTTP_OK);
        String dbCreditOrderStatus = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_ORDER_BY_ID,
                creditOrder.getId()), CreditOrderModel.class).getStatus();
        creditOrderApiStep.checkCreditOrderStatusInDB(dbCreditOrderStatus, String.valueOf(APPROVED));
        checkAll();
    }

    @TestRails(id = "C6304131")
    @Test(description = "Block credit order by id, role - Admin", groups = "{Api}")
    public void c6304131() {
        creditOrder.setStatus(String.valueOf(APPROVED));
        Response<CreditOrderModel> responseApprove = creditOrderApiStep
                .changeCreditOrderStatus(creditOrder.getId(), creditOrder);
        checkResponseCode(responseApprove, HTTP_OK);
        Response<Void> response = creditOrderApiStep.blockCreditOrder(creditOrder.getId());
        checkResponseCode(response, HTTP_OK);
        String dbCreditOrderStatus = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_ORDER_BY_ID,
                creditOrder.getId()), CreditOrderModel.class).getStatus();
        creditOrderApiStep.checkCreditOrderStatusInDB(dbCreditOrderStatus, String.valueOf(BLOCK));
        checkAll();
    }

    @TestRails(id = "C6306293")
    @Test(description = "Block credit order, invalid id, role - Admin", groups = "{Api}")
    public void c6306293() {
        creditOrder.setStatus(String.valueOf(APPROVED));
        Response<CreditOrderModel> responseApprove = creditOrderApiStep
                .changeCreditOrderStatus(creditOrder.getId(), creditOrder);
        checkResponseCode(responseApprove, HTTP_OK);
        String invalidCreditOrderId = FakeGenerator.getRandomString();
        Response<Void> response = creditOrderApiStep.blockCreditOrder(invalidCreditOrderId);
        checkResponseCode(response, HTTP_BAD_REQUEST);
    }

    @TestRails(id = "C6306294")
    @Test(description = "Block credit order, non-existent id, role - Admin", groups = "{Api}")
    public void c6306294() {
        creditOrder.setStatus(String.valueOf(APPROVED));
        Response<CreditOrderModel> responseApprove = creditOrderApiStep
                .changeCreditOrderStatus(creditOrder.getId(), creditOrder);
        checkResponseCode(responseApprove, HTTP_OK);
        String notExistentCreditOrderId = FakeGenerator.generateUuid();
        Response<Void> response = creditOrderApiStep.blockCreditOrder(notExistentCreditOrderId);
        checkResponseCode(response, HTTP_NOT_FOUND);
    }

    @TestRails(id = "C6304138")
    @Test(description = "Block credit order by id, role - Unauthorized", groups = "{Api}")
    public void c6304138() {
        creditOrder.setStatus(String.valueOf(APPROVED));
        Response<CreditOrderModel> responseApprove = creditOrderApiStep
                .changeCreditOrderStatus(creditOrder.getId(), creditOrder);
        checkResponseCode(responseApprove, HTTP_OK);
        authorization(UNAUTHORIZED);
        Response<Void> response = creditOrderApiStep.blockCreditOrder(creditOrder.getId());
        checkResponseCode(response, HTTP_UNAUTHORIZED);
    }

    @TestRails(id = "C6306299")
    @Test(description = "Prepare credit order by id, role - Admin", groups = "{Api}")
    public void c6306299() {
        creditOrder.setStatus(String.valueOf(APPROVED));
        Response<CreditOrderModel> responseApprove = creditOrderApiStep
                .changeCreditOrderStatus(creditOrder.getId(), creditOrder);
        checkResponseCode(responseApprove, HTTP_OK);
        Response<Void> response = creditOrderApiStep.prepareCreditOrder(creditOrder.getId());
        checkResponseCode(response, HTTP_OK);
        String dbCreditOrderStatus = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_CREDIT_ORDER_BY_ID,
                creditOrder.getId()), CreditOrderModel.class).getStatus();
        creditOrderApiStep.checkCreditOrderStatusInDB(dbCreditOrderStatus, String.valueOf(PREPARED));
        checkAll();
    }

    @TestRails(id = "C6306298")
    @Test(description = "Prepare credit order, invalid id, role - Admin", groups = "{Api}")
    public void c6306298() {
        creditOrder.setStatus(String.valueOf(APPROVED));
        Response<CreditOrderModel> responseApprove = creditOrderApiStep
                .changeCreditOrderStatus(creditOrder.getId(), creditOrder);
        checkResponseCode(responseApprove, HTTP_OK);
        String invalidCreditOrderId = FakeGenerator.getRandomString();
        Response<Void> response = creditOrderApiStep.prepareCreditOrder(invalidCreditOrderId);
        checkResponseCode(response, HTTP_BAD_REQUEST);
    }

    @TestRails(id = "C6304140")
    @Test(description = "Prepare credit order by id, role - Unauthorized", groups = "{Api}")
    public void c6304140() {
        creditOrder.setStatus(String.valueOf(APPROVED));
        Response<CreditOrderModel> responseApprove = creditOrderApiStep
                .changeCreditOrderStatus(creditOrder.getId(), creditOrder);
        checkResponseCode(responseApprove, HTTP_OK);
        authorization(UNAUTHORIZED);
        Response<Void> response = creditOrderApiStep.prepareCreditOrder(creditOrder.getId());
        checkResponseCode(response, HTTP_UNAUTHORIZED);
    }

    @AfterMethod
    public void changeCardOrderStatusBackToPrepared() {
        creditOrder.setStatus(String.valueOf(PENDING));
        Response<CreditOrderModel> response = creditOrderApiStep
                .changeCreditOrderStatus(creditOrder.getId(), creditOrder);
        checkResponseCode(response, HTTP_OK);
    }
}
