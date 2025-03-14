package ec.com.efsr.mediator;

import ec.com.efsr.dto.accountDto.AccountInDto;
import ec.com.efsr.dto.accountDto.AccountOutDto;
import ec.com.efsr.mapper.AccountMapper;
import ec.com.efsr.usecases.account.IFindAccountByIdInteractor;
import ec.com.efsr.usecases.account.IFindAllAccountsInteractor;
import ec.com.efsr.usecases.account.ISaveAccountInteractor;
import ec.com.efsr.usecases.account.IUpdateAccountInteractor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMediator {
    private final IFindAccountByIdInteractor findAccountByIdInteractor;
    private final IFindAllAccountsInteractor findAllAccountsInteractor;
    private final ISaveAccountInteractor saveAccountInteractor;
    private final IUpdateAccountInteractor updateAccountInteractor;;

    public AccountMediator(IFindAccountByIdInteractor findAccountByIdInteractor, IFindAllAccountsInteractor findAllAccountsInteractor, ISaveAccountInteractor saveAccountInteractor, IUpdateAccountInteractor updateAccountInteractor) {
        this.findAccountByIdInteractor = findAccountByIdInteractor;
        this.findAllAccountsInteractor = findAllAccountsInteractor;
        this.saveAccountInteractor = saveAccountInteractor;
        this.updateAccountInteractor = updateAccountInteractor;
    }

    public AccountOutDto findAccountById(String id) {
        return AccountMapper.accountToAccountOutDTO(findAccountByIdInteractor.findAccountById(id));
    }

    public List<AccountOutDto> findAllAccounts() {
        return findAllAccountsInteractor.findAllAccounts()
                .stream()
                .map(AccountMapper::accountToAccountOutDTO)
                .collect(Collectors.toList());
    }

    public AccountOutDto saveAccount(AccountInDto accountInDto) {
        return AccountMapper.accountToAccountOutDTO(saveAccountInteractor.saveAccount(AccountMapper.accountInDtoToAccount(accountInDto)));
    }

    public AccountOutDto updateAccount(AccountInDto accountInDto) {
        return AccountMapper.accountToAccountOutDTO(updateAccountInteractor.updateAccount(AccountMapper.accountInDtoToAccount(accountInDto), true));
    }

}
