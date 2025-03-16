package ec.com.efsr.dto.reportDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Setter
@Getter
public class AccountReportOutDto {
    private String customer;
    private String accountNumber;
    private String accountType;
    private BigDecimal openingBalance;
    private String state;
    private BigDecimal amountMovement;
    private BigDecimal availableBalance;
    private LocalDateTime dateMovement;

    public AccountReportOutDto(String customer, String accountNumber, String accountType, BigDecimal openingBalance, String state, BigDecimal amountMovement, BigDecimal availableBalance, LocalDateTime dateMovement) {
        this.customer = customer;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.openingBalance = openingBalance;
        this.state = state;
        this.amountMovement = amountMovement;
        this.availableBalance = availableBalance;
        this.dateMovement = dateMovement;
    }

}
