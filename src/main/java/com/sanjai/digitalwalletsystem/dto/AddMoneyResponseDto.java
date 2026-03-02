package com.sanjai.digitalwalletsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class AddMoneyResponseDto {

    private Long userId;
    private Double addedAmount;
    private Double updatedBalance;
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setUpdatedBalance(Double updatedBalance) {
        this.updatedBalance = updatedBalance;
    }

    public Double getUpdatedBalance() {
        return updatedBalance;
    }

    public void setAddedAmount(Double addedAmount) {
        this.addedAmount = addedAmount;
    }

    public Double getAddedAmount() {
        return addedAmount;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
    public AddMoneyResponseDto(Long userId,
                               Double addedAmount,
                               Double updatedBalance,
                               String status) {
        this.userId = userId;
        this.addedAmount = addedAmount;
        this.updatedBalance = updatedBalance;
        this.status = status;
    }
}