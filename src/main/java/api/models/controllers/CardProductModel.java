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
public class CardProductModel {
    public int cashback;
    public double price;
    public String advantages;
    @SerializedName("bank_partners")
    public String bankPartners;
    @SerializedName("loyalty_program")
    public String loyaltyProgram;
    @SerializedName("maintenance_cost")
    public double maintenanceCost;
    @SerializedName("min_sum_balance")
    public int minSumBalance;
    public String currency;
    public String limits;
    @SerializedName("payment_system")
    public String paymentSystem;
    @SerializedName("type_name")
    public String typeName;
    public String id;
}