package ec.com.efsr.report;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReportInfo {
    private String customer;
    private String accountNumber;
    private String accountType;
    private BigDecimal openingBalance;
    private String state;
    private BigDecimal amountMovement;
    private BigDecimal availableBalance;
    private LocalDateTime dateMovement;

    public ReportInfo() {
    }

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

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(BigDecimal openingBalance) {
        this.openingBalance = openingBalance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getAmountMovement() {
        return amountMovement;
    }

    public void setAmountMovement(BigDecimal amountMovement) {
        this.amountMovement = amountMovement;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public LocalDateTime getDateMovement() {
        return dateMovement;
    }

    public void setDateMovement(LocalDateTime dateMovement) {
        this.dateMovement = dateMovement;
    }
}
