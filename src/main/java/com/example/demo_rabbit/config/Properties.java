package com.example.demo_rabbit.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class Properties {

    @Value("${fila-ms-pedido-pendente}")
    private String filaPedidoPendente;

    @Value("${exchange-pedido-pendente}")
    private String exchangePedidoPendente;

}
