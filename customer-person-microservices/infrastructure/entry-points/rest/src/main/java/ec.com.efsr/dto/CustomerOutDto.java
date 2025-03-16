package ec.com.efsr.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOutDto {
    private String idCustomer;
    private String password;
    private String state;
    private String name;
    private String gender;
    private int age;
    private String identification;
    private String address;
    private String phone;
}
