package ec.com.efsr.usecases.account;

import ec.com.efsr.models.Account;

public interface IFindAccountByIdInteractor {
    Account findAccountById(String idAccount);
}
