package ec.com.efsr.mapper;

import ec.com.efsr.dto.accountDto.AccountInDto;
import ec.com.efsr.dto.accountDto.AccountOutDto;
import ec.com.efsr.models.Account;

public class AccountMapper {
    public static AccountOutDto accountToAccountOutDTO(Account account) {
        if (account == null) {
            return null;
        }
        AccountOutDto accountOutDto = new AccountOutDto();
        accountOutDto.setIdAccount(account.getIdAccount());
        accountOutDto.setAccountNumber(account.getAccountNumber());
        accountOutDto.setTypeAccount(account.getTypeAccount());
        accountOutDto.setOpeningBalance(account.getOpeningBalance());
        accountOutDto.setState(account.getState());
        accountOutDto.setIdCustomer(account.getIdCustomer());
        return accountOutDto;
    }

    public static Account accountInDtoToAccount(AccountInDto accountInDto) {
        if (accountInDto == null) {
            return null;
        }
        Account account = new Account();
        account.setIdAccount(accountInDto.getIdAccount());
        account.setAccountNumber(accountInDto.getAccountNumber());
        account.setTypeAccount(accountInDto.getTypeAccount());
        account.setOpeningBalance(accountInDto.getOpeningBalance());
        account.setState(accountInDto.getState());
        account.setIdCustomer(accountInDto.getIdCustomer());
        return account;
    }
}
