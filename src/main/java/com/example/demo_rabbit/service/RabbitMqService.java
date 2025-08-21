package com.example.demo_rabbit.service;

import com.example.demo_rabbit.config.Properties;
import com.example.demo_rabbit.model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RabbitMqService {

    private RabbitTemplate rabbitTemplate;

    private Properties properties;

    public void notificarPedidoPendente(Usuario usuario){

        this.rabbitTemplate.convertAndSend(properties.getExchangePedidoPendente(),"", usuario);
    }
}
