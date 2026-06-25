package com.demo.transactions.service;

import com.demo.transactions.dtos.TransferRequest;
import com.demo.transactions.dtos.TransferResponse;
import com.demo.transactions.entities.Account;
import com.demo.transactions.entities.Transfer;
import com.demo.transactions.repo.AccountRepo;
import com.demo.transactions.repo.TransferRepo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferService {

    private final TransferRepo transferRepo;
    private final AccountRepo accountRepo;

    public TransferService(TransferRepo transferRepo,
                           AccountRepo accountRepo) {
        this.transferRepo = transferRepo;
        this.accountRepo = accountRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    public TransferResponse transfer(TransferRequest request) {
        Account from = accountRepo.findById(request.getFromAccountId())
                .orElseThrow(() -> new RuntimeException("Sender account not found"));
        Account to = accountRepo.findById(request.getToAccountId())
                .orElseThrow(() -> new RuntimeException("Receiver account not found"));

        if (from.getId().equals(to.getId())) {
            throw new RuntimeException("Can't transfer to your own account");
        }
        if (request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("cant transfer zero or negative amount");
        }
        if (from.getBalance().compareTo(request.getAmount()) <= 0) {
            throw new RuntimeException("Insufficient funds");
        }

        from.withdraw(request.getAmount());
        if (request.isFailAfterWithdraw()) {
            throw new RuntimeException("Simulated failure after withdraw");
        }

        to.deposit(request.getAmount());

        Transfer transfer = new Transfer(
                from.getId(),
                to.getId(),
                request.getAmount(),
                "SUCCESS"
        );

        transferRepo.save(transfer);

        return new TransferResponse(
                transfer.getId(),
                transfer.getFromAccountId(),
                transfer.getToAccountId(),
                transfer.getAmount(),
                transfer.getStatus()
        );
    }
}
