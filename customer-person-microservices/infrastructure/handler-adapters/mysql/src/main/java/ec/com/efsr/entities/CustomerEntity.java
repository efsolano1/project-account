package ec.com.efsr.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_customer")
    private String idCustomer;
    private String  password;
    private String state;

    public CustomerEntity(String idPerson, String name, String gender, int age, String identification, String address, String phone) {
        super(idPerson, name, gender, age, identification, address, phone);
    }

    public CustomerEntity(String idPerson, String name, String gender, int age, String identification, String address, String phone, String idCustomer, String password, String state) {
        super(idPerson, name, gender, age, identification, address, phone);
        this.idCustomer = idCustomer;
        this.password = password;
        this.state = state;
    }
}
