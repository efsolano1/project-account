package ec.com.efsr;


import ec.com.efsr.exceptions.CustomersNotFoundException;
import ec.com.efsr.models.Customer;
import ec.com.efsr.repository.CustomerRepositoryPort;
import ec.com.efsr.usecases.impl.FindAllCustomersInteractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindAllCustomersInteractorTest {

    @Mock
    private CustomerRepositoryPort customerRepository;

    @InjectMocks
    private FindAllCustomersInteractor findAllCustomersInteractor;

    @Test
    void findAllCustomers_CustomersExist_ReturnsCustomerList() {
        Customer customer = new Customer();
        customer.setIdCustomer("123");
        List<Customer> customers = List.of(customer);
        when(customerRepository.findAllCustomers()).thenReturn(customers);

        List<Customer> result = findAllCustomersInteractor.findAllCustomers();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals("123", result.get(0).getIdCustomer());
        verify(customerRepository, times(1)).findAllCustomers();
    }

    @Test
    void findAllCustomers_NoCustomersExist_ThrowsException() {
        when(customerRepository.findAllCustomers()).thenReturn(Collections.emptyList());

        assertThrows(CustomersNotFoundException.class, () -> findAllCustomersInteractor.findAllCustomers());
        verify(customerRepository, times(1)).findAllCustomers();
    }
}