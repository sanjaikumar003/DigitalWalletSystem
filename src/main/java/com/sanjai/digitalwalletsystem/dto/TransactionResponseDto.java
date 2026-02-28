package com.sanjai.digitalwalletsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TransactionResponseDto {

    private Long transactionId;
    private String status;
    private Double amount;
    private Long fromUser;
    private Long toUser;
    private LocalDateTime createdAt;
}