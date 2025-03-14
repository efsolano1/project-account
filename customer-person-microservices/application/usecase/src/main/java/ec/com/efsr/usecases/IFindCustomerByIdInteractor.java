package ec.com.efsr.usecases;

import ec.com.efsr.models.Customer;
import org.springframework.stereotype.Service;

@Service
public interface IFindCustomerByIdInteractor {
    Customer findCustomerById(String id);

}
