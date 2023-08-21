package api.models.controllers;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AllCreditOrdersModel {
    private List<CreditOrderModel> content;
    private PageAbleModel pageable;
    private SortModel sort;
    private int totalPages;
    private int totalElements;
    private int number;
    private int numberOfElements;
    private int size;
    private boolean first;
    private boolean last;
    private boolean empty;
}
