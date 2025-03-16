package ec.com.efsr.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerInDto {
    private String idCustomer;
    @NotNull(message = "Contraseña requerida")
    @Size(min = 8, max = 30, message = "La contraseña debe tener entre 8 y 30 caracteres")
    private String password;

    @NotNull(message = "Estado requerido")
    @Pattern(regexp = "true|false", message = "Estado debe ser true o false")
    private String state;

    @NotNull(message = "Nombre requerido")
    @Size(max = 20, message = "El nombre debe tener máximo 20 caracteres")
    private String name;

    @NotNull(message = "Género requerido")
    @Pattern(regexp = "Male|Female", message = "Género debe ser 'Male' o 'Female'")
    private String gender;

    @NotNull(message = "Edad requerida")
    @Min(value = 18, message = "Edad debe ser mayor a 18 años")
    @Max(value = 80, message = "Edad debe ser menor a 80 años")
    private int age;

    @NotBlank(message = "Identificación requerida")
    @Size(min = 8, max = 16, message = "Identificación debe tener entre 8 y 16 caracteres")
    private String identification;

    @NotBlank(message = "Direccion no puede ser vacía")
    private String address;

    @NotBlank(message = "Teléfono requerido")
    @Pattern(regexp = "\\d{10,15}", message = "Teléfono debe tener entre 10 y 15 dígitos")
    private String phone;

    public CustomerInDto(String password, String state, String name, String gender, int age, String identification, String address, String phone) {
        this.password = password;
        this.state = state;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.identification = identification;
        this.address = address;
        this.phone = phone;
    }
}
