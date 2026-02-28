package com.sanjai.digitalwalletsystem.service;

import com.sanjai.digitalwalletsystem.dto.UserRequestDto;
import com.sanjai.digitalwalletsystem.entity.User;
import com.sanjai.digitalwalletsystem.entity.Wallet;
import com.sanjai.digitalwalletsystem.repository.UserRepository;
import com.sanjai.digitalwalletsystem.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;

    public User createUser(UserRequestDto request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        User savedUser = null;


            savedUser = userRepository.save(user);
            Wallet wallet = new Wallet();

            wallet.setUser(savedUser);
            wallet.setBalance(0.0);

            walletRepository.save(wallet);

        return savedUser;
    }

}