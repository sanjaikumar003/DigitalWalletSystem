package com.sanjai.digitalwalletsystem.dto;

import lombok.*;


public class WalletResponseDto {

    private Long userId;
    private Double balance;

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
    public WalletResponseDto(Long userId, Double balance) {
        this.userId = userId;
        this.balance = balance;
    }
}