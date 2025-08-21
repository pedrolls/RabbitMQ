package com.example.demo_rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConfiguration {

    @Autowired
    private Properties properties;

    @Bean
    public Queue criarFilaPedidoPendente(){
        return QueueBuilder.durable(properties.getFilaPedidoPendente()).build();
    }

    @Bean
    public RabbitAdmin criarRabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializarAdmin(RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public FanoutExchange criarExchangePedidoPendente(){
        return ExchangeBuilder.fanoutExchange(properties.getExchangePedidoPendente()).build();
    }

    @Bean
    public Binding criarBidingPedidoPendente(){
        return BindingBuilder.bind(criarFilaPedidoPendente()).to(criarExchangePedidoPendente());
    }

    //Criando proprio RabbitTemplate devido o SimpleMessageConverter nao funcionar com meu objeto no envio para exchange

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMessageConverter(this.jackson2JsonMessageConverter());

        return rabbitTemplate;
    }

    //Criando Bean do Jackson2JsonMessage para substituir o SimpleMessaConverter

    @Bean
    public MessageConverter jackson2JsonMessageConverter(){ //Extends MessageConverter
        return new Jackson2JsonMessageConverter();
    }
}
