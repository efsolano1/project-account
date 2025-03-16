package ec.com.efsr.dto.accountDto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountInDto {
    private String idAccount;
    @NotBlank(message = "Numero de cuenta no puede ser nulo o vacío")
    @Size(min = 10, max = 12, message = "Numero de cuenta debe tener entre 10 y 12 dígitos")
    @Pattern(regexp = "\\d{10,12}", message = "Numero de cuenta debe contener solo dígitos")
    private String accountNumber;

    @NotBlank(message = "Tipo de cuenta no puede ser nulo o vacío")
    @Pattern(regexp = "Corriente|Ahorros", message = "Tipo de cuenta debe ser 'Corriente' o 'Ahorros'")
    private String typeAccount;

    @DecimalMin(value = "0.0", inclusive = true, message = "Saldo de apertura debe ser mayor o igual a cero")
    private BigDecimal openingBalance;

    @NotBlank(message = "Estado no puede ser nulo o vacío")
    @Pattern(regexp = "true|false", message = "Estado debe ser 'true' o 'false'")
    private String state;

    private String idCustomer;
}
