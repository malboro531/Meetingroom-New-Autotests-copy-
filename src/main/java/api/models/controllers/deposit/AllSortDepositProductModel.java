package api.models.controllers.deposit;

import api.models.controllers.PageAbleModel;
import api.models.controllers.SortModel;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AllSortDepositProductModel {
    private List<DepositProductModel> content;
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