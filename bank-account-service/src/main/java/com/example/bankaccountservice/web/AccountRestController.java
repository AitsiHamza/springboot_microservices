package com.example.bankaccountservice.web;

import lombok.AllArgsConstructor;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.repositories.BankAccountRepository;
import com.example.bankaccountservice.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private BankAccountService bankAccountService;

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount){
        if(bankAccount.getId()==null)bankAccount.setId(UUID.randomUUID().toString());
        //return bankAccountRepository.save(bankAccount);
        return bankAccountService.addAccount(bankAccount);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount save(@RequestBody BankAccount bankAccount,@PathVariable String id){
        BankAccount account=bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
        account.setBalance(bankAccount.getBalance());
        //..
        return bankAccountRepository.save(account);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id){
        BankAccount account=bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
        bankAccountRepository.deleteById(id);
    }
}
