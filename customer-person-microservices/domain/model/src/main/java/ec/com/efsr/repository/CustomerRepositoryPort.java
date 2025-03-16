package ec.com.efsr.repository;

import ec.com.efsr.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepositoryPort {
    Optional<Customer> findCustomerById(String id);

    List<Customer> findAllCustomers();

    Customer saveCustomer(Customer customer);

    Optional<Customer> updateCustomer(Customer customer);

    void deleteCustomer(String id);
}
