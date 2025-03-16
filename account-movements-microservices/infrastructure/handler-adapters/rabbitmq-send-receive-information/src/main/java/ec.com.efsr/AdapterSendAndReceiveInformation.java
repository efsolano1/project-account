package ec.com.efsr;

import ec.com.efsr.repository.ISendAndReceiveInformation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdapterSendAndReceiveInformation implements ISendAndReceiveInformation {
    private final RabbitTemplate rabbitTemplate;

    @Value("${projectaccount.name_exchange}")
    private String exchangeName;

    @Value("${projectaccount.name_routing_key}")
    private String routingKey;

    public AdapterSendAndReceiveInformation(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public String sendAndReceiveInformation(String information) {
        Object response = rabbitTemplate.convertSendAndReceive(
                exchangeName,
                routingKey,
                information
        );
       return   response != null ? response.toString(): null;
    }
}
