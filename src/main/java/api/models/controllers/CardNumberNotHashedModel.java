package api.models.controllers;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CardNumberNotHashedModel {
    private String id;
    @SerializedName("first_twelve")
    private String firstTwelve;
    @SerializedName("last_four_numbers")
    private String lastFourNumbers;
    @SerializedName("holder_name")
    private String holderName;
    @SerializedName("payment_system")
    private String paymentSystem;
    private String currency;
    @SerializedName("type_name")
    private String typeName;
}
