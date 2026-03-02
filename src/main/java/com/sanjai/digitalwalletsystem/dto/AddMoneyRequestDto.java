package com.sanjai.digitalwalletsystem.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;



public class AddMoneyRequestDto {

    @NotNull
    private Long userId;

    @NotNull
    @Positive
    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }
}