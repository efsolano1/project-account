package ec.com.efsr.usecases.account.impl;

import ec.com.efsr.exceptions.AccountNumberNotFoundException;
import ec.com.efsr.models.Account;
import ec.com.efsr.repository.AccountRepositoryPort;
import ec.com.efsr.usecases.account.IFindAccountByAccountNumberInteractor;

public class FindAccountByAccountNumberInteractor implements IFindAccountByAccountNumberInteractor {
    private final AccountRepositoryPort accountRepository;

    public FindAccountByAccountNumberInteractor(AccountRepositoryPort accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findAccountByAccountNumber(String accountNumber) {
        Account account = accountRepository.findAccountByAccountNumber(accountNumber);
        if (account == null) {
            throw new AccountNumberNotFoundException("Cuenta con numero " + accountNumber + " no encontrada");
        }
        return account;
    }
}
