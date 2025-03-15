package ec.com.efsr.dto.movementDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovementOutDto {
    private String idMovement;
    private LocalDateTime date;
    private String  typeMovement;
    private BigDecimal amount;
    private BigDecimal  balance;
    private String detailMovement;
    private String idAccount;
}
