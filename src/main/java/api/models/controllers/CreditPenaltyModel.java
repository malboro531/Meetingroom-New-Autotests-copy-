package api.models.controllers;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreditPenaltyModel {
    @SerializedName(value = "penalty_id", alternate = "id")
    private String id;
    @SerializedName(value = "penalty_name", alternate = "name_penalty")
    private String name;
    @SerializedName("percent_penalty")
    private double percent;
    @SerializedName("amount_min_penalty")
    private int amountMin;
    @SerializedName("max_percent_penalty")
    private double maxPercent;
    @SerializedName("amount_max_penalty")
    private int amountMax;
    @SerializedName("is_penny")
    private boolean isPenny;
}
