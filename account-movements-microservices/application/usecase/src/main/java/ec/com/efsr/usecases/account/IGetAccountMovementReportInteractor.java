package ec.com.efsr.usecases.account;

import ec.com.efsr.report.ReportInfo;

import java.util.List;

public interface IGetAccountMovementReportInteractor {
    List<ReportInfo> getAccountMovementReport(String dateRange, String idCustomer);
}
