package com.sanjai.digitalwalletsystem.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AddMoneyRequestDto {

    @NotNull
    private Long userId;

    @NotNull
    @Positive
    private Double amount;
}