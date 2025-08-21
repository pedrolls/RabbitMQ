package com.example.demo_rabbit.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    @JsonBackReference
    private Usuario usuario;

    @NotNull
    @NotEmpty
    private BigDecimal valorSolicitado;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataDeSolicitacao;

    private boolean isPendente = true;

    private boolean isAprovado;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setValorSolicitado(BigDecimal valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    public void setDataDeSolicitacao(LocalDateTime dataDeSolicitacao) {
        this.dataDeSolicitacao = dataDeSolicitacao;
    }

    public void setPendente(boolean pendente) {
        isPendente = pendente;
    }

    public void setAprovado(boolean aprovado) {
        isAprovado = aprovado;
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public BigDecimal getValorSolicitado() {
        return valorSolicitado;
    }

    public LocalDateTime getDataDeSolicitacao() {
        return dataDeSolicitacao;
    }

    public boolean isPendente() {
        return isPendente;
    }

    public boolean isAprovado() {
        return isAprovado;
    }
}
