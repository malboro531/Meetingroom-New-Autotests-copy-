package mrn_api.transfer_controller;

import api.models.controllers.AccountModel;
import api.models.controllers.TransferModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import verification.VerifySoft;

import static constants.GlobalData.EUR;
import static constants.enums.PaymentType.DEBIT_ACCOUNT;
import static constants.enums.PaymentType.PAYMENT;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.HTTP_ACCEPTED;

public class CreateRequestOnTransferMoney extends BaseApiTestUsingDataBase {

    AccountModel accountWithMoney;
    TransferModel transferModel = new TransferModel();

    @BeforeClass
    public void preparation() {
        authorization(ADMIN);
        accountWithMoney = FakeGenerator.generateFakeAccount();
        Response<AccountModel> testAccount = createAccount();
        accountWithMoney.setId(testAccount.body().getId());
        accountWithMoney.setOwnerId(testAccount.body().getOwnerId());
        accountWithMoney.setCurrency(EUR);
        accountWithMoney.setBalance(5000);
        Response<AccountModel> response = accountApiStep.updateAccount(accountWithMoney);

        transferModel.setUserId(userId);
        transferModel.setSourceNumber(response.body().getAccountNumber());
        transferModel.setSourcePaymentType(String.valueOf(DEBIT_ACCOUNT));
        transferModel.setDestinationNumber(createAccount().body().getAccountNumber());
        transferModel.setDestinationPaymentType(String.valueOf(DEBIT_ACCOUNT));
        transferModel.setAmount(2);
        transferModel.setCurrency(EUR);
        transferModel.setComment("Перевод");
        transferModel.setTransferType(String.valueOf(PAYMENT));
    }

    @TestRails(id = "C6211516")
    @Test(description = "Create request on transfer money from account to another account, role Admin", groups = {"Api"})
    public void c6211516() {
        Response<TransferModel> response = transferApiStep.createRequestOnTransferMoney(transferModel);
        checkResponseCode(response, HTTP_ACCEPTED);
        VerifySoft.verifyFalseSoft(response.body().getId().isEmpty(), "Field 'id' is not empty");
        checkAll();
    }
}
