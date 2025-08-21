package com.example.demo_rabbit.model.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioRequestDTO {

    private String cpf;

    private String nome;

    private String telefone;

    private BigDecimal valorSolicitado;

}
