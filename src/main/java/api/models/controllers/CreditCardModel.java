package api.models.controllers;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreditCardModel {
    private String id;
    @SerializedName("account_id")
    private String accountId;
    @SerializedName(value = "card_product_id", alternate = "credit_card_product_id")
    private String cardProductId;
    @SerializedName("is_active")
    private boolean isActive;
    @SerializedName("last_four_numbers")
    private String lastFourNumbers;
    @SerializedName("first_twelve_numbers")
    private String firstTwelveNumbers;
    @SerializedName("valid_from_date")
    private String validFromDate;
    @SerializedName("expire_date")
    private String expireDate;
    @SerializedName("holder_name")
    private String holderName;
    @SerializedName("security_code")
    private String securityCode;
}
