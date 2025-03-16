package ec.com.efsr.usecases.account.impl;

import ec.com.efsr.exceptions.AccountNotSaveException;
import ec.com.efsr.exceptions.AccountNumberExistException;
import ec.com.efsr.exceptions.CustomerNotFoundException;
import ec.com.efsr.models.Account;
import ec.com.efsr.repository.AccountRepositoryPort;
import ec.com.efsr.repository.ISendAndReceiveInformation;
import ec.com.efsr.usecases.account.ISaveAccountInteractor;

public class SaveAccountInteractor implements ISaveAccountInteractor {
    private final AccountRepositoryPort accountRepository;
    private final ISendAndReceiveInformation sendAndReceiveInformation;

    public SaveAccountInteractor(AccountRepositoryPort accountRepository, ISendAndReceiveInformation sendAndReceiveInformation) {
        this.accountRepository = accountRepository;
        this.sendAndReceiveInformation = sendAndReceiveInformation;
    }

    @Override
    public Account saveAccount(Account account) {
        if (accountRepository.findAccountByAccountNumber(account.getAccountNumber()) != null) {
            throw new AccountNumberExistException("El numero de cuenta" + account.getAccountNumber() + " ya existe");
        }
        Object response;
        String responseData;

        response = sendAndReceiveInformation.sendAndReceiveInformation(account.getIdCustomer());
        responseData = (String) response;

        if (response == null || response == "" || responseData == null || responseData == "") {
            throw new CustomerNotFoundException("No se pudo obtener el id del cliente");
        }
        account.setIdCustomer(responseData.split(",")[0]);

        Account accountSaved = accountRepository.saveAccount(account).orElse(null);
        if (accountSaved == null) {
            throw new AccountNotSaveException("No se pudo guardar la cuenta");
        }
        return accountSaved;
    }
}
