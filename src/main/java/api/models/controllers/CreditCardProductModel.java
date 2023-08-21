package api.models.controllers;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreditCardProductModel {
    private String id;
    private int cashback;
    private double price;
    private String advantages;
    @SerializedName("bank_partners")
    private String bankPartners;
    @SerializedName("loyalty_program")
    private String loyaltyProgram;
    @SerializedName("maintenance_cost")
    private int maintenanceCost;
    @SerializedName("min_sum_balance")
    private int minSumBalance;
    private String currency;
    @SerializedName(value = "typeCardId", alternate = "type_card_id")
    private String typeCardId;
}
