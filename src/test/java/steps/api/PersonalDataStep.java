package steps.api;

import api.managers.PersonalDataManager;
import api.models.AllUserPersonalDataModel;
import api.models.controllers.UserInfoModel;
import io.qameta.allure.Step;
import retrofit2.Response;
import verification.Verify;

public class PersonalDataStep {

    PersonalDataManager personalDataManager = new PersonalDataManager();

    @Step("Get user personal data")
    public Response<AllUserPersonalDataModel> getUserPersonalData() {
        return personalDataManager.getUserPersonalData();
    }

    @Step("Get user personal data by phone")
    public Response<AllUserPersonalDataModel> getUserPersonalDataByPhone(String phone) {
        return personalDataManager.getUserPersonalDataByPhone(phone);
    }

    @Step("Get user information by entry data")
    public Response<UserInfoModel> getUserInfoByEntryData(String typeOfData, String entryData) {
        return personalDataManager.getUserInfoByEntryData(typeOfData, entryData);
    }

    @Step("Get user personal data by user id")
    public Response<AllUserPersonalDataModel> getUserPersonalDataByUserId(String userId) {
        return personalDataManager.getUserPersonalDataByUserId(userId);
    }

    @Step("Verify that all fields in response body 'get user information' are not null")
    public void verifyFieldsNotNull(UserInfoModel userInfoModel) {
        Verify.verifyNotNull(userInfoModel.getOwnerId(), "There is owner id in response body");
        Verify.verifyNotNull(userInfoModel.getFirstName(), "There is first name in response body");
        Verify.verifyNotNull(userInfoModel.getLastName(), "There is last name in response body");
        Verify.verifyNotNull(userInfoModel.getPatronymic(), "There is patronymic in response body");
        Verify.verifyNotNull(userInfoModel.getAccountNumber(), "There is account number in response body");
        Verify.verifyNotNull(userInfoModel.getCurrency(), "There is currency in response body");
        Verify.verifyNotNull(userInfoModel.getBankName(), "There is bank name in response body");
    }
}
