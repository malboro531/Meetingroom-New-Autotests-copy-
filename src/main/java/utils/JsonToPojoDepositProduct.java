package utils;

import api.models.controllers.deposit.PojoDepositProductModel;

import java.util.Objects;

public class JsonToPojoDepositProduct extends BaseJsonToPojo{

    private static final String PATH_POJO_DEPOSIT_PRODUCT_ADMIN = "src/test/resources/test_data_pojo_deposit_product_admin.json";
    private static final String PATH_INVALID_DATA_DEPOSIT_PRODUCT_ADMIN = "src/test/resources/test_invalid_data_deposit_product.json";
    private static final String PATH_NON_EXISTENT_DEPOSIT_PRODUCT_ADMIN = "src/test/resources/test_non_existent_data_deposit_product_admin.json";

    private static PojoDepositProductModel pojoDepositProductModel;
    private static PojoDepositProductModel pojoDepositProductModelInvalidData;
    private static PojoDepositProductModel pojoDepositProductModelNonExistentData;

    public static PojoDepositProductModel getPojoDepositProductModel() {
        if (Objects.isNull(pojoDepositProductModel)) {
            return getDataFromJson(PATH_POJO_DEPOSIT_PRODUCT_ADMIN, PojoDepositProductModel.class);
        }
        return pojoDepositProductModel;
    }

    public static PojoDepositProductModel getPojoDepositProductModelInvalidData() {
        if (Objects.isNull(pojoDepositProductModelInvalidData)) {
            return getDataFromJson(PATH_INVALID_DATA_DEPOSIT_PRODUCT_ADMIN, PojoDepositProductModel.class);
        }
        return pojoDepositProductModelInvalidData;
    }

    public static PojoDepositProductModel getPojoDepositProductModelNonExistentData() {
        if (Objects.isNull(pojoDepositProductModelNonExistentData)) {
            return getDataFromJson(PATH_NON_EXISTENT_DEPOSIT_PRODUCT_ADMIN, PojoDepositProductModel.class);
        }
        return pojoDepositProductModelNonExistentData;
    }
}
