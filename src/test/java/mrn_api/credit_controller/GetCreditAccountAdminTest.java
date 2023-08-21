package mrn_api.credit_controller;

import api.models.controllers.AllCreditAccountsModel;
import api.models.controllers.CreditAccountsModel;
import api.services.TestRails;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseCreditAccountApiTest;

import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetCreditAccountAdminTest extends BaseCreditAccountApiTest {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6226875")
    @Test(description = "Get credit account by id with valid data, role - ADMIN", groups = {"Api"})
    public void c6226875() {
        Response<CreditAccountsModel> response = creditAccountApiStep.getCreditAccountById(getIdByAllCreditAccount());
        checkResponseCode(response, HTTP_OK);
        creditAccountApiStep.verifyFieldsNotNull(response.body());
        checkAll();
    }

    @TestRails(id = "C6227534")
    @Test(description = "Get all credit accounts, role - ADMIN", groups = {"Api"})
    public void c6227534() {
        Response<AllCreditAccountsModel> response = creditAccountApiStep
                .getAllCreditAccounts(0, 100, Strings.EMPTY);
        checkResponseCode(response, HTTP_OK);
        creditAccountApiStep.checkAllCreditAccounts(creditAccountDataBaseManager.getCountAll(), response.body().getContent().size());
        checkAll();
    }

    @TestRails(id = "C6227543")
    @Test(description = "Get credit account by owner id, role - ADMIN", groups = {"Api"})
    public void c6227543() {
        Response<AllCreditAccountsModel> response = creditAccountApiStep
                .getCreditAccountByOwnerId(getOwnerIdByAllCreditAccount(), 0, 10, Strings.EMPTY);
        checkResponseCode(response, HTTP_OK);
        creditAccountApiStep.checkAllCreditAccounts(creditAccountDataBaseManager
                        .getCountAllById(getOwnerIdByAllCreditAccount()),
                response.body().getContent().size());
        checkAll();
    }

    @TestRails(id = "C6227535")
    @Test(description = "Get transfers info by credit account number, role - ADMIN", groups = {"Api"})
    public void c6227535() {
        Response<CreditAccountsModel> response = creditAccountApiStep
                .getCreditTransferByAccountNumber(getAccountNumberByAllCreditAccount());
        checkResponseCode(response, HTTP_OK);
        creditAccountApiStep.verifyTransfersInfoFieldsNotNull(response.body());
        checkAll();
    }
}
