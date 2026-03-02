package com.sanjai.digitalwalletsystem.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;


public class TransferRequestDto {


    @NotNull
    private Long fromUser;

    @NotNull
    private Long toUser;

    @NotNull
    @Positive
    private Double amount;

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setToUser(Long toUser) {
        this.toUser = toUser;
    }

    public Long getToUser() {
        return toUser;
    }

    public void setFromUser(Long fromUser) {
        this.fromUser = fromUser;
    }

    public Long getFromUser() {
        return fromUser;
    }
}