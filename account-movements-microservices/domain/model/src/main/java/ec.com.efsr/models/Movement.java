package ec.com.efsr.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Movement {
    private String idMovement;
    private LocalDateTime date;
    private String  typeMovement;
    private BigDecimal amount;
    private BigDecimal  balance;
    private String detailMovement;
    private String idAccount;
     private Account account;

    public Movement() {
    }

    public Movement(String idMovement, LocalDateTime date, String typeMovement, BigDecimal amount, BigDecimal balance, String detailMovement, ec.com.efsr.models.Account account) {
        this.idMovement = idMovement;
        this.date = date;
        this.typeMovement = typeMovement;
        this.amount = amount;
        this.balance = balance;
        this.detailMovement = detailMovement;
        this.account = account;
    }

    public String getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(String idMovement) {
        this.idMovement = idMovement;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTypeMovement() {
        return typeMovement;
    }

    public void setTypeMovement(String typeMovement) {
        this.typeMovement = typeMovement;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getDetailMovement() {
        return detailMovement;
    }

    public void setDetailMovement(String detailMovement) {
        this.detailMovement = detailMovement;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
