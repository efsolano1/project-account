package ec.com.efsr.dto.reportDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class AccountReportOutDto {
    private String customer;
    private String accountNumber;
    private String accountType;
    private BigDecimal openingBalance;
    private String state;
    private BigDecimal amountMovement;
    private BigDecimal availableBalance;
    private LocalDateTime dateMovement;

}
