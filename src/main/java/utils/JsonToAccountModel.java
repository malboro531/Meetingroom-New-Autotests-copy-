package utils;

import api.models.controllers.AccountModel;

import java.util.Objects;

public class JsonToAccountModel extends BaseJsonToPojo{

    private static final String PATH_USER_ACCOUNT = "src/test/resources/test_data_user_account.json";
    private static final String PATH_ADMIN_ACCOUNT = "src/test/resources/test_data_admin_account.json";

    private static AccountModel accountModelAdmin;
    private static AccountModel accountModelUser;

    public static AccountModel getAccountModelAdmin() {
        if (Objects.isNull(accountModelAdmin)) {
            return getDataFromJson(PATH_ADMIN_ACCOUNT, AccountModel.class);
        }
        return accountModelAdmin;
    }

    public static AccountModel getAccountModelUser() {
        if (Objects.isNull(accountModelUser)) {
            return getDataFromJson(PATH_USER_ACCOUNT, AccountModel.class);
        }
        return accountModelUser;
    }

    public static void clearAccountModelAdmin() {
        accountModelAdmin = null;
    }

    public static void clearAccountModelUser() {
        accountModelUser = null;
    }
}
