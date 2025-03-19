package ec.com.efsr;

import ec.com.efsr.entities.CustomerEntity;
import ec.com.efsr.repository.ICustomerJpaRepository;
import jakarta.transaction.Transactional;
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
    @Transactional
    void setUp() {
        customerJpaRepository.deleteAll();

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setIdentification("1103452367");
        customerEntity.setPassword("password");
        customerEntity.setState("true");
        customerEntity.setName("John Doe");
        customerEntity.setAddress("Loja");
        customerEntity.setAge(50);
        customerEntity.setPhone("0993425678");
        customerJpaRepository.save(customerEntity);
    }

    @Test
    @DisplayName("shouldReturnCustomer_whenCustomerSearchById_thenCustomerExistInDatabase")
    void findById_CustomerExists_ReturnsCustomer() {

        CustomerEntity result = customerJpaRepository.findByIdentification("1103452367");

        assertNotNull(result);
        assertEquals("1103452367", result.getIdentification());
        assertEquals("password", result.getPassword());
        assertEquals("true", result.getState());
        assertEquals("John Doe", result.getName());
        assertEquals("Loja", result.getAddress());
        assertEquals(50, result.getAge());
        assertEquals("0993425678", result.getPhone());
    }

    @Test
    @DisplayName("shouldReturnEmpty_whenCustomerSearchById_thenCustomerDoesNotExistInDatabase")
    void findById_CustomerDoesNotExist_ReturnsEmpty() {

        CustomerEntity result = customerJpaRepository.findById("999").orElse(null);

        assertEquals(null, result);
    }
}
