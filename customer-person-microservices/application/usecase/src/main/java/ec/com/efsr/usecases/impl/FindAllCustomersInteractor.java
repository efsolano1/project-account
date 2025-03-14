package ec.com.efsr.usecases.impl;

import ec.com.efsr.exceptions.CustomersNotFoundException;
import ec.com.efsr.models.Customer;
import ec.com.efsr.repository.CustomerRepositoryPort;
import ec.com.efsr.usecases.IFindAllCustomersInteractor;
import java.util.List;

public class FindAllCustomersInteractor implements IFindAllCustomersInteractor {
    private final CustomerRepositoryPort customerRepository;

    public FindAllCustomersInteractor(CustomerRepositoryPort customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customers = customerRepository.findAllCustomers();
        if(customers.isEmpty()) {
            throw new CustomersNotFoundException("No existen clientes en la  BD");
        }
       return customers;
    }
}
