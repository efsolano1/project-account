package ec.com.efsr.usecases.account.impl;

import ec.com.efsr.exceptions.AccountNotUpdateException;
import ec.com.efsr.exceptions.AccountNumberExistException;
import ec.com.efsr.exceptions.CustomerNotFoundException;
import ec.com.efsr.models.Account;
import ec.com.efsr.repository.AccountRepositoryPort;
import ec.com.efsr.repository.ISendAndReceiveInformation;
import ec.com.efsr.usecases.account.IUpdateAccountInteractor;

public class UpdateAccountInteractor implements IUpdateAccountInteractor {
    private final AccountRepositoryPort accountRepository;
    private final ISendAndReceiveInformation sendAndReceiveInformation;

    public UpdateAccountInteractor(AccountRepositoryPort accountRepository, ISendAndReceiveInformation sendAndReceiveInformation) {
        this.accountRepository = accountRepository;
        this.sendAndReceiveInformation = sendAndReceiveInformation;
    }

    @Override
    public Account updateAccount(Account account, Boolean flag) {
        if (!flag) {
            return accountRepository.updateAccount(account).orElse(null);
        }

        if (accountRepository.findAccountByAccountNumber(account.getAccountNumber()) != null) {
            throw new AccountNumberExistException("El numero de cuenta" + account.getAccountNumber() + " ya existe");
        }
        accountRepository.findAccountById(account.getIdAccount()).orElse(null);
        Object response;
        String responseData;
        response = sendAndReceiveInformation.sendAndReceiveInformation(account.getIdCustomer());
        responseData = (String) response;
        if (response == null || response == "" || responseData.isEmpty()) {
            throw new CustomerNotFoundException("Error actualizando cuenta, cliente no encontrado");
        }
        account.setIdCustomer(responseData.split(",")[0]);
        Account accountUpdated = accountRepository.updateAccount(account).orElse(null);
        if (accountUpdated == null) {
            throw new AccountNotUpdateException("Error actualizando cuenta");
        }
        return accountUpdated;
    }
}
