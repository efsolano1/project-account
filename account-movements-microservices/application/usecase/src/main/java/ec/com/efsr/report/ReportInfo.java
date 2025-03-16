package ec.com.efsr.report;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReportInfo {
    private final String customer;
    private final String accountNumber;
    private final String accountType;
    private final BigDecimal openingBalance;
    private final String state;
    private final BigDecimal amountMovement;
    private final BigDecimal availableBalance;
    private final LocalDateTime dateMovement;

    public ReportInfo(String customer, String accountNumber, String accountType, BigDecimal openingBalance, String state, BigDecimal amountMovement, BigDecimal availableBalance, LocalDateTime dateMovement) {
        this.customer = customer;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.openingBalance = openingBalance;
        this.state = state;
        this.amountMovement = amountMovement;
        this.availableBalance = availableBalance;
        this.dateMovement = dateMovement;
    }

    public String getCustomer() {
        return customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public BigDecimal getOpeningBalance() {
        return openingBalance;
    }

    public String getState() {
        return state;
    }

    public BigDecimal getAmountMovement() {
        return amountMovement;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public LocalDateTime getDateMovement() {
        return dateMovement;
    }

}
