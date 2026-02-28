package com.sanjai.digitalwalletsystem.repository;

import com.sanjai.digitalwalletsystem.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByFromUserOrToUser(Long fromUser, Long toUser);
}