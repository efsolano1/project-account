package ec.com.efsr.usecases.impl;

import ec.com.efsr.exceptions.CustomerUpdateException;
import ec.com.efsr.models.Customer;
import ec.com.efsr.repository.CustomerRepositoryPort;
import ec.com.efsr.usecases.IUpdateCustomerInteractor;

public class UpdateCustomerInteractor implements IUpdateCustomerInteractor {
    private final CustomerRepositoryPort customerRepository;

    public UpdateCustomerInteractor(CustomerRepositoryPort customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        customerRepository.findCustomerById(customer.getIdCustomer());
        return customerRepository.updateCustomer(customer)
                .orElseThrow(()-> new CustomerUpdateException("Error actualizando cliente"));
    }
}
