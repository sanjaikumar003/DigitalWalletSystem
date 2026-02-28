package com.sanjai.digitalwalletsystem.controller;

import com.sanjai.digitalwalletsystem.dto.*;
import com.sanjai.digitalwalletsystem.service.WalletService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/add")
    public ResponseEntity<AddMoneyResponseDto> addMoney(@Valid @RequestBody AddMoneyRequestDto request) {
        return ResponseEntity.ok( walletService.addMoney(request));
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransactionResponseDto> transfer(@Valid @RequestBody TransferRequestDto request) {
        return ResponseEntity.ok(walletService.transfer(request));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<WalletResponseDto> getBalance(@PathVariable Long userId) {
        return ResponseEntity.ok(walletService.getBalance(userId));
    }
}