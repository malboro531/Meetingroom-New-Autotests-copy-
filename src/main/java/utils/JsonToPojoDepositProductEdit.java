package utils;

import api.models.controllers.deposit.PojoDepositProductEditModel;

import java.util.Objects;

public class JsonToPojoDepositProductEdit extends BaseJsonToPojo{

    private static final String PATH_POJO_DEPOSIT_PRODUCT_EDIT_ADMIN = "src/test/resources/test_data_pojo_deposit_product_edit_admin.json";
    private static final String PATH_NON_EXISTENT_DEPOSIT_EDIT_PRODUCT_ADMIN = "src/test/resources/test_data_pojo_deposit_product_non_exist_edit_admin.json";

    private static PojoDepositProductEditModel pojoDepositProductEditModel;
    private static PojoDepositProductEditModel pojoDepositProductNonExistEditModel;

    public static PojoDepositProductEditModel getDepositProductEditModel() {
        if (Objects.isNull(pojoDepositProductEditModel)) {
            return getDataFromJson(PATH_POJO_DEPOSIT_PRODUCT_EDIT_ADMIN, PojoDepositProductEditModel.class);
        }
        return pojoDepositProductEditModel;
    }

    public static PojoDepositProductEditModel getDepositProductModelNonExistentData() {
        if (Objects.isNull(pojoDepositProductNonExistEditModel)) {
            return getDataFromJson(PATH_NON_EXISTENT_DEPOSIT_EDIT_PRODUCT_ADMIN, PojoDepositProductEditModel.class);
        }
        return pojoDepositProductNonExistEditModel;
    }
}
