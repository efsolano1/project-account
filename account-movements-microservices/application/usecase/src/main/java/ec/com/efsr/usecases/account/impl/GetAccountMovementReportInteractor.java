package ec.com.efsr.usecases.account.impl;

import ec.com.efsr.models.Account;
import ec.com.efsr.models.Movement;
import ec.com.efsr.report.ReportInfo;
import ec.com.efsr.repository.AccountRepositoryPort;

import ec.com.efsr.repository.MovementRepositoryPort;
import ec.com.efsr.usecases.account.IGetAccountMovementReportInteractor;
import ec.com.efsr.usecases.account.general.DateRange;
import ec.com.efsr.usecases.account.general.HandlerCustomerInfoProvider;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GetAccountMovementReportInteractor implements IGetAccountMovementReportInteractor {
    private final AccountRepositoryPort accountRepository;
    private final MovementRepositoryPort movementRepository;
    private final HandlerCustomerInfoProvider handlerCustomerInfoProvider;

    public GetAccountMovementReportInteractor(AccountRepositoryPort accountRepository, MovementRepositoryPort movementRepository, HandlerCustomerInfoProvider handlerCustomerInfoProvider) {
        this.accountRepository = accountRepository;
        this.movementRepository = movementRepository;
        this.handlerCustomerInfoProvider = handlerCustomerInfoProvider;
    }

    @Override
    public List<ReportInfo> getAccountMovementReport(String dateRangeString, String idCustomer) {

        DateRange dateRange = new DateRange(dateRangeString);
        String nameCustomer = handlerCustomerInfoProvider.getCustomerInfo(idCustomer).split(",")[1];
        Account account = accountRepository.findByIdCustomer(idCustomer);

        List<Movement> movements = movementRepository.findMovementsByIdAccount(account.getIdAccount());

        Predicate<Movement> isWithinRange = m ->
                m.getDate().isAfter(dateRange.getInitialDate()) && m.getDate().isBefore(dateRange.getEndDate());

        List<Movement> filteredMovements = movements.stream()
                .filter(isWithinRange)
                .collect(Collectors.toList());

        return filteredMovements.stream()
                .map(movement -> new ReportInfo(
                        nameCustomer,
                        account.getAccountNumber(),
                        account.getTypeAccount(),
                        movement.getBalance().subtract(movement.getAmount()),
                        account.getState(),
                        movement.getAmount(),
                        movement.getBalance(),
                        movement.getDate()
                ))
                .collect(Collectors.toList());
    }
}
