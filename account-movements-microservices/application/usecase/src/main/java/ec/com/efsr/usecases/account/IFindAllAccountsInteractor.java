package ec.com.efsr.usecases.account;

import ec.com.efsr.models.Account;

import java.util.List;

public interface IFindAllAccountsInteractor {
    List<Account> findAllAccounts();
}
