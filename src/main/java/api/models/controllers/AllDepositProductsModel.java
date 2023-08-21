package api.models.controllers;

import api.models.controllers.deposit.DepositProductModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllDepositProductsModel {
    private List<DepositProductModel> content;
    private int totalPages;
    private int totalElements;
    private int number;
    private int numberOfElements;
    private int size;
    private boolean first;
    private boolean last;
    private boolean empty;
}