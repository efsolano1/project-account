package ec.com.efsr.entities;

import ec.com.efsr.models.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "movement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_movement")
    private String idMovement;
    private LocalDateTime date;
    private String  typeMovement;
    private BigDecimal amount;
    private BigDecimal  balance;
    private String detailMovement;
    @ManyToOne
    @JoinColumn(name="id_account", referencedColumnName = "id_account")
    private AccountEntity account;

    MovementEntity(String idMovement){
        this.idMovement = idMovement;
    }

}
