package com.sanjai.digitalwalletsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


public class TransactionResponseDto {

    private Long transactionId;
    private String status;
    private Double amount;
    private Long fromUser;
    private Long toUser;
    private LocalDateTime createdAt;

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
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

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getTransactionId() {
        return transactionId;
    }
    public TransactionResponseDto(Long transactionId,
                                  String status,
                                  Double amount,
                                  Long fromUser,
                                  Long toUser,
                                  LocalDateTime createdAt) {
        this.transactionId = transactionId;
        this.status = status;
        this.amount = amount;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.createdAt = createdAt;
    }
}