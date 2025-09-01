package com.example.demo_rabbit.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDTO {

    @NotNull
    @NotEmpty
    @Size(min = 11, max = 11, message = "O CPF deve conter 11 dígitos.")
    private String cpf;

    @NotNull(message = "O nome deve ser informado")
    @NotEmpty(message = "O nome deve ser informado")
    @Size(min = 3, message = "O nome deve ter pelo menos três letras")
    private String nome;

    @NotNull(message = "Preencha um telefone")
    @NotEmpty(message = "Preencha um telefone")
    @Size(min = 11, max = 11, message = "O telefone deve ser informado com DDD. Ex: 81998876655")
    private String telefone;

    @NotNull(message = "O valor deve ser preechido")
    private BigDecimal valorSolicitado;

    @NotNull(message = "O valor da renda deve ser preechido")
    private BigDecimal renda;

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public BigDecimal getValorSolicitado() {
        return valorSolicitado;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setValorSolicitado(BigDecimal valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }
}
