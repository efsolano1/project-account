package ec.com.efsr.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {
    private String idPerson;
    private String name;
    private String gender;
    private int age;
    private String identification;
    private String address;
    private String phone;

}
