package ec.com.efsr;

import ec.com.efsr.models.Customer;
import ec.com.efsr.repository.IInformationListener;
import ec.com.efsr.usecases.IFindCustomerByIdInteractor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InformationListener implements IInformationListener {
    private final IFindCustomerByIdInteractor findCustomerByIdInteractor;

    @Value("${projectaccount.name_queue}")
    private String queueName;

    public InformationListener(IFindCustomerByIdInteractor findCustomerByIdInteractor) {
        this.findCustomerByIdInteractor = findCustomerByIdInteractor;
    }

    @Override
    @RabbitListener(queues = "${projectaccount.name_queue}")
    public String receiveInformation(String information) {
        try{
            Customer customer = findCustomerByIdInteractor.findCustomerById(information);
            return customer.getIdCustomer()+"-"+customer.getName();
        }catch(Exception e){
            System.out.println("Error en consulta del cliente "+e.getMessage());
            return "";
        }

    }
}
