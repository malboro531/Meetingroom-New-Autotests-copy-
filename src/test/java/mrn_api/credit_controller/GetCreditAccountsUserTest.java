package mrn_api.credit_controller;

import api.models.controllers.AllCreditAccountsModel;
import api.models.controllers.CreditAccountsModel;
import api.services.TestRails;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseCreditAccountApiTest;

import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetCreditAccountsUserTest extends BaseCreditAccountApiTest {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6227545")
    @Test(description = "Get credit account by owner id, role - USER", groups = {"Api"})
    public void c6227545() {
        Response<AllCreditAccountsModel> response = creditAccountApiStep
                .getCreditAccountByOwnerId(userId, 0, 10, Strings.EMPTY);
        checkResponseCode(response, HTTP_OK);
        creditAccountApiStep.checkAllCreditAccounts(creditAccountDataBaseManager.getCountAllById(userId),
                response.body().getContent().size());
        checkAll();
    }

    @TestRails(id = "C6465645")
    @Test(description = "Get transfers info by credit account number, role - USER", groups = {"Api"})
    public void c6465645() {
        Response<CreditAccountsModel> response = creditAccountApiStep
                .getCreditTransferByAccountNumber(getAccountNumberByAllCreditAccount());
        checkResponseCode(response, HTTP_OK);
        creditAccountApiStep.verifyTransfersInfoFieldsNotNull(response.body());
        checkAll();
    }

    @TestRails(id = "C6467465")
    @Test(description = "Get credit account by id with valid data, role - USER", groups = {"Api"})
    public void c6467465() {
        Response<CreditAccountsModel> response = creditAccountApiStep
                .getCreditAccountById(getIdByAllCreditAccount());
        checkResponseCode(response, HTTP_OK);
        creditAccountApiStep.verifyFieldsNotNull(response.body());
        checkAll();
    }

    @TestRails(id = "C6467469")
    @Test(description = "Get all credit accounts, role - USER", groups = {"Api"})
    public void c6467469() {
        Response<AllCreditAccountsModel> response = creditAccountApiStep
                .getAllCreditAccounts(0, 100, Strings.EMPTY);
        checkResponseCode(response, HTTP_OK);
        creditAccountApiStep.checkAllCreditAccounts(creditAccountDataBaseManager
                        .getCountAllByOwnerIdUser(getOwnerIdByAllCreditAccount()), response.body().getContent().size());
        checkAll();
    }
}
