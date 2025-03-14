package ec.com.efsr.usecases;

import ec.com.efsr.models.Customer;

import java.util.List;

public interface IFindAllCustomersInteractor {
    List<Customer> findAllCustomers();
}
