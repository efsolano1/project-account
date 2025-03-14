package ec.com.efsr.mediator;

import ec.com.efsr.dto.CustomerInDto;
import ec.com.efsr.dto.CustomerOutDto;

import ec.com.efsr.mapper.CustomerMapper;
import ec.com.efsr.usecases.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMediator {
    private final IFindCustomerByIdInteractor findCustomerByIdInteractor;
    private final IFindAllCustomersInteractor findAllCustomersInteractor;
    private final ISaveCustomerInteractor saveCustomerInteractor;
    private final IUpdateCustomerInteractor updateCustomerInteractor;
    private final IDeleteCustomerInteractor deleteCustomerInteractor;

    public CustomerMediator(IFindCustomerByIdInteractor findCustomerByIdInteractor, IFindAllCustomersInteractor findAllCustomersInteractor, ISaveCustomerInteractor saveCustomerInteractor, IUpdateCustomerInteractor updateCustomerInteractor, IDeleteCustomerInteractor deleteCustomerInteractor) {
        this.findCustomerByIdInteractor = findCustomerByIdInteractor;
        this.findAllCustomersInteractor = findAllCustomersInteractor;
        this.saveCustomerInteractor = saveCustomerInteractor;
        this.updateCustomerInteractor = updateCustomerInteractor;
        this.deleteCustomerInteractor = deleteCustomerInteractor;
    }

    public CustomerOutDto findCustomerById(String id) {
        return CustomerMapper.customerToCustomerOutDTO(findCustomerByIdInteractor.findCustomerById(id));
    }

    public List<CustomerOutDto> findAllCustomers() {
        return findAllCustomersInteractor.findAllCustomers()
                .stream()
                .map(CustomerMapper::customerToCustomerOutDTO)
                .collect(Collectors.toList());
    }

    public CustomerOutDto saveCustomer(CustomerInDto customerInDto) {
        return CustomerMapper.customerToCustomerOutDTO(saveCustomerInteractor.saveCustomer(CustomerMapper.customerInDtoToCustomer(customerInDto)));
    }

    public CustomerOutDto updateCustomer(CustomerInDto customerInDto){
        return CustomerMapper.customerToCustomerOutDTO(updateCustomerInteractor.updateCustomer(CustomerMapper.customerInDtoToCustomer(customerInDto)));
    }

    public String deleteCustomer(String id){
        deleteCustomerInteractor.deleteCustomer(id);
        return "Se elimino correctamente";
    }
}
