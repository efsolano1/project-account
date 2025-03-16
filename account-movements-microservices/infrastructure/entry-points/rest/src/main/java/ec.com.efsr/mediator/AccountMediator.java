package ec.com.efsr.mediator;

import ec.com.efsr.dto.accountDto.AccountInDto;
import ec.com.efsr.dto.accountDto.AccountOutDto;
import ec.com.efsr.dto.reportDto.AccountReportOutDto;
import ec.com.efsr.mapper.AccountMapper;
import ec.com.efsr.usecases.account.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMediator {
    private final IFindAccountByIdInteractor findAccountByIdInteractor;
    private final IFindAllAccountsInteractor findAllAccountsInteractor;
    private final ISaveAccountInteractor saveAccountInteractor;
    private final IUpdateAccountInteractor updateAccountInteractor;;
    private final IGetAccountMovementReportInteractor getAccountMovementReportInteractor;

    public AccountMediator(IFindAccountByIdInteractor findAccountByIdInteractor, IFindAllAccountsInteractor findAllAccountsInteractor, ISaveAccountInteractor saveAccountInteractor, IUpdateAccountInteractor updateAccountInteractor, IGetAccountMovementReportInteractor getAccountMovementReportInteractor) {
        this.findAccountByIdInteractor = findAccountByIdInteractor;
        this.findAllAccountsInteractor = findAllAccountsInteractor;
        this.saveAccountInteractor = saveAccountInteractor;
        this.updateAccountInteractor = updateAccountInteractor;
        this.getAccountMovementReportInteractor = getAccountMovementReportInteractor;
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
    public List<AccountReportOutDto> findAccountReport(String dateRange, String customerId){
        return getAccountMovementReportInteractor.getAccountMovementReport(dateRange,customerId)
                .stream()
                .map(info->
                        new AccountReportOutDto(
                                info.getCustomer(),
                                info.getAccountNumber(),
                                info.getAccountType(),
                                info.getOpeningBalance(),
                                info.getState(),
                                info.getAmountMovement(),
                                info.getAvailableBalance(),
                                info.getDateMovement()
                        ))
                .collect(Collectors.toList());
    }

}
