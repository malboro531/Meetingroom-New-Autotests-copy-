package api.models.controllers;


import lombok.Getter;

@Getter
public class InformationModel {
    private int id;
    private int page;
    private int size;
    private String name;
    private String cityId;
    private String sort;
    private boolean onlyWithBranches;
    private boolean singlePage;
}
