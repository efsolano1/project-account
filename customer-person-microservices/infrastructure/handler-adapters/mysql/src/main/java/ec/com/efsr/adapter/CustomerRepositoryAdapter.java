package ec.com.efsr.adapter;

import ec.com.efsr.entities.CustomerEntity;
import ec.com.efsr.exceptions.*;

import ec.com.efsr.mappers.CustomerMapper;
import ec.com.efsr.models.Customer;
import ec.com.efsr.repository.CustomerRepositoryPort;
import ec.com.efsr.repository.ICustomerJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CustomerRepositoryAdapter implements CustomerRepositoryPort {
    private final ICustomerJpaRepository customerRepository;

    public CustomerRepositoryAdapter(ICustomerJpaRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> findCustomerById(String id) {
        CustomerEntity customerEntity = customerRepository.findById(id).orElse(null);
        if (customerEntity == null) {
            throw new CustomerNotFoundException("Cliente con  identificacion " + id + " no encontrado");
        }
        return Optional.of(CustomerMapper.customerEntityToModel(customerEntity));
    }

    @Override
    public List<Customer> findAllCustomers() {
        List<CustomerEntity> customers = customerRepository.findAll();

        if (customers.isEmpty()) {
            throw new CustomersNotFoundException("No hay clientes en la BD");
        }
        return customers.stream()
                .map(CustomerMapper::customerEntityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        var customerEntity = customerRepository.save(CustomerMapper.customerToCustomerEntity(customer));
        if (customerEntity == null) {
            throw new CustomerSaveException("Error al guardar el cliente.");
        }
        return CustomerMapper.customerEntityToModel(customerEntity);
    }

    @Override
    public Optional<Customer> updateCustomer(Customer customer) {
        var customerEntity = customerRepository.save(CustomerMapper.customerToCustomerEntity(customer));
        if (customerEntity == null) {
            throw new CustomerUpdateException("Error al actualizar el cliente");
        }
        return Optional.of(CustomerMapper.customerEntityToModel(customerEntity));
    }

    @Override
    public Customer findCustomerByIdentification(String id) {
       var customerEntity = customerRepository.findByIdentification(id);
       return CustomerMapper.customerEntityToModel(customerEntity);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}
