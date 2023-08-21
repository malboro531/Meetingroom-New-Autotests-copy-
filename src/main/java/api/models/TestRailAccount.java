package api.models;

import com.gurock.testrail.APIClient;

import static constants.TestRail.*;

public class TestRailAccount {

    private static APIClient client;

    private TestRailAccount() {
    }

    public static APIClient getTestRailAccount() {
        if (client == null) {
            client = new APIClient(BASE_URL_FOR_TESTRAIL);
            client.setUser(USERNAME);
            client.setPassword(PASSWORD);
        }
        return client;
    }
}
