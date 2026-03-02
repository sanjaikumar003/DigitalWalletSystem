package com.sanjai.digitalwalletsystem.service;

import com.sanjai.digitalwalletsystem.dto.*;
import com.sanjai.digitalwalletsystem.entity.Transaction;
import com.sanjai.digitalwalletsystem.entity.Wallet;
import com.sanjai.digitalwalletsystem.repository.TransactionRepository;
import com.sanjai.digitalwalletsystem.repository.WalletRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service

public class WalletService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;
    public WalletService(WalletRepository walletRepository,TransactionRepository transactionRepository){
        this.walletRepository=walletRepository;
        this.transactionRepository=transactionRepository;
    }
    @Transactional
    public AddMoneyResponseDto addMoney(AddMoneyRequestDto request) {

        Wallet wallet = walletRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Wallet not found"));

        wallet.setBalance(wallet.getBalance() + request.getAmount());

        Transaction done = new Transaction();
        done.setFromUser(null);
        done.setToUser(request.getUserId());
        done.setAmount(request.getAmount());
        done.setStatus("SUCCESS");

        transactionRepository.save(done);
        return new AddMoneyResponseDto(
                request.getUserId(),
                request.getAmount(),
                wallet.getBalance(),
                "SUCCESS"
        );
    }

    @Transactional
    public TransactionResponseDto  transfer(TransferRequestDto request) {

        Wallet sender = walletRepository.findByUserId(request.getFromUser())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sender not found"));


        Wallet receiver = walletRepository.findByUserId(request.getToUser())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Receiver not found"));

        if (request.getFromUser().equals(request.getToUser())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot transfer to same account");
        }
        if (sender.getBalance() < request.getAmount()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Insufficient Balance");
        }

        sender.setBalance(sender.getBalance() - request.getAmount());
        receiver.setBalance(receiver.getBalance() + request.getAmount());

        Transaction done = new Transaction();
        done.setFromUser(request.getFromUser());
        done.setToUser(request.getToUser());
        done.setAmount(request.getAmount());
        done.setStatus("SUCCESS");

        transactionRepository.save(done);
        return new TransactionResponseDto(
                done.getId(),
                done.getStatus(),
                done.getAmount(),
                done.getFromUser(),
                done.getToUser(),
                done.getCreatedAt()
        );
    }

    public WalletResponseDto getBalance(Long userId) {

        Wallet wallet = walletRepository.findByUserId(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Wallet not found"));

        return new WalletResponseDto(userId, wallet.getBalance());
    }
}