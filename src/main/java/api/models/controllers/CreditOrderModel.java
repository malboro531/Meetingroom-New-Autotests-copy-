package api.models.controllers;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class CreditOrderModel implements Serializable {
    private String id;
    @SerializedName("owner_id")
    private String ownerId;
    @SerializedName("credit_products_id")
    private String creditProductId;
    private String status;
    @SerializedName("creation_date")
    private String creationDate;
    private int amount;
    @SerializedName("temp_credit")
    private int tempCredit;
    @SerializedName("loan_rate")
    private double loanRate;
    @SerializedName("average_monthly_income")
    private int averageMonthlyIncome;
    @SerializedName("average_monthly_expenditure")
    private int averageMonthlyExpenditure;
    @SerializedName("employer_identification_id")
    private String employerId;
}
