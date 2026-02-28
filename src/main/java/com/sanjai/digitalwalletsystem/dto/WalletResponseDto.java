package com.sanjai.digitalwalletsystem.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletResponseDto {

    private Long userId;
    private Double balance;
}