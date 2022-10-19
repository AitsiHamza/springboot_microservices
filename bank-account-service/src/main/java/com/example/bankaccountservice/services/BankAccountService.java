package com.example.bankaccountservice.services;

import com.example.bankaccountservice.dtos.BankAccountRequestDTO;
import com.example.bankaccountservice.dtos.BankAccountResponseDTO;


public interface BankAccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
