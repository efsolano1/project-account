package ec.com.efsr.repository;

import ec.com.efsr.models.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepositoryPort {
    Optional<Account> findAccountById(String id);
    List<Account> findAllAccounts();
    Account findAccountByAccountNumber(String accountNumber);
    Optional<Account> saveAccount(Account account);
    Optional<Account> updateAccount(Account account);
    Account findByIdCustomer(String idCustomer);

}
