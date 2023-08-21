package mrn_api.user_controller;

import api.services.TestRails;
import helpers.FakeGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import steps.BaseApiTestUsingDataBase;

import static constants.enums.Role.USER;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;

public class DeleteUserUserTest extends BaseApiTestUsingDataBase {

    @BeforeClass
    public void initialToken() {
        authorization(USER);
    }

    @TestRails(id = "C6303570")
    @Test(description = "Error deleting with valid, but not existing id", groups = {"Api"})
    public void c6303570() {
        Response<Void> response = userApiStep.deleteUser(FakeGenerator.generateUuid());
        checkResponseCode(response, HTTP_FORBIDDEN);
        checkAll();
    }
}
