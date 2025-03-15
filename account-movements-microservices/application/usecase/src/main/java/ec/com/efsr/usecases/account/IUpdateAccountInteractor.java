package ec.com.efsr.usecases.account;

import ec.com.efsr.models.Account;

public interface IUpdateAccountInteractor {
    Account updateAccount(Account account, Boolean flag);
}
