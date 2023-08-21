package steps;

import api.models.controllers.AllCreditAccountsModel;
import org.apache.logging.log4j.util.Strings;
import retrofit2.Response;

public class BaseCreditAccountApiTest extends BaseApiTestUsingDataBase{

    public String getIdByAllCreditAccount() {
        Response<AllCreditAccountsModel> creditAccountIdResponse = creditAccountApiStep
                .getAllCreditAccounts(0, 100, Strings.EMPTY);
        return creditAccountIdResponse.body().getContent().get(0).getId();
    }

    public String getOwnerIdByAllCreditAccount() {
        Response<AllCreditAccountsModel> ownerIdResponse = creditAccountApiStep
                .getAllCreditAccounts(0, 100, Strings.EMPTY);
        return ownerIdResponse.body().getContent().get(0).getOwnerId();
    }

    public String getAccountNumberByAllCreditAccount() {
        Response<AllCreditAccountsModel> accountNumberResponse = creditAccountApiStep
                .getAllCreditAccounts(0, 100, Strings.EMPTY);
        return accountNumberResponse.body().getContent().get(0).getAccountNumber();
    }
}
