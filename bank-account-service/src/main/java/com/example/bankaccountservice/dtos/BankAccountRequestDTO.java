package com.example.bankaccountservice.dtos;

import com.example.bankaccountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountRequestDTO {
    private double balance;
    private String currency;
    private AccountType type;
}
