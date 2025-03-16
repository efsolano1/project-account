package ec.com.efsr.report;

import java.math.BigDecimal;

public class ReportInfo {
    private String customer;
    private String accountNumber;
    private String accountType;
    private BigDecimal openingBalance;
    private String state;
    private String amountMovement;
    private String availableBalance;

    public ReportInfo() {
    }

    public ReportInfo(String customer, String accountNumber, String accountType, BigDecimal openingBalance, String state, String amountMovement, String availableBalance) {
        this.customer = customer;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.openingBalance = openingBalance;
        this.state = state;
        this.amountMovement = amountMovement;
        this.availableBalance = availableBalance;
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

    public String getAmountMovement() {
        return amountMovement;
    }

    public void setAmountMovement(String amountMovement) {
        this.amountMovement = amountMovement;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }
}
