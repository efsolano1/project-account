package ec.com.efsr.usecases.impl;

import ec.com.efsr.models.Customer;
import ec.com.efsr.repository.CustomerRepositoryPort;
import ec.com.efsr.usecases.IDeleteCustomerInteractor;

public class DeleteCustomerInteractor implements IDeleteCustomerInteractor {
    private final CustomerRepositoryPort customerRepository;

    public DeleteCustomerInteractor(CustomerRepositoryPort customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.findCustomerById(id);
        customerRepository.deleteCustomer(id);
    }
}
