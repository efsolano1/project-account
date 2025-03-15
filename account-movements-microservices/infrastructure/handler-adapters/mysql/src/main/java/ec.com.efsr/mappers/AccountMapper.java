package ec.com.efsr.mappers;

import ec.com.efsr.entities.AccountEntity;
import ec.com.efsr.models.Account;

public class AccountMapper {
    public static Account accountEntityToModel(AccountEntity accountEntity) {
        if(accountEntity == null){
            return null;
        }
        Account account = new Account();
         account.setIdAccount(accountEntity.getIdAccount());
         account.setAccountNumber(accountEntity.getAccountNumber());
         account.setTypeAccount(accountEntity.getTypeAccount());
         account.setOpeningBalance(accountEntity.getOpeningBalance());
         account.setState(accountEntity.getState());
         account.setIdCustomer(accountEntity.getIdCustomer());
         return account;
    }

    public static AccountEntity accountToAccountEntity(Account account){
        if(account == null){
            return null;
        }
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setIdAccount(account.getIdAccount());
        accountEntity.setAccountNumber(account.getAccountNumber());
        accountEntity.setTypeAccount(account.getTypeAccount());
        accountEntity.setOpeningBalance(account.getOpeningBalance());
        accountEntity.setState(account.getState());
        accountEntity.setIdCustomer(account.getIdCustomer());
        return accountEntity;
    }
}
