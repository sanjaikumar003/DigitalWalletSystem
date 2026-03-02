package com.sanjai.digitalwalletsystem.controller;

import com.sanjai.digitalwalletsystem.dto.UserRequestDto;
import com.sanjai.digitalwalletsystem.entity.User;
import com.sanjai.digitalwalletsystem.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRequestDto request) {
        return ResponseEntity.ok(userService.createUser(request));
    }
}