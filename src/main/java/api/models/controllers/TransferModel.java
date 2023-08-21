package api.models.controllers;

import lombok.Data;

@Data
public class TransferModel {
    private String id;
    private String userId;
    private String sourceNumber;
    private String sourcePaymentType;
    private String destinationNumber;
    private String destinationPaymentType;
    private int amount;
    private String currency;
    private String transferStatus;
    private String createTime;
    private String transferType;
    private String comment;
}