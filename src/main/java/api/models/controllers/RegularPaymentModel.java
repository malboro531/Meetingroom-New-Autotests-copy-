package api.models.controllers;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegularPaymentModel {
    private String id;
    private String description;
    @SerializedName("start_date")
    private String startDate;
    @SerializedName("next_date")
    private String nextDate;
    @SerializedName("source_card_id")
    private String sourceCardId;
    @SerializedName("recipient_card_id")
    private String recipientCardId;
    private int amount;
    private String frequency;
    @SerializedName("is_active")
    private boolean active;
}
