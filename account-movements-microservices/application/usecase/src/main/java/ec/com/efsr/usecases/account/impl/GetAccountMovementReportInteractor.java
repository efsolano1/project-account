package ec.com.efsr.usecases.account.impl;

import ec.com.efsr.exceptions.CustomerNotFoundException;
import ec.com.efsr.models.Account;
import ec.com.efsr.report.ReportInfo;
import ec.com.efsr.repository.AccountRepositoryPort;
import ec.com.efsr.repository.ISendAndReceiveInformation;
import ec.com.efsr.repository.MovementRepositoryPort;
import ec.com.efsr.usecases.account.IGetAccountMovementReportInteractor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GetAccountMovementReportInteractor implements IGetAccountMovementReportInteractor {
    private final AccountRepositoryPort accountRepository;
    private final MovementRepositoryPort movementRepository;
    private final ISendAndReceiveInformation sendAndReceiveInformation;

    public GetAccountMovementReportInteractor(AccountRepositoryPort accountRepository, MovementRepositoryPort movementRepository, ISendAndReceiveInformation sendAndReceiveInformation) {
        this.accountRepository = accountRepository;
        this.movementRepository = movementRepository;
        this.sendAndReceiveInformation = sendAndReceiveInformation;
    }

    @Override
    public List<ReportInfo> getAccountMovementReport(String dateRange, String idCustomer) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String[] dates = dateRange.split("-");

        if (dates.length != 2) {
            throw new RuntimeException("Invalid date range format. Use yyyy/MM/dd-yyyy/MM/dd");
        }

        LocalDate startDate = LocalDate.parse(dates[0], formatter);
        LocalDate endDate = LocalDate.parse(dates[1], formatter);

        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDatetime = endDate.atTime(23, 59, 59);
        Object response;
        String responseData;
        String nameCustomer;

        response = sendAndReceiveInformation.sendAndReceiveInformation(idCustomer);
        responseData = (String) response;

        if(response == null || response == "" || responseData == null || responseData == ""){
            throw new CustomerNotFoundException("No se pudo obtener informacion del cliente");
        }
        nameCustomer = responseData.split(",")[1];
        Account account = accountRepository.findByIdCustomer(idCustomer);


        return List.of();
    }
}
