package com.sanjai.digitalwalletsystem.service;

import com.sanjai.digitalwalletsystem.dto.UserRequestDto;
import com.sanjai.digitalwalletsystem.dto.UserResponseDto;

import com.sanjai.digitalwalletsystem.entity.User;
import com.sanjai.digitalwalletsystem.entity.Wallet;
import com.sanjai.digitalwalletsystem.repository.UserRepository;
import com.sanjai.digitalwalletsystem.repository.WalletRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;

    private final BCryptPasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository,WalletRepository walletRepository,BCryptPasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.walletRepository=walletRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public UserResponseDto createUser(UserRequestDto request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(user);

            Wallet wallet = new Wallet();

            wallet.setUser(savedUser);
            wallet.setBalance(0.0);

            walletRepository.save(wallet);

        return new UserResponseDto(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );

    }

}