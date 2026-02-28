package com.sanjai.digitalwalletsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fromUser;

    private Long toUser;

    private Double amount;

    private String status;

    private LocalDateTime createdAt = LocalDateTime.now();
}