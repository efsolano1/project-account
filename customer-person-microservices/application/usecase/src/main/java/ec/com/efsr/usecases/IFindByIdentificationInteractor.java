package ec.com.efsr.usecases;

import ec.com.efsr.models.Customer;

public interface IFindByIdentificationInteractor {
    Customer findCustomerByIdentification(String id);
}
