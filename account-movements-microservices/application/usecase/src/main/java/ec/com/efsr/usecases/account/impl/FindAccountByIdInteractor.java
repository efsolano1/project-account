package ec.com.efsr.usecases.account.impl;

import ec.com.efsr.exceptions.AccountNotFoundException;
import ec.com.efsr.models.Account;
import ec.com.efsr.repository.AccountRepositoryPort;
import ec.com.efsr.usecases.account.IFindAccountByIdInteractor;

public class FindAccountByIdInteractor implements IFindAccountByIdInteractor {
    private final AccountRepositoryPort accountRepository;

    public FindAccountByIdInteractor(AccountRepositoryPort accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findAccountById(String idAccount) {
        return accountRepository.findAccountById(idAccount)
                .orElseThrow(() -> new AccountNotFoundException("Cuenta no encontrada"));
    }
}
