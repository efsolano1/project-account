package ec.com.efsr.dto.accountDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountOutDto {
    private String  idAccount;
    private String accountNumber;
    private String typeAccount;
    private BigDecimal openingBalance;
    private String state;
    private String idCustomer;
}
