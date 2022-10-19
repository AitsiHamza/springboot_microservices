package com.example.bankaccountservice.repositories;

import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@RepositoryRestRessource
public interface BankAccountRestRepository extends JpaRepository<BankAccount,String> {
    @RestRessource(path="/byType")
    List<BankAccount> findByType(@Param("t")AccountType type);
}
