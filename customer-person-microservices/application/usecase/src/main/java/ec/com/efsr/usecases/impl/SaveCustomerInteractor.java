package ec.com.efsr.usecases.impl;

import ec.com.efsr.exceptions.CustomerSaveException;
import ec.com.efsr.models.Customer;
import ec.com.efsr.repository.CustomerRepositoryPort;
import ec.com.efsr.usecases.ISaveCustomerInteractor;

public class SaveCustomerInteractor implements ISaveCustomerInteractor {
    private final CustomerRepositoryPort customerRepository;

    public SaveCustomerInteractor(CustomerRepositoryPort customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Customer customerSaved = customerRepository.saveCustomer(customer);
        if (customerSaved == null) {
            throw new CustomerSaveException("Error creando el cliente");
        }
        return customerSaved;
    }
}
