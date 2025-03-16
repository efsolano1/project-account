package ec.com.efsr.usecases.account.impl;

import ec.com.efsr.exceptions.AccountsNotFoundException;
import ec.com.efsr.models.Account;
import ec.com.efsr.repository.AccountRepositoryPort;
import ec.com.efsr.usecases.account.IFindAllAccountsInteractor;

import java.util.List;

public class FindAllAccountsInteractor implements IFindAllAccountsInteractor {
    private final AccountRepositoryPort accountRepository;

    public FindAllAccountsInteractor(AccountRepositoryPort accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAllAccounts() {
        List<Account> accounts = accountRepository.findAllAccounts();
        if (accounts.isEmpty()) {
            throw new AccountsNotFoundException("No se encontraron cuentas");
        }
        return accounts;
    }
}
