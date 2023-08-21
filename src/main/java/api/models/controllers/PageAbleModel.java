package api.models.controllers;

import lombok.Getter;

@Getter
public class PageAbleModel {

    private SortModel sort;
    private int pageNumber;
    private int pageSize;
    private int offset;
    private boolean paged;
    private boolean unpaged;
}
