package mrn_api.user_controller;

import api.managers.DataBaseManager.DataBaseConnectionManager;
import api.models.controllers.UserModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.AllureData.API_USER_CONTROLLER;
import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.ApiDataBase.*;
import static constants.GlobalData.VALID_LOGIN_USER;
import static constants.GlobalData.VALID_PASSWORD_USER;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_USER_CONTROLLER)
public class PhoneValidationByUpdatingUserTest extends BaseApiTestUsingDataBase {

    @BeforeTest
    public void testBeforeClass() {
        tokenManager.getTokenModel(VALID_LOGIN_USER, VALID_PASSWORD_USER);
        userDbManager.create(FakeGenerator.generateFakeUser());
    }

    @TestRails(id = "C5944912")
    @Test(description = "User updating with ten digit phone", groups = {"Api"})
    public void userUpdatingWithTenDigitPhone() {
        updateUserPositive(FakeGenerator.getPhoneNumber(10));
    }

    @TestRails(id = "C5944913")
    @Test(description = "User updating with twelve digit phone", groups = {"Api"})
    public void userUpdatingWithTwelveDigitPhone() {
        updateUserPositive(FakeGenerator.getPhoneNumber(12));
    }

    @TestRails(id = "C5944914")
    @Test(description = "Error updating user with nine digit phone", groups = {"Api"})
    public void errorUpdatingUserWithNineDigitPhone() {
        updateUserNegative(FakeGenerator.getPhoneNumber(9));
    }

    @TestRails(id = "C5944915")
    @Test(description = "Error updating user with thirteen digit phone", groups = {"Api"})
    public void errorUpdatingUserWithThirteenDigitPhone() {
        updateUserNegative(FakeGenerator.getPhoneNumber(13));
    }

    @TestRails(id = "C5944916")
    @Test(description = "Error updating user with letter in phone", groups = {"Api"})
    public void errorUpdatingUserWithLetterInPhone() {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setPhone(FakeGenerator.getModifiedName(user.getPhone(), FakeGenerator.getNameGivenLength("?", 1), true));
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_CLIENT_ERROR_BAD_REQUEST);
        userApiStep.checkResponseTextBody(response, ERROR_MESSAGE_INVALID_PHONE_NUMBER);
        checkAll();
    }

    private void updateUserPositive(String phone) {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setPhone(phone);
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    private void updateUserNegative(String phone) {
        String id = DataBaseConnectionManager.getAllIds().get(0);
        UserModel user = FakeGenerator.generateFakeUser();
        user.setId(id);
        user.setPhone(phone);
        Response<Void> response = userApiStep.updateUserById(id, user);
        checkResponseCode(response, CODE_CLIENT_ERROR_BAD_REQUEST);
        userApiStep.checkResponseTextBody(response, ERROR_MESSAGE_INVALID_PHONE_NUMBER);
        checkAll();
    }

    @AfterClass
    public void testAfterClass() {
        userDbManager.delete();
    }
}
