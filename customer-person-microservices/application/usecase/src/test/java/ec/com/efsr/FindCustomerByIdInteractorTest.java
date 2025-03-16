package ec.com.efsr;


import ec.com.efsr.exceptions.CustomerNotFoundException;
import ec.com.efsr.models.Customer;
import ec.com.efsr.repository.CustomerRepositoryPort;
import ec.com.efsr.usecases.impl.FindCustomerByIdInteractor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindCustomerByIdInteractorTest {

    @Mock
    private CustomerRepositoryPort customerRepository;

    @InjectMocks
    private FindCustomerByIdInteractor findCustomerByIdInteractor;

    @Test
    void findCustomerById_CustomerExists_ReturnsCustomer() {
        String customerId = "123";
        Customer customer = new Customer();
        customer.setIdCustomer(customerId);
        when(customerRepository.findCustomerById(customerId)).thenReturn(Optional.of(customer));

        Customer result = findCustomerByIdInteractor.findCustomerById(customerId);

        assertNotNull(result);
        assertEquals(customerId, result.getIdCustomer());
        verify(customerRepository, times(1)).findCustomerById(customerId);
    }

    @Test
    void findCustomerById_CustomerDoesNotExist_ThrowsException() {
        String customerId = "123";
        when(customerRepository.findCustomerById(customerId)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> findCustomerByIdInteractor.findCustomerById(customerId));
        verify(customerRepository, times(1)).findCustomerById(customerId);
    }
}