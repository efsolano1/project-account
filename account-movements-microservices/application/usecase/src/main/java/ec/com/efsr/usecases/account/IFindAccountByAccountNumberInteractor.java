package ec.com.efsr.usecases.account;

import ec.com.efsr.models.Account;

public interface IFindAccountByAccountNumberInteractor {
    Account findAccountByAccountNumber(String accountNumber);
}
