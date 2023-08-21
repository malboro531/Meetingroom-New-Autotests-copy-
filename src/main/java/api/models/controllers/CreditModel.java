package api.models.controllers;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreditModel {
    private String id;
    @SerializedName(value = "credit_name", alternate = "product_name")
    private String creditName;
    @SerializedName("min_sum")
    private int minSum;
    @SerializedName("max_sum")
    private int maxSum;
    @SerializedName("multiplicity_of_sum")
    private int multiplicityOfSum;
    private String currency;
    @SerializedName("loan_rate")
    private double loanRate;
    @SerializedName("need_guarantee")
    private boolean needQuarantee;
    @SerializedName("early_repayment")
    private boolean earlyRepayment;
    @SerializedName("min_term")
    private int minTerm;
    @SerializedName("max_term")
    private int maxTerm;
    @SerializedName("multiplicity_of_temp")
    private int multiplicityOfTemp;
    private String description;
    @SerializedName("need_income_statement")
    private boolean needIncomeStatement;
    @SerializedName(value = "penalty_id", alternate = "penalty")
    private String penaltyId;
    @SerializedName("is_active")
    private boolean active;
}