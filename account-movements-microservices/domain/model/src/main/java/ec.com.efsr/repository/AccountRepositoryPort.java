package ec.com.efsr.repository;

import ec.com.efsr.models.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepositoryPort {
    Optional<Account> findAccountById(String id);
    List<Account> findAllAccounts();
    Optional<Account> findAccountByAccountNumber(String accountNumber);
    Optional<Account> saveAccount(Account account);

}
