package com.demo.transactions;

import com.demo.transactions.dtos.TransferRequest;
import com.demo.transactions.entities.Account;
import com.demo.transactions.repo.AccountRepo;
import com.demo.transactions.repo.TransferRepo;
import com.demo.transactions.service.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransferServiceTest {

    @Mock
    private TransferRepo transferRepo;

    @Mock
    private AccountRepo accountRepo;

    @InjectMocks
    private TransferService transferService;

    @Test
    void transferShouldFailAndThrowException() {
        Account from = new Account();
        from.setId(1L);
        from.setBalance(BigDecimal.valueOf(100));

        Account to = new Account();
        to.setId(2L);
        to.setBalance(BigDecimal.ZERO);

        TransferRequest request = new TransferRequest();
        request.setFromAccountId(1L);
        request.setToAccountId(2L);
        request.setAmount(BigDecimal.valueOf(100));
        request.setFailAfterWithdraw(true);

        when(accountRepo.findById(1L)).thenReturn(Optional.of(from));
        when(accountRepo.findById(2L)).thenReturn(Optional.of(to));

        assertThrows(RuntimeException.class, () -> transferService.transfer(request));

        verify(transferRepo, never()).save(any());
    }
}