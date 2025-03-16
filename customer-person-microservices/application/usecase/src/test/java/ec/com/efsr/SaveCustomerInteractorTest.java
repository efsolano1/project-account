package ec.com.efsr;


import ec.com.efsr.exceptions.CustomerSaveException;
import ec.com.efsr.models.Customer;
import ec.com.efsr.repository.CustomerRepositoryPort;
import ec.com.efsr.usecases.impl.SaveCustomerInteractor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaveCustomerInteractorTest {

    @Mock
    private CustomerRepositoryPort customerRepository;

    @InjectMocks
    private SaveCustomerInteractor saveCustomerInteractor;

    @Test
    void saveCustomer_CustomerSavedSuccessfully_ReturnsCustomer() {
        Customer customer = new Customer();
        customer.setIdCustomer("123");
        when(customerRepository.saveCustomer(customer)).thenReturn(customer);

        Customer result = saveCustomerInteractor.saveCustomer(customer);

        assertNotNull(result);
        assertEquals("123", result.getIdCustomer());
        verify(customerRepository, times(1)).saveCustomer(customer);
    }

    @Test
    void saveCustomer_CustomerSaveFails_ThrowsException() {
        Customer customer = new Customer();
        when(customerRepository.saveCustomer(customer)).thenReturn(null);

        assertThrows(CustomerSaveException.class, () -> saveCustomerInteractor.saveCustomer(customer));
        verify(customerRepository, times(1)).saveCustomer(customer);
    }
}