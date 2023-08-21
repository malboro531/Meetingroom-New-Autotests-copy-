package mrn_api.user_controller;

import api.models.controllers.AllUsersModel;
import api.models.controllers.UserModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.util.Strings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.AllureData.API_USER_CONTROLLER;
import static constants.AllureData.EPIC_1_AUTHORIZATION;
import static constants.enums.Role.*;
import static java.net.HttpURLConnection.*;

@Epic(EPIC_1_AUTHORIZATION)
@Feature(API_USER_CONTROLLER)
public class GetUsersUnauthorizedTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(UNAUTHORIZED);
    }

    @TestRails(id = "C6313036")
    @Test(description = "Get current user, role UNAUTHORIZED", groups = {"Api"})
    public void c6313036() {
        Response<UserModel> response = userApiStep.getUser();
        checkResponseCode(response, HTTP_UNAUTHORIZED);
        checkAll();
    }
}
