package ec.com.efsr.dto.movementDto;

import ec.com.efsr.entities.AccountEntity;
import ec.com.efsr.validator.NotZero;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovementInDto {
    private String idMovement;
    @NotNull(message = "Tipo de movimiento no puede ser nulo")
    @Pattern(regexp ="Deposito|Retiro", message = "Tipo de movimiento debe ser Deposito, Retiro")
    private String  typeMovement;

    @NotNull(message = "El monto no puede ser nulo")
    @NotZero(message = "El monto no puede ser cero")
    private BigDecimal amount;
    //private BigDecimal  balance;
    private String detailMovement;
    private String idAccount;
}
