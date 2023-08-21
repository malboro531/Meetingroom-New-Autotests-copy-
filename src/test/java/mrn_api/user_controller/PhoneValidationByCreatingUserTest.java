package mrn_api.user_controller;

import api.models.controllers.UserModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.AllureData.API_USER_CONTROLLER;
import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.ApiDataBase.*;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_USER_CONTROLLER)
public class PhoneValidationByCreatingUserTest extends BaseApiTestUsingDataBase {

    @TestRails(id = "C5944892")
    @Test(description = "User creating with ten digit phone", groups = {"Api"})
    public void userCreatingWithTenDigitPhone() {
        createUserPositive(FakeGenerator.getPhoneNumber(10));
    }

    @TestRails(id = "C5944893")
    @Test(description = "User creating with twelve digit phone", groups = {"Api"})
    public void userCreatingWithTwelveDigitPhone() {
        createUserPositive(FakeGenerator.getPhoneNumber(12));
    }

    @TestRails(id = "C5944894")
    @Test(description = "Error creating user with nine digit phone", groups = {"Api"})
    public void errorCreatingUserWithNineDigitPhone() {
        createUserNegative(FakeGenerator.getPhoneNumber(9));
    }

    @TestRails(id = "C5944895")
    @Test(description = "Error creating user with thirteen digit phone", groups = {"Api"})
    public void errorCreatingUserWithThirteenDigitPhone() {
        createUserNegative(FakeGenerator.getPhoneNumber(13));
    }

    @TestRails(id = "C5944896")
    @Test(description = "Error creating user with letter in phone", groups = {"Api"})
    public void errorCreatingUserWithLetterInPhone() {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setPhone(FakeGenerator.getModifiedName(user.getPhone(), FakeGenerator.getNameGivenLength("?", 1), true));
        Response<UserModel> response = userApiStep.createUser(user);
        checkResponseCode(response, CODE_CLIENT_ERROR_BAD_REQUEST);
        userApiStep.checkResponseTextBody(response, ERROR_MESSAGE_INVALID_PHONE_NUMBER);
        checkAll();
    }

    private void createUserPositive(String phone) {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setPhone(phone);
        Response<UserModel> response = userApiStep.createUser(user);
        checkResponseCode(response, CODE_SUCCESS_OK);
        checkAll();
    }

    private void createUserNegative(String phone) {
        UserModel user = FakeGenerator.generateFakeUser();
        user.setPhone(phone);
        Response<UserModel> response = userApiStep.createUser(user);
        checkResponseCode(response, CODE_CLIENT_ERROR_BAD_REQUEST);
        userApiStep.checkResponseTextBody(response, ERROR_MESSAGE_INVALID_PHONE_NUMBER);
        checkAll();
    }

    @AfterClass
    public void testAfterClass() {
        userDbManager.delete();
    }
}
