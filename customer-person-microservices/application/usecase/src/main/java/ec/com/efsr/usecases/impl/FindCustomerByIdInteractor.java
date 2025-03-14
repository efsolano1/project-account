package ec.com.efsr.usecases.impl;

import ec.com.efsr.exceptions.CustomerNotFoundException;
import ec.com.efsr.models.Customer;
import ec.com.efsr.repository.CustomerRepositoryPort;
import ec.com.efsr.usecases.IFindCustomerByIdInteractor;

public class FindCustomerByIdInteractor implements IFindCustomerByIdInteractor {
    private final CustomerRepositoryPort customerRepository;

    public FindCustomerByIdInteractor(CustomerRepositoryPort customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerRepository.findCustomerById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Cliente no encontrado"));
    }
}
