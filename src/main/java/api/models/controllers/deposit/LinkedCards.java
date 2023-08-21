package api.models.controllers.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkedCards {

    private String id;
    private String firstTwelveNumbers;
    private String lastFourNumbers;
    private boolean isMainCard;
}
