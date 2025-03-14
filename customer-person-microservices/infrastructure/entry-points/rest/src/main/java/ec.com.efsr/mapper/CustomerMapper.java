package ec.com.efsr.mapper;

import ec.com.efsr.dto.CustomerInDto;
import ec.com.efsr.dto.CustomerOutDto;
import ec.com.efsr.models.Customer;

public class CustomerMapper {
    public static CustomerOutDto customerToCustomerOutDTO(Customer customer) {
        return new CustomerOutDto(
                customer.getIdCustomer(),
                customer.getPassword(),
                customer.getState(),
                customer.getName(),
                customer.getGender(),
                customer.getAge(),
                customer.getIdentification(),
                customer.getAddress(),
                customer.getPhone());
    }

    public static Customer customerInDtoToCustomer(CustomerInDto customerInDto) {
        Customer customer = new Customer();
        customer.setIdCustomer(customerInDto.getIdCustomer());
        customer.setPassword(customerInDto.getPassword());
        customer.setState(customerInDto.getState());
        customer.setName(customerInDto.getName());
        customer.setGender(customerInDto.getGender());
        customer.setAge(customerInDto.getAge());
        customer.setIdentification(customerInDto.getIdentification());
        customer.setAddress(customerInDto.getAddress());
        customer.setPhone(customerInDto.getPhone());
        return customer;
    }

}
