package ec.com.efsr.repository;

import ec.com.efsr.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerJpaRepository extends JpaRepository<CustomerEntity, String> {
}
