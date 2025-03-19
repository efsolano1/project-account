package ec.com.efsr.repository;

import ec.com.efsr.entities.CustomerEntity;
import ec.com.efsr.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerJpaRepository extends JpaRepository<CustomerEntity, String> {
    CustomerEntity findByIdentification(String id);
}
