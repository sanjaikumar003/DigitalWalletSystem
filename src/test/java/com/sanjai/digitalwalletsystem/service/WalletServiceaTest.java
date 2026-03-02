package com.sanjai.digitalwalletsystem.service;

import com.sanjai.digitalwalletsystem.dto.TransferRequestDto;
import com.sanjai.digitalwalletsystem.entity.Wallet;
import com.sanjai.digitalwalletsystem.repository.TransactionRepository;
import com.sanjai.digitalwalletsystem.repository.WalletRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WalletServiceTest {

    @InjectMocks
    private WalletService walletService;

    @Mock
    private WalletRepository walletRepository;

    @Mock
    private TransactionRepository transactionRepository;
    @Test
    void transfer_sameuser(){
        TransferRequestDto request=new TransferRequestDto( );
                request.setFromUser(1L);
                request.setToUser(1L);
                request.setAmount(500.0);

        Wallet wallet=new Wallet();
        wallet.setBalance(2000.0);
        when(walletRepository.findByUserId(1L)).thenReturn(Optional.of(wallet));
        assertThrows(ResponseStatusException.class, () ->{
            walletService.transfer(request);
        });
    }
    @Test
    void insufficient_balance(){
        TransferRequestDto request=new TransferRequestDto();
        request.setFromUser(1L);
        request.setToUser(25L);
        request.setAmount(5000.0);

        Wallet sender=new Wallet();
        sender.setBalance(4000.0);

        Wallet receiver=new Wallet();
        receiver.setBalance(6000.0);

        when(walletRepository.findByUserId(1L)).thenReturn(Optional.of(sender));
        when(walletRepository.findByUserId(25L)).thenReturn(Optional.of(receiver));
        assertThrows(ResponseStatusException.class, ()-> {
            walletService.transfer(request);
        } );
    }


}