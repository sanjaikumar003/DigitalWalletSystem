package com.sanjai.digitalwalletsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddMoneyResponseDto {

    private Long userId;
    private Double addedAmount;
    private Double updatedBalance;
    private String status;
}