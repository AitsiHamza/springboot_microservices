package com.example.bankaccountservice.services;

import lombok.AllArgsConstructor;
import com.example.bankaccountservice.dtos.BankAccountRequestDTO;
import com.example.bankaccountservice.dtos.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Transactional
@Service
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    private BankAccountRepository bankAccountRepository;

    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(bankAccountDTO.getType())
                .balance(bankAccountDTO.getBalance())
                .createdAt(new Date())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount savedBankAccount=bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO=BankAccountResponseDTO.builder()
                //.id(UUID.randomUUID().toString())
                .type(savedBankAccount.getType())
                .balance(savedBankAccount.getBalance())
                //.createdAt(new Date())
                .currency(savedBankAccount.getCurrency())
                .build();
        return bankAccountResponseDTO;
    }
}
