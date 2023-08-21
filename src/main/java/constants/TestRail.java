package constants;

import helpers.PropertiesProvider;

public class TestRail {

    public static final boolean IS_ADD_RUN_REQUIRED = Boolean.parseBoolean(PropertiesProvider.provideTestRailProperty("isAddRunRequired"));
    public static final boolean IS_ADD_STATUS_REQUIRED = Boolean.parseBoolean(PropertiesProvider.provideTestRailProperty("isAddStatusRequired"));

    public static final String BASE_URL_FOR_TESTRAIL = "https://vmmreg32.testrail.net/";
    public static final String USERNAME = "testrailasoft@gmail.com";
    public static final String PASSWORD = "F@#@Fdsff422gf";
    public static final String PROJECT_ID = "317";
    public static final String RUN_ID = PropertiesProvider.provideTestRailProperty("runId");
    public static final String SUCCESS_COMMENT = "This test passed";
    public static final String FAILED_COMMENT = "This test failed";
    public static final String SKIPPED_COMMENT = "This test skipped";

    public static final int SUCCESS_STATE = 1;
    public static final int FAIL_STATE = 5;
    public static final int SKIP_STATE = 9;
}
