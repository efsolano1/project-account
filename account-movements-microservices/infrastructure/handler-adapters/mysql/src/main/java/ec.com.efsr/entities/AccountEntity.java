package ec.com.efsr.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_account")
    private String idAccount;
    @Column(nullable = false, unique = true)
    private String accountNumber;
    private String typeAccount;
    private BigDecimal openingBalance;
    private String state;
    private String idCustomer;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<MovementEntity> movements;

    public AccountEntity(String idAccount) {
        this.idAccount = idAccount;
    }
}
