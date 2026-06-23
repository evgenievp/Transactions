package com.demo.transactions.repo;

import com.demo.transactions.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepo extends JpaRepository<Transfer, Long> {
}
