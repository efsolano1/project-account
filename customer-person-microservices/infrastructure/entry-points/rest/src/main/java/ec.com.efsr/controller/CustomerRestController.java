package ec.com.efsr.controller;

import ec.com.efsr.dto.CustomerInDto;
import ec.com.efsr.dto.CustomerOutDto;
import ec.com.efsr.mediator.CustomerMediator;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerRestController {
    private final CustomerMediator customerMediator;

    public CustomerRestController(CustomerMediator customerMediator) {
        this.customerMediator = customerMediator;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerOutDto> getCustomerById(@PathVariable String id) {
        var response = customerMediator.findCustomerById(id);
        return response != null ?
                ResponseEntity.status(200).body(response) :
                ResponseEntity.status(404).build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerOutDto>> getAllCustomers() {
        List<CustomerOutDto> response = customerMediator.findAllCustomers();
        return response.isEmpty() ?
                ResponseEntity.status(204).build() :
                ResponseEntity.status(200).body(response);
    }

    @PostMapping
    public ResponseEntity<CustomerOutDto> createCustomer(@RequestBody @Valid CustomerInDto customerInDto) {
        var response = customerMediator.saveCustomer(customerInDto);
        return response != null ?
                ResponseEntity.status(201).body(response) :
                ResponseEntity.status(500).build();
    }

    @PutMapping
    public ResponseEntity<CustomerOutDto> updateCustomer(@RequestBody @Valid CustomerInDto customerInDto) {
        var response = customerMediator.updateCustomer(customerInDto);
        return response != null ?
                ResponseEntity.status(200).body(response) :
                ResponseEntity.status(500).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
        var response = customerMediator.deleteCustomer(id);
        return response != null ?
                ResponseEntity.status(200).body(response) :
                ResponseEntity.status(500).build();
    }
}
