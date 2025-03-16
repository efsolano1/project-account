package ec.com.efsr.usecases.account.impl;

import ec.com.efsr.exceptions.CustomerNotFoundException;
import ec.com.efsr.models.Account;
import ec.com.efsr.models.Movement;
import ec.com.efsr.report.ReportInfo;
import ec.com.efsr.repository.AccountRepositoryPort;
import ec.com.efsr.repository.ISendAndReceiveInformation;
import ec.com.efsr.repository.MovementRepositoryPort;
import ec.com.efsr.usecases.account.IGetAccountMovementReportInteractor;
import ec.com.efsr.usecases.account.general.DateRange;
import ec.com.efsr.usecases.account.general.HandlerCustomerInfoProvider;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GetAccountMovementReportInteractor implements IGetAccountMovementReportInteractor {
    private final AccountRepositoryPort accountRepository;
    private final MovementRepositoryPort movementRepository;
    private final HandlerCustomerInfoProvider handlerCustomerInfoProvider;
   // private final ISendAndReceiveInformation sendAndReceiveInformation;

    public GetAccountMovementReportInteractor(AccountRepositoryPort accountRepository, MovementRepositoryPort movementRepository, HandlerCustomerInfoProvider handlerCustomerInfoProvider) {
        this.accountRepository = accountRepository;
        this.movementRepository = movementRepository;
        this.handlerCustomerInfoProvider = handlerCustomerInfoProvider;

    }

    @Override
    public List<ReportInfo> getAccountMovementReport(String dateRangeString, String idCustomer) {
        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String[] dates = dateRangeString.split("-");

        if (dates.length != 2) {
            throw new RuntimeException("Invalid date range format. Use yyyy/MM/dd-yyyy/MM/dd");
        }

        LocalDate startDate = LocalDate.parse(dates[0], formatter);
        LocalDate endDate = LocalDate.parse(dates[1], formatter);

        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDatetime = endDate.atTime(23, 59, 59);*/

        DateRange dateRange = new DateRange(dateRangeString);

        /*Object response;
        String responseData;
        String nameCustomer;

        response = sendAndReceiveInformation.sendAndReceiveInformation(idCustomer);
        responseData = (String) response;

        if(response == null || response == "" || responseData == null || responseData == ""){
            throw new CustomerNotFoundException("No se pudo obtener informacion del cliente");
        }
        nameCustomer = responseData.split(",")[1];*/
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
