package mrn_api.user_controller;

import api.models.controllers.UserModel;
import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;

public class CreateUserUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initiateToken() {
        authorization(USER);
    }

    @TestRails(id = "C6275339")
    @Test(description = "User creating with valid data", groups = {"Api"})
    public void c6275339() {
        Response<UserModel> response = userApiStep.createUser(FakeGenerator.generateFakeUser());
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }
}
