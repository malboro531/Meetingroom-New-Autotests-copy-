package api.models.controllers;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardModel {
    @SerializedName("id")
    private String id;
    @SerializedName("account_id")
    private String accountId;
    @SerializedName("card_product_id")
    private String cardProductId;
    @SerializedName("holder_name")
    private String holderName;
    @SerializedName("payment_system")
    private String paymentSystem;
    @SerializedName("type_name")
    private String typeName;
    @SerializedName("last_four_numbers")
    private String lastFourNumbers;
    @SerializedName(value = "first_twelve_numbers_hash", alternate = "first_twelve_numbers")
    private String firstTwelveNumbersHash;
    @SerializedName("valid_from_date")
    private String validFromDate;
    @SerializedName("expire_date")
    private String expireDate;
    private int balance;
    private String currency;
    @SerializedName("is_active")
    private boolean isActive;
    @SerializedName("card_status")
    private String cardStatus;
    @SerializedName("is_main")
    private boolean isMain;
    @SerializedName("contract_id")
    private String contractId;
    public String limits;
}