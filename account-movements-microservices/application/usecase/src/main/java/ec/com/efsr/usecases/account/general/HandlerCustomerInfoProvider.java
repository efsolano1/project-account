package ec.com.efsr.usecases.account.general;

import ec.com.efsr.exceptions.CustomerNotFoundException;
import ec.com.efsr.repository.ISendAndReceiveInformation;
import ec.com.efsr.usecases.account.CustomerInfoProvider;
import org.springframework.stereotype.Component;

@Component
public class HandlerCustomerInfoProvider implements CustomerInfoProvider {
    private final ISendAndReceiveInformation sendAndReceiveInformation;

    public HandlerCustomerInfoProvider(ISendAndReceiveInformation sendAndReceiveInformation) {
        this.sendAndReceiveInformation = sendAndReceiveInformation;
    }

    @Override
    public String getCustomerInfo(String idCustomer) {
        Object response;
        String responseData;

        response = sendAndReceiveInformation.sendAndReceiveInformation(idCustomer);
        responseData = (String) response;

        if (response == null || response == "" || responseData == null || responseData == "") {
            throw new CustomerNotFoundException("No se pudo obtener informacion del cliente");
        }
        return responseData;
    }
}
