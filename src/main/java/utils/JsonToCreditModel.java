package utils;

import api.models.controllers.CreditModel;

import java.util.Objects;

public class JsonToCreditModel extends BaseJsonToPojo{

    private static final String PATH_POJO_CREDIT_PRODUCT = "src/test/resources/test_data_pojo_credit_product.json";

    private static CreditModel pojoCreditProductModel;

    public static CreditModel getPojoCreditProductModel() {
        if (Objects.isNull(pojoCreditProductModel)) {
            return getDataFromJson(PATH_POJO_CREDIT_PRODUCT, CreditModel.class);
        }
        return pojoCreditProductModel;
    }
}
