package com.demo.transactions;

import com.demo.transactions.dtos.CreateAccountRequest;
import com.demo.transactions.entities.Account;
import com.demo.transactions.entities.User;
import com.demo.transactions.repo.AccountRepo;
import com.demo.transactions.repo.UserRepo;
import com.demo.transactions.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AccountServiceTests {

    @Mock
    private AccountRepo accountRepo;

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private AccountService accountService;

    @Test
    void createAccountExpectedOk() {
        User user = new User();
        user.setId(1L);
        user.setUsername("pesho");
        user.setEmail("p@abv.bg");

        CreateAccountRequest request = new CreateAccountRequest();
        request.setIban("BGEN00001");
        request.setInitialBalance(BigDecimal.ZERO);

        when(userRepo.findById(1L)).thenReturn(Optional.of(user));

        accountService.createAccount(1L, request);

        verify(accountRepo).save(any(Account.class));

    }




}
