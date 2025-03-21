package ec.com.efsr.mappers;

import ec.com.efsr.entities.CustomerEntity;
import ec.com.efsr.models.Customer;

public class CustomerMapper {
    public static Customer customerEntityToModel(CustomerEntity customerEntity) {
        if(customerEntity == null){
            return null;
        }
        Customer customer = new Customer();
        customer.setIdCustomer(customerEntity.getIdCustomer());
        customer.setPassword(customerEntity.getPassword());
        customer.setState(customerEntity.getState());
        customer.setIdPerson(customerEntity.getIdPerson());
        customer.setName(customerEntity.getName());
        customer.setGender(customerEntity.getGender());
        customer.setAge(customerEntity.getAge());
        customer.setIdentification(customerEntity.getIdentification());
        customer.setAddress(customerEntity.getAddress());
        customer.setPhone(customerEntity.getPhone());
        return customer;
    }

    public static CustomerEntity customerToCustomerEntity(Customer customer) {
        if(customer == null){
            return null;
        }
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setIdCustomer(customer.getIdCustomer());
        customerEntity.setPassword(customer.getPassword());
        customerEntity.setState(customer.getState());
        customerEntity.setName(customer.getName());
        customerEntity.setGender(customer.getGender());
        customerEntity.setAge(customer.getAge());
        customerEntity.setIdentification(customer.getIdentification());
        customerEntity.setAddress(customer.getAddress());
        customerEntity.setPhone(customer.getPhone());
        return customerEntity;
    }
}
