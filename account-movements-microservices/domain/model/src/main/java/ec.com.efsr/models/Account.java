package ec.com.efsr.models;

import java.math.BigDecimal;
import java.util.List;

public class Account {
    private String idAccount;
    private String accountNumber;
    private String typeAccount;
    private BigDecimal openingBalance;
    private String state;
    private String idCustomer;
    private List<Movement> movements;

    public Account() {
    }

    public Account(String idAccount) {
        this.idAccount = idAccount;
    }

    public Account(String idAccount, String accountNumber, String typeAccount, BigDecimal openingBalance, String state, String idCustomer, List<Movement> movements) {
        this.idAccount = idAccount;
        this.accountNumber = accountNumber;
        this.typeAccount = typeAccount;
        this.openingBalance = openingBalance;
        this.state = state;
        this.idCustomer = idCustomer;
        this.movements = movements;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
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

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }
}
