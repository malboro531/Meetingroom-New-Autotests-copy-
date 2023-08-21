package utils;

import api.models.controllers.deposit.DepositModel;

import java.util.Objects;

public class JsonToPojoDeposit extends BaseJsonToPojo {

    private static final String PATH_POJO_DEPOSIT = "src/test/resources/test_data_pojo_deposit.json";
    private static final String PATH_POJO_DEPOSIT_NON_EXISTENT_DATA = "src/test/resources/test_data_pojo_deposit_non_existent.json";

    private static DepositModel depositModel;
    private static DepositModel depositModelNonExistent;

    public static DepositModel getDepositModel() {
        if (Objects.isNull(depositModel)) {
            return getDataFromJson(PATH_POJO_DEPOSIT, DepositModel.class);
        }
        return depositModel;
    }

    public static DepositModel getDepositModelNonExistent() {
        if (Objects.isNull(depositModelNonExistent)) {
            return getDataFromJson(PATH_POJO_DEPOSIT_NON_EXISTENT_DATA, DepositModel.class);
        }
        return depositModelNonExistent;
    }
}
