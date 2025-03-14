package ec.com.efsr.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${projectaccount.name_exchange}")
    private String exchangeName;

    @Value("${projectaccount.name_queue}")
    private String queueName;

    @Value("${projectaccount.name_routing_key}")
    private String routingKey;

    @Bean
    public TopicExchange createExchange() {
        return new TopicExchange(exchangeName, true, false);
    }

    @Bean
    public Queue createQueue() {
        return new Queue(queueName, true);
    }

    @Bean
    public Binding createBinding() {
        return BindingBuilder.bind(createQueue())
                .to(createExchange())
                .with(routingKey);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> initializeAmqpAdmin(AmqpAdmin amqpAdmin) {
        return event -> {
            amqpAdmin.declareExchange(createExchange());
            amqpAdmin.declareQueue(createQueue());
            amqpAdmin.declareBinding(createBinding());
        };
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate configureRabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
