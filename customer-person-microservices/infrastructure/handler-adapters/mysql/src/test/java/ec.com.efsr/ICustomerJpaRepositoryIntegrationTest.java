package ec.com.efsr;

import ec.com.efsr.entities.CustomerEntity;
import ec.com.efsr.repository.ICustomerJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = TestConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ICustomerJpaRepositoryIntegrationTest {

    @Autowired
    private ICustomerJpaRepository customerJpaRepository;

    @BeforeEach
    void setUp() {
        customerJpaRepository.deleteAll();

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setIdCustomer("1235678");
        customerEntity.setName("Carlos Delfin");
        customerEntity.setState("active");
        customerJpaRepository.save(customerEntity);
    }

    @Test
    @DisplayName("shouldReturnCustomer_whenCustomerSearchById_thenCustomerExistInDatabase")
    void findById_CustomerExists_ReturnsCustomer() {
        // Act
        CustomerEntity result = customerJpaRepository.findById("123").orElse(null);

        // Assert
        assertNotNull(result);
        assertEquals("123", result.getIdCustomer());
        assertEquals("John Doe", result.getName());
    }

    @Test
    @DisplayName("shouldReturnEmpty_whenCustomerSearchById_thenCustomerDoesNotExistInDatabase")
    void findById_CustomerDoesNotExist_ReturnsEmpty() {
        // Act
        CustomerEntity result = customerJpaRepository.findById("999").orElse(null);

        // Assert
        assertEquals(null, result);
    }
}
