package mrn_api.personal_data_controller;

import api.managers.DataBaseManager.DataBaseAbstractManager;
import api.models.AllUserPersonalDataModel;
import api.models.controllers.*;
import api.services.TestRails;
import helpers.FakeGenerator;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;
import verification.VerifySoft;

import static constants.AllureData.API_PERSONAL_DATA_CONTROLLER;
import static constants.ApiDataBase.*;
import static constants.enums.Role.ADMIN;
import static java.net.HttpURLConnection.*;

@Feature(API_PERSONAL_DATA_CONTROLLER)
public class GetUserPersonalDataAdminTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(ADMIN);
    }

    @TestRails(id = "C6328233")
    @Test(description = "Get user personal data, role Admin", groups = {"Api"})
    public void c6328233() {
        Response<AllUserPersonalDataModel> response = personalDataStep.getUserPersonalData();
        checkResponseCode(response, HTTP_OK);
        userApiStep.verifyFieldsNotNull(response.body().getUser());
        AddressModel addressModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_ADDRESS_BY_USER_ID,
                userId), AddressModel.class);
        addressApiStep.checkAddress(response.body().getAddress(), addressModelSql);
        PassportModel passportModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_PASSPORT_BY_USER_ID,
                userId), PassportModel.class);
        passportApiStep.checkPassport(response.body().getPassport(), passportModelSql);
        checkAll();
    }

    @TestRails(id = "C6208638")
    @Test(description = "Get user personal data by phone, role Admin", groups = {"Api"})
    public void c6208638() {
        Response<AllUserPersonalDataModel> response = personalDataStep.getUserPersonalDataByPhone(userPhone);
        checkResponseCode(response, HTTP_OK);
        VerifySoft.verifyEqualsSoft(response.body().getUser().getPhone(), userPhone, ERROR_MESSAGE_INVALID_PHONE_NUMBER);
        userApiStep.verifyFieldsNotNull(response.body().getUser());
        AddressModel addressModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_ADDRESS_BY_USER_ID,
                userId), AddressModel.class);
        addressApiStep.checkAddress(response.body().getAddress(), addressModelSql);
        PassportModel passportModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_PASSPORT_BY_USER_ID,
                userId), PassportModel.class);
        passportApiStep.checkPassport(response.body().getPassport(), passportModelSql);
        checkAll();
    }

    @TestRails(id = "C6208678")
    @Test(description = "Get user personal data by phone with valid but non-existent data, role Admin", groups = {"Api"})
    public void c6208678() {
        String userPhone = FakeGenerator.generateFakeUser().getPhone();
        Response<AllUserPersonalDataModel> response = personalDataStep.getUserPersonalDataByPhone(userPhone);
        checkResponseCode(response, HTTP_NOT_FOUND);
        checkAll();
    }

    private CardModel createCard() {
        CardModel cardModel = FakeGenerator.generateFakeCard();
        cardModel.setCardProductId(createCardProduct().body().getId());
        cardModel.setAccountId(createAccount().body().getId());
        Response<CardModel> createCardResponse = cardApiStep.createCard(cardModel);
        checkResponseCode(createCardResponse, HTTP_OK);
        return createCardResponse.body();
    }

    @TestRails(id = "C6096188")
    @Test(description = "Get user information by card number, role Admin", groups = {"Api"})
    public void c6096188() {
        CardModel card = createCard();
        Response<CardNumberNotHashedModel> responseCard = cardApiStep
                .getCardsHashedNumbers(card.getFirstTwelveNumbersHash(), card.getLastFourNumbers());
        String cardNumber = responseCard.body().getFirstTwelve() + card.getLastFourNumbers();
        Response<UserInfoModel> response = personalDataStep.getUserInfoByEntryData("1", cardNumber);
        checkResponseCode(response, HTTP_OK);
        personalDataStep.verifyFieldsNotNull(response.body());
        checkAll();
    }

    @TestRails(id = "C6096190")
    @Test(description = "Get user information by card number with field entryData is empty, role Admin", groups = {"Api"})
    public void c6096190() {
        Response<UserInfoModel> response = personalDataStep.getUserInfoByEntryData("0", null);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6096191")
    @Test(description = "Get user information by card number with field typeofData is empty, role Admin", groups = {"Api"})
    public void c6096191() {
        CardModel card = createCard();
        Response<CardNumberNotHashedModel> responseCard = cardApiStep
                .getCardsHashedNumbers(card.getFirstTwelveNumbersHash(), card.getLastFourNumbers());
        String cardNumber = responseCard.body().getFirstTwelve() + card.getLastFourNumbers();
        Response<UserInfoModel> response = personalDataStep.getUserInfoByEntryData(null, cardNumber);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6096192")
    @Test(description = "Get user information by account number, role Admin", groups = {"Api"})
    public void c6096192() {
        CardModel card = createCard();
        Response<AccountModel> responseAccount = accountApiStep.getAccountById(card.getAccountId());
        String accountNumber = responseAccount.body().getAccountNumber();
        Response<UserInfoModel> response = personalDataStep.getUserInfoByEntryData("2", accountNumber);
        checkResponseCode(response, HTTP_OK);
        personalDataStep.verifyFieldsNotNull(response.body());
        checkAll();
    }

    @TestRails(id = "C6096194")
    @Test(description = "Get user information by account number with field entryData is empty, role Admin", groups = {"Api"})
    public void c6096194() {
        Response<UserInfoModel> response = personalDataStep.getUserInfoByEntryData("2", null);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6096195")
    @Test(description = "Get user information by account number with field typeofData is empty, role Admin", groups = {"Api"})
    public void c6096195() {
        CardModel card = createCard();
        Response<AccountModel> responseAccount = accountApiStep.getAccountById(card.getAccountId());
        String accountNumber = responseAccount.body().getAccountNumber();
        Response<UserInfoModel> response = personalDataStep.getUserInfoByEntryData(null, accountNumber);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6096184")
    @Test(description = "Get user information by phone number, role Admin", groups = {"Api"})
    public void c6096184() {
        Response<UserInfoModel> response = personalDataStep.getUserInfoByEntryData("0", userPhone);
        checkResponseCode(response, HTTP_OK);
        personalDataStep.verifyFieldsNotNull(response.body());
        checkAll();
    }

    @TestRails(id = "C6096186")
    @Test(description = "Get user information by phone number with field entryData is empty, role Admin", groups = {"Api"})
    public void c6096186() {
        Response<UserInfoModel> response = personalDataStep.getUserInfoByEntryData("0", null);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6096187")
    @Test(description = "Get user information by phone number with field typeofData is empty, role Admin", groups = {"Api"})
    public void c6096187() {
        Response<UserInfoModel> response = personalDataStep.getUserInfoByEntryData(null, userPhone);
        checkResponseCode(response, HTTP_BAD_REQUEST);
        checkAll();
    }

    @TestRails(id = "C6477129")
    @Test(description = "Get user personal data by user id, role Admin", groups = {"Api"})
    public void c6477129() {
        Response<AllUserPersonalDataModel> response = personalDataStep.getUserPersonalDataByUserId(userId);
        checkResponseCode(response, HTTP_OK);
        userApiStep.verifyFieldsNotNull(response.body().getUser());
        AddressModel addressModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_ADDRESS_BY_USER_ID,
                userId), AddressModel.class);
        addressApiStep.checkAddress(response.body().getAddress(), addressModelSql);
        PassportModel passportModelSql = DataBaseAbstractManager.getInfoFromDB(String.format(SQL_SELECT_PASSPORT_BY_USER_ID,
                userId), PassportModel.class);
        passportApiStep.checkPassport(response.body().getPassport(), passportModelSql);
        checkAll();
    }
}
