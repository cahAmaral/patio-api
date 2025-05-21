package com.motoflow.patio.challenge.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class VagaDTO {

    private Long id;

    @NotBlank(message = "Número é obrigatório")
    @Size(max = 10)
    private String numero;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 50)
    private String descricao;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
