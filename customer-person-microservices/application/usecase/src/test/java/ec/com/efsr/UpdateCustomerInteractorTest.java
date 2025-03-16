package ec.com.efsr;


import ec.com.efsr.exceptions.CustomerUpdateException;
import ec.com.efsr.models.Customer;
import ec.com.efsr.repository.CustomerRepositoryPort;
import ec.com.efsr.usecases.impl.UpdateCustomerInteractor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateCustomerInteractorTest {

    @Mock
    private CustomerRepositoryPort customerRepository;

    @InjectMocks
    private UpdateCustomerInteractor updateCustomerInteractor;


    @Test
    void updateCustomer_CustomerUpdatedSuccessfully_ReturnsCustomer() {
        Customer customer = new Customer();
        customer.setIdCustomer("123");
        when(customerRepository.findCustomerById(customer.getIdCustomer())).thenReturn(Optional.of(customer));
        when(customerRepository.updateCustomer(customer)).thenReturn(Optional.of(customer));

        Customer result = updateCustomerInteractor.updateCustomer(customer);

        assertNotNull(result);
        assertEquals("123", result.getIdCustomer());
        verify(customerRepository, times(1)).findCustomerById(customer.getIdCustomer());
        verify(customerRepository, times(1)).updateCustomer(customer);
    }

    @Test
    void updateCustomer_CustomerUpdateFails_ThrowsException() {
        Customer customer = new Customer();
        customer.setIdCustomer("123");
        when(customerRepository.findCustomerById(customer.getIdCustomer())).thenReturn(Optional.of(customer));
        when(customerRepository.updateCustomer(customer)).thenReturn(Optional.empty());

        assertThrows(CustomerUpdateException.class, () -> updateCustomerInteractor.updateCustomer(customer));
        verify(customerRepository, times(1)).findCustomerById(customer.getIdCustomer());
        verify(customerRepository, times(1)).updateCustomer(customer);
    }
}