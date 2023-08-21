package api.models.controllers;

import lombok.Getter;

import java.util.List;

@Getter
public class AllAccountsModel {

    private List<AccountModel> content;
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