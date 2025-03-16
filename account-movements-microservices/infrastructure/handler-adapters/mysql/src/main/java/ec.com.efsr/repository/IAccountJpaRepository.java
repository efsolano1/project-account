package ec.com.efsr.repository;

import ec.com.efsr.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountJpaRepository extends JpaRepository<AccountEntity, String> {
    AccountEntity findByAccountNumber(String accountNumber);
    AccountEntity findByIdCustomer(String idCustomer);

}
